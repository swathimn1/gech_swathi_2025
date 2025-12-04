import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom"; // ⭐ Added
import Layout from "../components/Layout";
import axios from "../api/axios";
import { getAuthHeader, API_ENDPOINTS } from "../config/api";

const FeedbackManagement = () => {
  const navigate = useNavigate(); // ⭐ Added

  const [feedbacks, setFeedbacks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [showModal, setShowModal] = useState(false);
  const [viewingFeedback, setViewingFeedback] = useState(null);
  const [deleteConfirm, setDeleteConfirm] = useState(null);
  const [filterRating, setFilterRating] = useState("all");

  // Fetch REAL feedback saved by visitors
  const fetchFeedbacks = async () => {
    try {
      const res = await axios.get(API_ENDPOINTS.VISITOR.FEEDBACK, {
        headers: getAuthHeader(),
      });

      const list = Array.isArray(res.data) ? res.data : [];

      const mapped = list.map((fb) => ({
        id: fb.id,
        eventName: fb.stallName,
        rating: fb.rating,
        comment: fb.comments,
        submittedAt: fb.visitDate,
      }));

      setFeedbacks(mapped);
    } catch (error) {
      console.error("Failed to fetch feedback:", error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchFeedbacks();
  }, []);

  const handleViewFeedback = (feedback) => {
    setViewingFeedback(feedback);
    setShowModal(true);
  };

  const handleCloseModal = () => {
    setShowModal(false);
    setViewingFeedback(null);
  };

  const handleDelete = async (feedbackId) => {
    try {
      await axios.delete(`${API_ENDPOINTS.VISITOR.FEEDBACK}/${feedbackId}`, {
        headers: getAuthHeader(),
      });

      setFeedbacks(feedbacks.filter((f) => f.id !== feedbackId));
      setDeleteConfirm(null);
      alert("Feedback deleted successfully!");
    } catch (error) {
      console.error("Failed to delete feedback:", error);
      alert("Failed to delete feedback");
    }
  };

  const formatDate = (dateString) => {
    const date = new Date(dateString);
    return date.toLocaleDateString("en-US", {
      year: "numeric",
      month: "short",
      day: "numeric",
    });
  };

  const renderStars = (rating) => (
    <span className="text-warning">
      {[...Array(5)].map((_, i) => (
        <span key={i}>{i < rating ? "★" : "☆"}</span>
      ))}
    </span>
  );

  const filteredFeedbacks =
    filterRating === "all"
      ? feedbacks
      : feedbacks.filter((f) => f.rating === parseInt(filterRating));

  const averageRating =
    feedbacks.length > 0
      ? (
          feedbacks.reduce((sum, f) => sum + f.rating, 0) / feedbacks.length
        ).toFixed(1)
      : 0;

  return (
    <Layout title="Feedback Management">
      <div className="container py-4">
        {/* ⭐ Back Button */}
        <div className="mb-3">
          <button
            className="btn btn-secondary"
            onClick={() => navigate("/admin/dashboard")}
          >
            ⬅ Back to Dashboard
          </button>
        </div>

        <div className="row mb-4">
          <div className="col">
            <h2 className="mb-0 fw-bold">Feedback & Ratings</h2>
            <p className="text-muted mb-0">View and manage visitor feedback</p>
          </div>
        </div>

        {/* Stats */}
        <div className="row mb-4">
          <div className="col-md-3 mb-3">
            <div className="card bg-primary text-white">
              <div className="card-body">
                <h6>Total Feedback</h6>
                <h2>{feedbacks.length}</h2>
              </div>
            </div>
          </div>

          <div className="col-md-3 mb-3">
            <div className="card bg-success text-white">
              <div className="card-body">
                <h6>Average Rating</h6>
                <h2>{averageRating} ★</h2>
              </div>
            </div>
          </div>

          <div className="col-md-3 mb-3">
            <div className="card bg-warning text-dark">
              <div className="card-body">
                <h6>5 Star Reviews</h6>
                <h2>{feedbacks.filter((f) => f.rating === 5).length}</h2>
              </div>
            </div>
          </div>

          <div className="col-md-3 mb-3">
            <div className="card bg-info text-white">
              <div className="card-body">
                <h6>Recent (24h)</h6>
                <h2>{feedbacks.length}</h2>
              </div>
            </div>
          </div>
        </div>

        {/* Filter */}
        <div className="card shadow-sm mb-4">
          <div className="card-body">
            <div className="row align-items-center">
              <div className="col-md-4">
                <label className="form-label mb-0">Filter by Rating:</label>
              </div>
              <div className="col-md-8">
                <select
                  className="form-select"
                  value={filterRating}
                  onChange={(e) => setFilterRating(e.target.value)}
                >
                  <option value="all">All Ratings</option>
                  <option value="5">5 Stars</option>
                  <option value="4">4 Stars</option>
                  <option value="3">3 Stars</option>
                  <option value="2">2 Stars</option>
                  <option value="1">1 Star</option>
                </select>
              </div>
            </div>
          </div>
        </div>

        {/* Table */}
        {loading ? (
          <div className="text-center py-5">
            <div className="spinner-border text-primary"></div>
          </div>
        ) : filteredFeedbacks.length === 0 ? (
          <div className="alert alert-info">No feedback found.</div>
        ) : (
          <div className="card shadow-sm">
            <div className="card-header bg-primary text-white">
              <h5 className="mb-0">
                Feedback List ({filteredFeedbacks.length})
              </h5>
            </div>

            <div className="table-responsive">
              <table className="table table-hover mb-0">
                <thead className="table-light">
                  <tr>
                    <th>ID</th>
                    <th>Stall</th>
                    <th>Rating</th>
                    <th>Comment</th>
                    <th>Date</th>
                    <th className="text-center">Actions</th>
                  </tr>
                </thead>

                <tbody>
                  {filteredFeedbacks.map((fb) => (
                    <tr key={fb.id}>
                      <td>{fb.id}</td>
                      <td>{fb.eventName}</td>
                      <td>{renderStars(fb.rating)}</td>
                      <td style={{ maxWidth: "220px" }}>
                        <div className="text-truncate">{fb.comment}</div>
                      </td>
                      <td>{formatDate(fb.submittedAt)}</td>
                      <td className="text-center">
                        <button
                          className="btn btn-sm btn-outline-primary me-2"
                          onClick={() => handleViewFeedback(fb)}
                        >
                          View
                        </button>

                        <button
                          className="btn btn-sm btn-outline-danger"
                          onClick={() => setDeleteConfirm(fb.id)}
                        >
                          Delete
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        )}

        {/* View Modal */}
        {showModal && viewingFeedback && (
          <div
            className="modal show d-block"
            style={{ backgroundColor: "rgba(0,0,0,0.5)" }}
          >
            <div className="modal-dialog modal-lg modal-dialog-centered">
              <div className="modal-content">
                <div className="modal-header bg-primary text-white">
                  <h5>Feedback Details</h5>
                  <button
                    className="btn-close btn-close-white"
                    onClick={handleCloseModal}
                  ></button>
                </div>

                <div className="modal-body">
                  <p>
                    <strong>Stall:</strong> {viewingFeedback.eventName}
                  </p>
                  <p>
                    <strong>Rating:</strong>{" "}
                    {renderStars(viewingFeedback.rating)}
                  </p>
                  <p>
                    <strong>Comment:</strong> {viewingFeedback.comment}
                  </p>
                  <p>
                    <strong>Date:</strong>{" "}
                    {formatDate(viewingFeedback.submittedAt)}
                  </p>
                </div>

                <div className="modal-footer">
                  <button
                    className="btn btn-secondary"
                    onClick={handleCloseModal}
                  >
                    Close
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={() => {
                      handleCloseModal();
                      setDeleteConfirm(viewingFeedback.id);
                    }}
                  >
                    Delete
                  </button>
                </div>
              </div>
            </div>
          </div>
        )}

        {/* Delete Modal */}
        {deleteConfirm && (
          <div
            className="modal show d-block"
            style={{ backgroundColor: "rgba(0,0,0,0.5)" }}
          >
            <div className="modal-dialog modal-dialog-centered">
              <div className="modal-content">
                <div className="modal-header bg-danger text-white">
                  <h5>Confirm Delete</h5>
                  <button
                    className="btn-close btn-close-white"
                    onClick={() => setDeleteConfirm(null)}
                  ></button>
                </div>

                <div className="modal-body">
                  <p>Are you sure you want to delete this feedback?</p>
                </div>

                <div className="modal-footer">
                  <button
                    className="btn btn-secondary"
                    onClick={() => setDeleteConfirm(null)}
                  >
                    Cancel
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={() => handleDelete(deleteConfirm)}
                  >
                    Delete
                  </button>
                </div>
              </div>
            </div>
          </div>
        )}
      </div>
    </Layout>
  );
};

export default FeedbackManagement;
