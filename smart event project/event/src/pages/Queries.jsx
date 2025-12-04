import React, { useState, useEffect } from "react";
import axios from "axios";
import Layout from "../components/Layout";
import { API_BASE_URL, API_ENDPOINTS, getAuthHeader } from "../config/api";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";


export default function Queries() {
  const navigate = useNavigate();
  const { user } = useAuth();
  const userId = localStorage.getItem("userId");

  const [events, setEvents] = useState([]);
  const [queries, setQueries] = useState([]);
  const [loading, setLoading] = useState(true);
  const [showModal, setShowModal] = useState(false);
  const [editingQuery, setEditingQuery] = useState(null);

  const [formData, setFormData] = useState({
    eventId: "",
    stallId: "",
    category: "",
    priority: "",
    status: "",
    description: "",
  });

  const handleBack = () => {
    if (!user || !user.role) {
      navigate("/login");
      return;
    }

    if (user.role === "ADMIN") navigate("/admin/dashboard");
    else if (user.role === "STALL_OWNER") navigate("/stall-owner/dashboard");
    else if (user.role === "VISITOR") navigate("/visitor/dashboard");
    else navigate("/login");
  };

  const formatDate = (dateStr) => {
    if (!dateStr) return "N/A";
    try {
      const d = new Date(dateStr);
      if (isNaN(d.getTime())) return "Invalid Date";
      return d.toLocaleString("en-IN", {
        day: "2-digit",
        month: "short",
        year: "numeric",
        hour: "2-digit",
        minute: "2-digit",
      });
    } catch (err) {
      return "Invalid Date";
    }
  };

  // Fetch events
  const fetchEvents = async () => {
    try {
      const res = await axios.get(
        `${API_BASE_URL}${API_ENDPOINTS.VISITOR.EVENTS}`,
        {
          headers: getAuthHeader(),
        }
      );
      setEvents(res.data || []);
    } catch (err) {
      console.error("Error fetching events:", err);
    }
  };

  // Fetch user queries
  const fetchQueries = async () => {
    if (!userId) return setLoading(false);
    try {
      setLoading(true);
      const res = await axios.get(
        `${API_BASE_URL}${API_ENDPOINTS.VISITOR.QUERIES_BY_USER(userId)}`,
        { headers: getAuthHeader() }
      );
      setQueries(res.data || []);
    } catch (err) {
      console.error("Error fetching queries:", err);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchEvents();
    fetchQueries();
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const openCreateModal = () => {
    setEditingQuery(null);
    setFormData({
      eventId: "",
      stallId: "",
      category: "",
      priority: "",
      status: "",
      description: "",
    });
    setShowModal(true);
  };

  const openEditModal = (q) => {
    setEditingQuery(q);
    setFormData({
      eventId: q.event?.id || "",
      stallId: q.stallId || "", 
      category: q.category || "",
      priority: q.priority || "",
      status: q.status || "",
      description: q.description || "",
    });
    setShowModal(true);
  };

  const deleteQuery = async (id) => {
    if (!window.confirm("Delete this query?")) return;

    try {
      await axios.delete(
        `${API_BASE_URL}${API_ENDPOINTS.VISITOR.DELETE_QUERY(id)}`,
        {
          headers: getAuthHeader(),
        }
      );
      fetchQueries();
    } catch (err) {
      console.error("Delete error:", err);
      alert("Could not delete query");
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!userId) return alert("You are not logged in");

    if (!formData.stallId) return alert("Please enter a stall ID");

    const payload = {
      eventId: formData.eventId || null,
      stallId: Number(formData.stallId),
      category: formData.category || null,
      priority: formData.priority || null,
      status: formData.status || null,
      description: formData.description || null,
      userId: Number(userId),
    };

    try {
      if (editingQuery) {
        await axios.put(
          `${API_BASE_URL}${API_ENDPOINTS.VISITOR.UPDATE_QUERY(
            editingQuery.id
          )}`,
          payload,
          { headers: getAuthHeader() }
        );
      } else {
        await axios.post(
          `${API_BASE_URL}${API_ENDPOINTS.VISITOR.CREATE_QUERY}`,
          payload,
          {
            headers: getAuthHeader(),
          }
        );
      }

      setShowModal(false);
      setEditingQuery(null);
      setFormData({
        eventId: "",
        stallId: "",
        category: "",
        priority: "",
        status: "",
        description: "",
      });

      fetchQueries();
    } catch (err) {
      console.error("Save error:", err);
      alert(
        "Could not save query: " + (err.response?.data?.message || err.message)
      );
    }
  };

  return (
    <Layout>
      <div className="container mt-4 mb-5">
        <div className="mb-3">
        <button className="btn btn-secondary" onClick={handleBack}>
          ⬅ Back to Dashboard
        </button>
        </div>
        <div className="d-flex justify-content-between align-items-center mb-4">
          <h2 className="fw-bold">Your Queries</h2>
          <button className="btn btn-primary" onClick={openCreateModal}>
            + New Query
          </button>
        </div>

        {loading ? (
          <p>Loading...</p>
        ) : queries.length === 0 ? (
          <p>No queries found.</p>
        ) : (
          <div className="row">
            {queries.map((q) => (
              <div className="col-md-6 mb-4" key={q.id}>
                <div
                  className="card shadow-sm h-100"
                  style={{ minHeight: "260px" }}
                >
                  <div className="card-body d-flex flex-column">
                    <h5 className="fw-bold">{q.event?.title || "No Event"}</h5>
                    <div className="mb-2">
                      <span className="badge bg-secondary me-2">
                        {q.category || "N/A"}
                      </span>
                      <span className="badge bg-warning text-dark me-2">
                        {q.priority || "N/A"}
                      </span>
                      <span className="badge bg-info text-dark">
                        {q.status || "N/A"}
                      </span>
                    </div>
                    <p className="mb-2"><strong>Stall ID:</strong> {q.stallId || "N/A"}</p>
                    <p className="flex-grow-1">{q.description || "No description"}</p>
                    <small className="text-muted">
                      Created: {formatDate(q.createdAt)} <br />
                      Updated: {formatDate(q.updatedAt)}
                    </small>
                    <div className="mt-3 d-flex justify-content-end">
                      <button
                        className="btn btn-sm btn-outline-primary me-2"
                        onClick={() => openEditModal(q)}
                      >
                        Edit
                      </button>
                      <button
                        className="btn btn-sm btn-outline-danger"
                        onClick={() => deleteQuery(q.id)}
                      >
                        Delete
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            ))}
          </div>
        )}

        {/* Modal */}
        {showModal && (
          <div
            className="modal show d-block"
            style={{ background: "rgba(0,0,0,0.5)" }}
          >
            <div className="modal-dialog modal-lg modal-dialog-centered">
              <div className="modal-content shadow-lg">
                <form onSubmit={handleSubmit}>
                  <div className="modal-header bg-primary text-white">
                    <h5 className="modal-title">
                      {editingQuery ? "Edit Query" : "Create Query"}
                    </h5>
                    <button
                      type="button"
                      className="btn-close btn-close-white"
                      onClick={() => setShowModal(false)}
                    />
                  </div>
                  <div className="modal-body p-4">
                    <div className="row g-3">
                      {/* Event */}
                      <div className="col-12">
                        <label className="form-label">Event *</label>
                        <select
                          name="eventId"
                          className="form-select"
                          required
                          value={formData.eventId || ""}
                          onChange={handleChange}
                        >
                          <option value="">Select an event...</option>
                          {events.map((event) => (
                            <option key={event.id} value={event.id}>
                              {event.title}
                            </option>
                          ))}
                        </select>
                      </div>

                      {/* Stall (manual entry) */}
                      <div className="col-12">
                        <label className="form-label">Stall ID *</label>
                        <input
                          type="text"
                          name="stallId"
                          className="form-control"
                          required
                          placeholder="Enter Stall ID"
                          value={formData.stallId || ""}
                          onChange={handleChange}
                        />
                      </div>

                      <div className="col-md-6">
                        <label className="form-label">Category</label>
                        <input
                          name="category"
                          className="form-control"
                          value={formData.category}
                          onChange={handleChange}
                        />
                      </div>

                      <div className="col-md-6">
                        <label className="form-label">Priority</label>
                        <select
                          name="priority"
                          className="form-select"
                          value={formData.priority}
                          onChange={handleChange}
                        >
                          <option value="">Select...</option>
                          <option>Low</option>
                          <option>Medium</option>
                          <option>High</option>
                        </select>
                      </div>

                      <div className="col-md-6">
                        <label className="form-label">Status</label>
                        <select
                          name="status"
                          className="form-select"
                          value={formData.status}
                          onChange={handleChange}
                        >
                          <option value="">Select...</option>
                          <option>Pending</option>
                          <option>In Progress</option>
                          <option>Resolved</option>
                        </select>
                      </div>

                      <div className="col-12">
                        <label className="form-label">Description</label>
                        <textarea
                          name="description"
                          className="form-control"
                          rows="4"
                          value={formData.description}
                          onChange={handleChange}
                        />
                      </div>
                    </div>
                  </div>
                  <div className="modal-footer">
                    <button
                      type="button"
                      className="btn btn-outline-secondary"
                      onClick={() => setShowModal(false)}
                    >
                      Cancel
                    </button>
                    <button type="submit" className="btn btn-primary">
                      {editingQuery ? "Update" : "Create"}
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        )}
      </div>
    </Layout>
  );
}