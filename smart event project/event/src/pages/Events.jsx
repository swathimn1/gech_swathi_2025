import React, { useEffect, useState } from "react";
import axios from "../api/axios";
import Layout from "../components/Layout";
import "bootstrap/dist/css/bootstrap.min.css";
import { API_ENDPOINTS, getAuthHeader } from "../config/api";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";

export default function Events() {
  const { user } = useAuth();
  const navigate = useNavigate();

  const [events, setEvents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [showModal, setShowModal] = useState(false);
  const [editingEvent, setEditingEvent] = useState(null);

  const [formData, setFormData] = useState({
    title: "",
    date: "",
    time: "",
    location: "",
    description: "",
    category: "Workshop",
  });

  useEffect(() => {
    fetchEvents();
  }, []);

  const formatDate = (isoString) => isoString?.split("T")[0] || "";
  const formatTime = (isoString) => isoString?.split("T")[1]?.substring(0, 5) || "";

  // Fetch all events
  const fetchEvents = async () => {
    try {
      setLoading(true);
      const res = await axios.get(API_ENDPOINTS.VISITOR.EVENTS, {
        headers: getAuthHeader(),
      });
      setEvents(res.data || []);
    } catch (error) {
      console.error("Error fetching events:", error);
      alert("❌ Failed to load events.");
    } finally {
      setLoading(false);
    }
  };

  // Handle form changes
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // Create or update an Event (Event table)
  const handleSubmit = async (e) => {
    e.preventDefault();
    const payload = {
      title: formData.title,
      date: formData.date,
      time: formData.time,
      location: formData.location,
      description: formData.description,
      category: formData.category,
    };

    try {
      if (editingEvent) {
        await axios.put(
          `${API_ENDPOINTS.VISITOR.EVENTS}/${editingEvent.id}`,
          payload,
          { headers: getAuthHeader() }
        );
        alert("✅ Event updated successfully!");
      } else {
        await axios.post(API_ENDPOINTS.VISITOR.EVENTS, payload, {
          headers: getAuthHeader(),
        });
        alert("✅ Event added successfully!");
      }

      resetForm();
      fetchEvents();
    } catch (error) {
      console.error("Error saving event:", error);
      alert("❌ Failed to save event.");
    }
  };

  // Bookmark an event for the current visitor
  const bookmarkEvent = async (eventId) => {
    try {
      const payload = {
        visitorId: user?.id, // your visitor/user id
        eventId: eventId,
      };

      await axios.post(API_ENDPOINTS.VISITOR.EVENTS, payload, {
        headers: getAuthHeader(),
      });

      alert("✅ Event bookmarked successfully!");
    } catch (error) {
      console.error("Error bookmarking event:", error);
      alert("❌ Failed to save event.");
    }
  };

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this event?")) {
      try {
        await axios.delete(`${API_ENDPOINTS.VISITOR.EVENTS}/${id}`, {
          headers: getAuthHeader(),
        });
        fetchEvents();
        alert("🗑️ Event deleted successfully!");
      } catch (error) {
        console.error("Error deleting event:", error);
        alert("❌ Failed to delete event.");
      }
    }
  };

  const handleEdit = (event) => {
    setEditingEvent(event);
    setFormData({
      title: event.title,
      date: formatDate(event.date),
      time: formatTime(event.time),
      location: event.location,
      description: event.description,
      category: event.category,
    });
    setShowModal(true);
  };

  const resetForm = () => {
    setFormData({
      title: "",
      date: "",
      time: "",
      location: "",
      description: "",
      category: "Workshop",
    });
    setEditingEvent(null);
    setShowModal(false);
  };

  const getCategoryColor = (category) => {
    const colors = {
      Workshop: "primary",
      Seminar: "success",
      Conference: "warning",
      Networking: "info",
      Other: "secondary",
    };
    return colors[category] || "secondary";
  };

  return (
    <Layout title="Visitor Events | Smart Event System">
      <div className="container my-4">

        {/* BACK TO HOME + ADD EVENT */}
        <div className="d-flex justify-content-between align-items-center mb-4">
          <h1 className="fw-bold text-white">🎟️ Explore Events</h1>
          <div className="d-flex gap-2">
            <button className="btn btn-outline-light fw-semibold" onClick={() => navigate("/")}>
              ⬅ Back to Home
            </button>
            <button className="btn btn-light fw-semibold" onClick={() => setShowModal(true)}>
              <i className="bi bi-plus-circle"></i> Add Event
            </button>
          </div>
        </div>

        {/* EVENTS LIST */}
        {loading ? (
          <div className="text-center py-5">
            <div className="spinner-border text-light"></div>
            <p className="mt-3 text-light fw-semibold">Loading events...</p>
          </div>
        ) : events.length === 0 ? (
          <div className="alert text-center fw-semibold mx-auto" style={{ background: "rgba(255,255,255,0.2)", backdropFilter: "blur(8px)", color: "#fff", borderRadius: "15px", maxWidth: "600px" }}>
            No events available right now.
          </div>
        ) : (
          <div className="row g-4">
            {events.map((ev) => (
              <div key={ev.id} className="col-md-6 col-lg-4">
                <div className="card h-100 border-0 shadow-lg" style={{ background: "rgba(255, 255, 255, 0.15)", borderRadius: "20px", backdropFilter: "blur(10px)", color: "#fff" }}>
                  <div className={`card-header bg-${getCategoryColor(ev.category)} text-white fw-bold`} style={{ borderTopLeftRadius: "20px", borderTopRightRadius: "20px" }}>
                    {ev.title}
                  </div>
                  <div className="card-body">
                    <p className="small mb-2">
                      <i className="bi bi-calendar-event"></i> {formatDate(ev.date)} |{" "}
                      <i className="bi bi-clock"></i> {formatTime(ev.time)}
                    </p>
                    <p className="small mb-2">
                      <i className="bi bi-geo-alt"></i> {ev.location}
                    </p>
                    <p className="text-light small">{ev.description}</p>
                    <span className={`badge bg-${getCategoryColor(ev.category)}`}>{ev.category}</span>
                  </div>
                  <div className="card-footer bg-transparent border-0 d-flex justify-content-between">
                    <button className="btn btn-sm btn-outline-warning" onClick={() => bookmarkEvent(ev.id)}>
                      <i className="bi bi-bookmark"></i> Bookmark
                    </button>
                    <button className="btn btn-sm btn-outline-light" onClick={() => handleEdit(ev)}>
                      <i className="bi bi-pencil"></i> Edit
                    </button>
                    <button className="btn btn-sm btn-outline-danger" onClick={() => handleDelete(ev.id)}>
                      <i className="bi bi-trash"></i> Delete
                    </button>
                  </div>
                </div>
              </div>
            ))}
          </div>
        )}

      </div>

      {/* ADD / EDIT MODAL */}
      {showModal && (
        <div className="modal show d-block" style={{ background: "rgba(0,0,0,0.5)" }}>
          <div className="modal-dialog modal-dialog-centered">
            <div className="modal-content text-dark">
              <div className="modal-header">
                <h5 className="modal-title">{editingEvent ? "Edit Event" : "Add New Event"}</h5>
                <button className="btn-close" onClick={resetForm}></button>
              </div>

              <form onSubmit={handleSubmit}>
                <div className="modal-body">
                  <div className="mb-3">
                    <label className="form-label">Event Title *</label>
                    <input type="text" className="form-control" name="title" value={formData.title} onChange={handleChange} required />
                  </div>

                  <div className="row">
                    <div className="col-md-6 mb-3">
                      <label className="form-label">Date *</label>
                      <input type="date" className="form-control" name="date" value={formData.date} onChange={handleChange} required />
                    </div>
                    <div className="col-md-6 mb-3">
                      <label className="form-label">Time *</label>
                      <input type="time" className="form-control" name="time" value={formData.time} onChange={handleChange} required />
                    </div>
                  </div>

                  <div className="mb-3">
                    <label className="form-label">Location *</label>
                    <input type="text" className="form-control" name="location" value={formData.location} onChange={handleChange} required />
                  </div>

                  <div className="mb-3">
                    <label className="form-label">Category *</label>
                    <select className="form-select" name="category" value={formData.category} onChange={handleChange} required>
                      <option value="Workshop">Workshop</option>
                      <option value="Seminar">Seminar</option>
                      <option value="Conference">Conference</option>
                      <option value="Networking">Networking</option>
                      <option value="Other">Other</option>
                    </select>
                  </div>

                  <div className="mb-3">
                    <label className="form-label">Description</label>
                    <textarea className="form-control" name="description" rows="3" value={formData.description} onChange={handleChange}></textarea>
                  </div>
                </div>

                <div className="modal-footer">
                  <button type="button" className="btn btn-secondary" onClick={resetForm}>Cancel</button>
                  <button type="submit" className="btn btn-primary">{editingEvent ? "Update Event" : "Add Event"}</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      )}

    </Layout>
  );
}
