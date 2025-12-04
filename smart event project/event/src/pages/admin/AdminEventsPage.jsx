import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Layout from "../../components/Layout";
import { adminEventService } from "../../services/adminEventService";
import { useToast } from "../../hooks/use-toast";

const AdminEventsPage = () => {
  const navigate = useNavigate();
  const { toast } = useToast();
  const [events, setEvents] = useState([]);
  const [loading, setLoading] = useState(false);
  const [editingId, setEditingId] = useState(null);

  const [form, setForm] = useState({
    title: "",
    description: "",
    location: "",
    startDate: "",
    endDate: "",
  });

  useEffect(() => {
    loadEvents();
  }, []);

  const loadEvents = async () => {
    setLoading(true);
    try {
      const res = await adminEventService.getAll();
      setEvents(Array.isArray(res.data) ? res.data : []);
    } catch (err) {
      toast({
        variant: "destructive",
        title: "Error",
        description: "Failed to load events",
      });
    } finally {
      setLoading(false);
    }
  };

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const eventData = {
      title: form.title,
      description: form.description,
      location: form.location,
      startDate: form.startDate,
      endDate: form.endDate,
    };

    try {
      if (editingId) {
        await adminEventService.update(editingId, eventData);
        toast({ title: "✅ Event updated successfully" });
      } else {
        await adminEventService.create(eventData);
        toast({ title: "🎉 Event created successfully" });
      }

      setForm({
        title: "",
        description: "",
        location: "",
        startDate: "",
        endDate: "",
      });

      setEditingId(null);
      loadEvents();
    } catch (err) {
      toast({
        variant: "destructive",
        title: "Error",
        description: "Failed to save event",
      });
    }
  };

  const handleEdit = (event) => {
    setForm({
      title: event.title || "",
      description: event.description || "",
      location: event.location || "",
      startDate: event.startDate || "",
      endDate: event.endDate || "",
    });
    setEditingId(event.id);
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Are you sure you want to delete this event?")) return;

    try {
      await adminEventService.delete(id);
      toast({ title: "🗑️ Event deleted successfully" });
      loadEvents();
    } catch (err) {
      toast({
        variant: "destructive",
        title: "Error",
        description: "Failed to delete event",
      });
    }
  };

  return (
    <Layout title="Admin | Manage Events">
      <div className="container py-4">

        {/* ✅ Back Button + Title - Matching ManageAttendance.jsx */}
        <div className="d-flex justify-content-between align-items-center mb-4">
          <button
            className="btn btn-light"
            onClick={() => navigate("/admin/dashboard")}
          >
            ← Back to Dashboard
          </button>

          <h2 className="fw-bold mb-0 text-white display-6">
            🎪 Manage Events
          </h2>

          {/* Spacer for centered title */}
          <div style={{ width: "150px" }}></div>
        </div>

        {/* Event Form */}
        <div
          className="p-4 mb-5"
          style={{
            background: "rgba(255,255,255,0.15)",
            borderRadius: "20px",
            backdropFilter: "blur(10px)",
            boxShadow: "0 8px 25px rgba(0,0,0,0.2)",
          }}
        >
          <h5 className="fw-bold mb-3 text-white">
            {editingId ? "✏️ Edit Event" : "➕ Create New Event"}
          </h5>

          <form onSubmit={handleSubmit}>
            <div className="row g-3">
              <div className="col-md-6">
                <input
                  name="title"
                  value={form.title}
                  onChange={handleChange}
                  className="form-control bg-transparent text-white border-light"
                  placeholder="Event Title"
                  required
                />
              </div>

              <div className="col-md-6">
                <input
                  name="location"
                  value={form.location}
                  onChange={handleChange}
                  className="form-control bg-transparent text-white border-light"
                  placeholder="Location"
                  required
                />
              </div>

              <div className="col-md-6">
                <input
                  name="startDate"
                  value={form.startDate}
                  onChange={handleChange}
                  className="form-control bg-transparent text-white border-light"
                  type="date"
                  required
                />
              </div>

              <div className="col-md-6">
                <input
                  name="endDate"
                  value={form.endDate}
                  onChange={handleChange}
                  className="form-control bg-transparent text-white border-light"
                  type="date"
                  required
                />
              </div>

              <div className="col-12">
                <textarea
                  name="description"
                  value={form.description}
                  onChange={handleChange}
                  className="form-control bg-transparent text-white border-light"
                  placeholder="Event Description"
                  rows={3}
                  required
                />
              </div>

              <div className="col-12 d-flex gap-2">
                <button
                  type="submit"
                  className="btn fw-bold px-4 shadow"
                  style={{
                    background:
                      "linear-gradient(90deg, #ff6b6b, #f7b42c, #4facfe)",
                    border: "none",
                    color: "#fff",
                  }}
                >
                  {editingId ? "Update Event" : "Create Event"}
                </button>

                {editingId && (
                  <button
                    type="button"
                    className="btn btn-light fw-semibold text-dark"
                    onClick={() => {
                      setForm({
                        title: "",
                        description: "",
                        location: "",
                        startDate: "",
                        endDate: "",
                      });
                      setEditingId(null);
                    }}
                  >
                    Cancel
                  </button>
                )}
              </div>
            </div>
          </form>
        </div>

        {/* Event List */}
        <div
          className="p-4"
          style={{
            background: "rgba(255,255,255,0.15)",
            borderRadius: "20px",
            backdropFilter: "blur(10px)",
            boxShadow: "0 8px 25px rgba(0,0,0,0.2)",
          }}
        >
          <h5 className="fw-bold mb-3 text-white">📅 All Events</h5>

          {loading ? (
            <div className="text-center py-4 text-light">Loading events...</div>
          ) : (
            <div className="table-responsive">
              <table className="table text-white align-middle">
                <thead
                  style={{
                    background: "rgba(255,255,255,0.1)",
                    borderBottom: "2px solid rgba(255,255,255,0.3)",
                  }}
                >
                  <tr>
                    <th>Title</th>
                    <th>Location</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th className="text-center">Actions</th>
                  </tr>
                </thead>

                <tbody>
                  {events.length > 0 ? (
                    events.map((event) => (
                      <tr key={event.id}>
                        <td>{event.title}</td>
                        <td>{event.location}</td>
                        <td>{event.startDate}</td>
                        <td>{event.endDate}</td>

                        <td className="text-center">
                          <button
                            className="btn btn-sm btn-warning me-2 fw-semibold"
                            onClick={() => handleEdit(event)}
                          >
                            Edit
                          </button>

                          <button
                            className="btn btn-sm btn-danger fw-semibold"
                            onClick={() => handleDelete(event.id)}
                          >
                            Delete
                          </button>
                        </td>
                      </tr>
                    ))
                  ) : (
                    <tr>
                      <td colSpan="5" className="text-center py-3 text-light">
                        No events found.
                      </td>
                    </tr>
                  )}
                </tbody>

              </table>
            </div>
          )}
        </div>
      </div>
    </Layout>
  );
};

export default AdminEventsPage;
