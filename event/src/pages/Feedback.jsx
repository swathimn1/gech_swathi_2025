import React, { useEffect, useState } from "react";
import axios from "../api/axios";
import { getAuthHeader, API_ENDPOINTS } from "../config/api";
import Layout from "../components/Layout";
import "bootstrap/dist/css/bootstrap.min.css";

export default function Feedback() {
  const [feedbacks, setFeedbacks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [showModal, setShowModal] = useState(false);
  const [editingFeedback, setEditingFeedback] = useState(null);
  const [error, setError] = useState("");

  const [formData, setFormData] = useState({
    stallName: "",
    rating: 5,
    category: "Food",
    comments: "",
    visitDate: new Date().toISOString().split("T")[0],
  });

  const rawUser = localStorage.getItem("user");
  const parsedUser = rawUser ? JSON.parse(rawUser) : null;
  const userId = parsedUser?.id || parsedUser?.userId || null;

  const fetchFeedbacks = async () => {
    setLoading(true);
    try {
      const res = await axios.get(API_ENDPOINTS.VISITOR.FEEDBACK, {
        headers: getAuthHeader(),
      });

      const list = Array.isArray(res.data) ? res.data : [];

      // Filter by logged-in visitor
      setFeedbacks(
        userId ? list.filter((f) => f.userId === userId) : list
      );
    } catch (err) {
      console.error("Error fetching feedbacks:", err);
      setError("Failed to load feedbacks.");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchFeedbacks();
  }, []);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const payload = {
      ...formData,
      rating: Number(formData.rating),
      userId: userId,           // backend expects "userId"
    };

    try {
      if (editingFeedback) {
        await axios.put(
          `${API_ENDPOINTS.VISITOR.FEEDBACK}/${editingFeedback.id}`,
          payload,
          { headers: getAuthHeader() }
        );
      } else {
        await axios.post(API_ENDPOINTS.VISITOR.FEEDBACK, payload, {
          headers: getAuthHeader(),
        });
      }

      resetForm();
      fetchFeedbacks();
    } catch (err) {
      console.error("Error saving feedback:", err);
      setError("Failed to save feedback.");
    }
  };

  const handleEdit = (fb) => {
    setEditingFeedback(fb);

    setFormData({
      stallName: fb.stallName || "",
      rating: fb.rating,
      category: fb.category,
      comments: fb.comments || "",
      visitDate: fb.visitDate,
    });

    setShowModal(true);
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Delete this feedback?")) return;

    try {
      await axios.delete(`${API_ENDPOINTS.VISITOR.FEEDBACK}/${id}`, {
        headers: getAuthHeader(),
      });

      fetchFeedbacks();
    } catch (err) {
      console.error("Error deleting feedback:", err);
      setError("Failed to delete feedback.");
    }
  };

  const resetForm = () => {
    setShowModal(false);
    setEditingFeedback(null);

    setFormData({
      stallName: "",
      rating: 5,
      category: "Food",
      comments: "",
      visitDate: new Date().toISOString().split("T")[0],
    });
  };

  const renderStars = (rating) =>
    [...Array(5)].map((_, i) => (
      <span
        key={i}
        style={{
          color: i < rating ? "#ffc107" : "#e0e0e0",
          fontSize: "1.1rem",
        }}
      >
        ★
      </span>
    ));

  return (
    <Layout title="Visitor Feedback">
      <div className="container my-4 text-dark">
        <div className="d-flex justify-content-between align-items-center mb-4">
          <h2>My Feedback</h2>
          <button className="btn btn-warning" onClick={() => setShowModal(true)}>
            + Add Feedback
          </button>
        </div>

        {error && <div className="alert alert-danger">{error}</div>}

        {loading ? (
          <div className="text-center py-5">
            <div className="spinner-border text-warning" role="status"></div>
          </div>
        ) : feedbacks.length === 0 ? (
          <div className="alert alert-info text-center">No feedbacks yet.</div>
        ) : (
          <div className="row">
            {feedbacks.map((fb) => (
              <div key={fb.id} className="col-md-6 col-lg-4 mb-4">
                <div className="card shadow-sm h-100">
                  <div className="card-body">
                    <h5 className="card-title">{fb.stallName}</h5>
                    <div className="mb-2">{renderStars(Number(fb.rating))}</div>

                    <p className="text-muted small">{fb.comments}</p>

                    <p className="text-muted small">
                      <strong>Category:</strong> {fb.category}
                      <br />
                      <strong>Visit Date:</strong> {fb.visitDate}
                    </p>

                    <div className="d-flex justify-content-between">
                      <button
                        className="btn btn-sm btn-outline-warning"
                        onClick={() => handleEdit(fb)}
                      >
                        Edit
                      </button>
                      <button
                        className="btn btn-sm btn-outline-danger"
                        onClick={() => handleDelete(fb.id)}
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
      </div>

      {showModal && (
        <div className="modal show d-block" style={{ backgroundColor: "rgba(0,0,0,0.5)" }}>
          <div className="modal-dialog modal-dialog-centered">
            <div className="modal-content text-dark">
              <div className="modal-header">
                <h5 className="modal-title">
                  {editingFeedback ? "Edit Feedback" : "Add Feedback"}
                </h5>
                <button className="btn-close" onClick={resetForm}></button>
              </div>

              <form onSubmit={handleSubmit}>
                <div className="modal-body">
                  {/* Stall Name */}
                  <div className="mb-3">
                    <label className="form-label">Stall Name</label>
                    <input
                      type="text"
                      name="stallName"
                      className="form-control"
                      value={formData.stallName}
                      onChange={handleChange}
                      required
                    />
                  </div>

                  {/* Rating */}
                  <div className="mb-3">
                    <label className="form-label">Rating</label>
                    <select
                      name="rating"
                      className="form-select"
                      value={formData.rating}
                      onChange={handleChange}
                    >
                      {[1, 2, 3, 4, 5].map((r) => (
                        <option key={r} value={r}>
                          {r} Star{r > 1 ? "s" : ""}
                        </option>
                      ))}
                    </select>
                  </div>

                  {/* Category */}
                  <div className="mb-3">
                    <label className="form-label">Category</label>
                    <select
                      name="category"
                      className="form-select"
                      value={formData.category}
                      onChange={handleChange}
                    >
                      <option>Food</option>
                      <option>Games</option>
                      <option>Shopping</option>
                      <option>Other</option>
                    </select>
                  </div>

                  {/* Comments */}
                  <div className="mb-3">
                    <label className="form-label">Comments</label>
                    <textarea
                      name="comments"
                      className="form-control"
                      rows="3"
                      value={formData.comments}
                      onChange={handleChange}
                    ></textarea>
                  </div>

                  {/* Visit Date */}
                  <div className="mb-3">
                    <label className="form-label">Visit Date</label>
                    <input
                      type="date"
                      name="visitDate"
                      className="form-control"
                      value={formData.visitDate}
                      onChange={handleChange}
                    />
                  </div>
                </div>

                <div className="modal-footer">
                  <button type="button" className="btn btn-secondary" onClick={resetForm}>
                    Cancel
                  </button>
                  <button type="submit" className="btn btn-primary">
                    {editingFeedback ? "Update Feedback" : "Add Feedback"}
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      )}
    </Layout>
  );
}
