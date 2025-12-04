import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Layout from "../../components/Layout";
import { API_BASE_URL, API_ENDPOINTS, getAuthHeader } from "../../config/api";

const UploadResults = () => {
  const navigate = useNavigate();
  const [results, setResults] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [formData, setFormData] = useState({
    title: "",
    date: "",
    description: "",
    performance: "",
    revenue: "",
  });

  // ✅ Fetch all results from backend
  const fetchResults = async () => {
    try {
      const res = await fetch(
        `${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.UPLOADRESULTS}`,
        {
          headers: getAuthHeader(),
        }
      );
      if (res.ok) {
        const data = await res.json();
        setResults(data);
      } else {
        console.error("Failed to fetch results");
      }
    } catch (err) {
      console.error("Error fetching results:", err);
    }
  };

  useEffect(() => {
    fetchResults();
  }, []);

  // ✅ Create new result (POST)
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await fetch(
        `${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.UPLOADRESULTS}`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            ...getAuthHeader(),
          },
          body: JSON.stringify(formData),
        }
      );
      if (res.ok) {
        await fetchResults();
        setFormData({
          title: "",
          date: "",
          description: "",
          performance: "",
          revenue: "",
        });
        setShowModal(false);
      } else {
        alert("Error uploading report");
      }
    } catch (err) {
      console.error("Error uploading report:", err);
    }
  };

  // ✅ Delete result (DELETE)
  const handleDelete = async (id) => {
    if (!window.confirm("Delete this result?")) return;
    try {
      const res = await fetch(
        `${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.UPLOADRESULTS}/${id}`,
        {
          method: "DELETE",
          headers: getAuthHeader(),
        }
      );
      if (res.ok) {
        setResults(results.filter((r) => r.id !== id));
      } else {
        alert("Failed to delete result");
      }
    } catch (err) {
      console.error("Error deleting:", err);
    }
  };

  return (
    <Layout title="Upload Results">
      <div className="container py-5">
        <div className="d-flex justify-content-between align-items-center mb-4">
          <button
            className="btn btn-light"
            onClick={() => navigate("/stall-owner/dashboard")}
          >
            ← Back to Dashboard
          </button>
          <h2 className="text-dark mb-0">⬆️ Upload Results</h2>
          <button className="btn btn-success" onClick={() => setShowModal(true)}>
            + Upload Report
          </button>
        </div>

        <div className="row g-4">
          {results.length === 0 ? (
            <div className="col-12">
              <div className="card shadow-lg">
                <div className="card-body text-center py-5">
                  <p className="text-muted">No results uploaded yet.</p>
                </div>
              </div>
            </div>
          ) : (
            results.map((result) => (
              <div key={result.id} className="col-12 col-md-6">
                <div className="card shadow h-100">
                  <div className="card-body">
                    <div className="d-flex justify-content-between align-items-start mb-3">
                      <h5 className="card-title mb-0">{result.title}</h5>
                      <button
                        className="btn btn-sm btn-danger"
                        onClick={() => handleDelete(result.id)}
                      >
                        🗑️ Delete
                      </button>
                    </div>
                    <p className="text-muted small mb-2">📅 {result.date}</p>
                    <p className="card-text mb-3">{result.description}</p>
                    <div className="row g-2">
                      <div className="col-6">
                        <div className="badge bg-primary w-100 p-2">
                          Performance: {result.performance}/10
                        </div>
                      </div>
                      <div className="col-6">
                        <div className="badge bg-success w-100 p-2">
                          Revenue: ₹{result.revenue}
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            ))
          )}
        </div>

        {/* Modal */}
        {showModal && (
          <div
            className="modal show d-block"
            style={{ backgroundColor: "rgba(0,0,0,0.5)" }}
          >
            <div className="modal-dialog">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title">Upload Performance Report</h5>
                  <button
                    className="btn-close"
                    onClick={() => setShowModal(false)}
                  ></button>
                </div>
                <form onSubmit={handleSubmit}>
                  <div className="modal-body">
                    <div className="mb-3">
                      <label className="form-label">Report Title *</label>
                      <input
                        type="text"
                        className="form-control"
                        value={formData.title}
                        onChange={(e) =>
                          setFormData({ ...formData, title: e.target.value })
                        }
                        required
                      />
                    </div>
                    <div className="mb-3">
                      <label className="form-label">Event Date *</label>
                      <input
                        type="date"
                        className="form-control"
                        value={formData.date}
                        onChange={(e) =>
                          setFormData({ ...formData, date: e.target.value })
                        }
                        required
                      />
                    </div>
                    <div className="mb-3">
                      <label className="form-label">Description *</label>
                      <textarea
                        className="form-control"
                        rows="3"
                        value={formData.description}
                        onChange={(e) =>
                          setFormData({
                            ...formData,
                            description: e.target.value,
                          })
                        }
                        required
                      />
                    </div>
                    <div className="mb-3">
                      <label className="form-label">
                        Performance Rating (1-10) *
                      </label>
                      <input
                        type="number"
                        min="1"
                        max="10"
                        className="form-control"
                        value={formData.performance}
                        onChange={(e) =>
                          setFormData({
                            ...formData,
                            performance: e.target.value,
                          })
                        }
                        required
                      />
                    </div>
                    <div className="mb-3">
                      <label className="form-label">
                        Revenue Generated (₹) *
                      </label>
                      <input
                        type="number"
                        className="form-control"
                        value={formData.revenue}
                        onChange={(e) =>
                          setFormData({
                            ...formData,
                            revenue: e.target.value,
                          })
                        }
                        required
                      />
                    </div>
                  </div>
                  <div className="modal-footer">
                    <button
                      type="button"
                      className="btn btn-secondary"
                      onClick={() => setShowModal(false)}
                    >
                      Cancel
                    </button>
                    <button type="submit" className="btn btn-success">
                      Upload Report
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

export default UploadResults;
