import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Layout from "../../components/Layout";
import { API_BASE_URL, API_ENDPOINTS, getAuthHeader } from "../../config/api";

const Notifications = () => {
  const navigate = useNavigate();
  const [notifications, setNotifications] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [formData, setFormData] = useState({
    title: "",
    message: "",
    priority: "normal",
    category: "general",
  });

  // ✅ Fetch all notifications from backend
  useEffect(() => {
    fetch(`${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.NOTIFICATIONS}`, {
      headers: getAuthHeader(),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to fetch notifications");
        return res.json();
      })
      .then((data) => setNotifications(data))
      .catch((err) => console.error(err));
  }, []);

  // ✅ Create new notification
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await fetch(`${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.NOTIFICATIONS}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          ...getAuthHeader(),
        },
        body: JSON.stringify(formData),
      });

      if (!res.ok) throw new Error("Failed to create notification");
      const newNotification = await res.json();

      setNotifications([newNotification, ...notifications]);
      setShowModal(false);
      setFormData({ title: "", message: "", priority: "normal", category: "general" });
    } catch (err) {
      console.error(err);
    }
  };

  // ✅ Mark as read
  const markAsRead = async (id) => {
    try {
      const res = await fetch(
        `${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.NOTIFICATIONS}/${id}/read`,
        {
          method: "PUT",
          headers: getAuthHeader(),
        }
      );
      if (!res.ok) throw new Error("Failed to mark as read");
      const updated = await res.json();
      setNotifications((prev) => prev.map((n) => (n.id === id ? updated : n)));
    } catch (err) {
      console.error(err);
    }
  };

  // ✅ Mark all as read
  const markAllAsRead = async () => {
    try {
      const res = await fetch(
        `${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.NOTIFICATIONS}/mark-all-read`,
        {
          method: "PUT",
          headers: getAuthHeader(),
        }
      );
      if (!res.ok) throw new Error("Failed to mark all read");
      const updated = await res.json();
      setNotifications(updated);
    } catch (err) {
      console.error(err);
    }
  };

  // ✅ Delete notification
  const deleteNotification = async (id) => {
    if (!window.confirm("Are you sure you want to delete this notification?")) return;

    try {
      const res = await fetch(
        `${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.NOTIFICATIONS}/${id}`,
        {
          method: "DELETE",
          headers: getAuthHeader(),
        }
      );
      if (!res.ok) throw new Error("Failed to delete notification");
      setNotifications((prev) => prev.filter((n) => n.id !== id));
    } catch (err) {
      console.error(err);
    }
  };

  // ✅ Helpers
  const getPriorityBadge = (priority) => {
    switch (priority) {
      case "high":
        return "bg-danger";
      case "medium":
        return "bg-warning text-dark";
      default:
        return "bg-info";
    }
  };

  const getCategoryIcon = (category) => {
    switch (category) {
      case "event":
        return "🎪";
      case "alert":
        return "⚠️";
      case "update":
        return "📢";
      default:
        return "📋";
    }
  };

  const unreadCount = notifications.filter((n) => !n.read).length;

  return (
    <Layout title="Notifications | Smart Event System">
      <div className="container py-4">
        <div className="d-flex justify-content-between align-items-center mb-4 flex-wrap gap-2">
          <button className="btn btn-light" onClick={() => navigate("/stall-owner/dashboard")}>
            ← Back to Dashboard
          </button>
          <h2 className="text-white mb-0">
            🔔 Notifications
            {unreadCount > 0 && (
              <span className="badge bg-danger ms-2">{unreadCount}</span>
            )}
          </h2>
          <div className="d-flex gap-2">
            {unreadCount > 0 && (
              <button className="btn btn-info" onClick={markAllAsRead}>
                ✓ Mark All Read
              </button>
            )}
            <button className="btn btn-danger" onClick={() => setShowModal(true)}>
              + New Alert
            </button>
          </div>
        </div>

        <div className="row g-3">
          {notifications.length === 0 ? (
            <div className="col-12">
              <div className="card shadow-lg">
                <div className="card-body text-center py-5">
                  <p className="text-muted">No notifications yet.</p>
                </div>
              </div>
            </div>
          ) : (
            notifications.map((notification) => (
              <div key={notification.id} className="col-12">
                <div
                  className={`card shadow ${!notification.read ? "border-primary border-2" : ""}`}
                >
                  <div className="card-body">
                    <div className="d-flex justify-content-between align-items-start">
                      <div className="flex-grow-1">
                        <div className="d-flex align-items-center mb-2 flex-wrap gap-2">
                          <span className="me-2" style={{ fontSize: "1.5rem" }}>
                            {getCategoryIcon(notification.category)}
                          </span>
                          <h5 className="mb-0">{notification.title}</h5>
                          <span
                            className={`badge ${getPriorityBadge(notification.priority)}`}
                          >
                            {notification.priority}
                          </span>
                          {!notification.read && (
                            <span className="badge bg-primary">NEW</span>
                          )}
                        </div>
                        <p className="mb-2">{notification.message}</p>
                        <small className="text-muted">
                          📅 {new Date(notification.timestamp).toLocaleString()}
                        </small>
                      </div>
                      <div className="d-flex gap-2 ms-3">
                        {!notification.read && (
                          <button
                            className="btn btn-sm btn-success"
                            onClick={() => markAsRead(notification.id)}
                            title="Mark as read"
                          >
                            ✓
                          </button>
                        )}
                        <button
                          className="btn btn-sm btn-danger"
                          onClick={() => deleteNotification(notification.id)}
                          title="Delete"
                        >
                          🗑️
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            ))
          )}
        </div>

        {/* ✅ Modal for New Notification */}
        {showModal && (
          <div className="modal show d-block" style={{ backgroundColor: "rgba(0,0,0,0.5)" }}>
            <div className="modal-dialog">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title">Create New Notification</h5>
                  <button className="btn-close" onClick={() => setShowModal(false)}></button>
                </div>
                <form onSubmit={handleSubmit}>
                  <div className="modal-body">
                    <div className="mb-3">
                      <label className="form-label">Title *</label>
                      <input
                        type="text"
                        className="form-control"
                        value={formData.title}
                        onChange={(e) => setFormData({ ...formData, title: e.target.value })}
                        required
                      />
                    </div>
                    <div className="mb-3">
                      <label className="form-label">Message *</label>
                      <textarea
                        className="form-control"
                        rows="4"
                        value={formData.message}
                        onChange={(e) => setFormData({ ...formData, message: e.target.value })}
                        required
                      />
                    </div>
                    <div className="mb-3">
                      <label className="form-label">Priority *</label>
                      <select
                        className="form-select"
                        value={formData.priority}
                        onChange={(e) => setFormData({ ...formData, priority: e.target.value })}
                      >
                        <option value="normal">Normal</option>
                        <option value="medium">Medium</option>
                        <option value="high">High</option>
                      </select>
                    </div>
                    <div className="mb-3">
                      <label className="form-label">Category *</label>
                      <select
                        className="form-select"
                        value={formData.category}
                        onChange={(e) => setFormData({ ...formData, category: e.target.value })}
                      >
                        <option value="general">General</option>
                        <option value="event">Event</option>
                        <option value="alert">Alert</option>
                        <option value="update">Update</option>
                      </select>
                    </div>
                  </div>
                  <div className="modal-footer">
                    <button type="button" className="btn btn-secondary" onClick={() => setShowModal(false)}>
                      Cancel
                    </button>
                    <button type="submit" className="btn btn-danger">
                      Create Notification
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
};

export default Notifications;
