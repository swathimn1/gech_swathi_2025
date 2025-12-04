import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import Layout from "../../components/Layout";
import { API_BASE_URL, API_ENDPOINTS, getAuthHeader } from "../../config/api";
import "bootstrap/dist/css/bootstrap.min.css";

const ManageStalls = () => {
  const navigate = useNavigate();
  const [stalls, setStalls] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [editingStall, setEditingStall] = useState(null);
  const [formData, setFormData] = useState({
    name: "",
    location: "",
    category: "",
    status: "AVAILABLE",
    capacity: "",
  });

  // ✅ Fetch all stalls from backend
  useEffect(() => {
    fetchStalls();
  }, []);

  const fetchStalls = async () => {
    try {
      const res = await axios.get(
        `${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.STALLS}`,
        { headers: getAuthHeader() }
      );
      setStalls(res.data);
    } catch (err) {
      console.error("Error fetching stalls:", err);
      alert("Failed to load stalls. Please login again or check backend.");
    }
  };

  // ✅ Create or Update Stall
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (editingStall) {
        await axios.put(
          `${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.STALLS}/${editingStall.id}`,
          formData,
          { headers: getAuthHeader() }
        );
      } else {
        await axios.post(
          `${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.STALLS}`,
          formData,
          { headers: getAuthHeader() }
        );
      }
      fetchStalls();
      resetForm();
    } catch (err) {
      console.error("Error saving stall:", err);
      alert("Failed to save stall.");
    }
  };

  const handleEdit = (stall) => {
    setEditingStall(stall);
    setFormData({
      name: stall.name,
      location: stall.location,
      category: stall.category,
      status: stall.status,
      capacity: stall.capacity,
    });
    setShowModal(true);
  };

  // ✅ Delete stall
  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this stall?")) {
      try {
        await axios.delete(
          `${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.STALLS}/${id}`,
          { headers: getAuthHeader() }
        );
        fetchStalls();
      } catch (err) {
        console.error("Error deleting stall:", err);
        alert("Failed to delete stall.");
      }
    }
  };

  const resetForm = () => {
    setFormData({
      name: "",
      location: "",
      category: "",
      status: "AVAILABLE",
      capacity: "",
    });
    setEditingStall(null);
    setShowModal(false);
  };

  return (
    <Layout title="Manage Stalls">
      <div className="container py-4">
        <div className="d-flex justify-content-between align-items-center mb-4">
          <button
            className="btn btn-light"
            onClick={() => navigate("/stall-owner/dashboard")}
          >
            ← Back to Dashboard
          </button>
          <h2 className="text-white mb-0">🏪 Manage Stalls</h2>
          <button className="btn btn-success" onClick={() => setShowModal(true)}>
            + Add Stall
          </button>
        </div>

        <div
          className="card shadow-lg border-0"
          style={{ background: "rgba(255,255,255,0.15)", color: "#fff" }}
        >
          <div className="card-body">
            {stalls.length === 0 ? (
              <p className="text-center text-light py-5">
                No stalls yet. Click <b>"Add Stall"</b> to create one.
              </p>
            ) : (
              <div className="table-responsive">
                <table className="table table-hover text-white align-middle">
                  <thead style={{ background: "rgba(255,255,255,0.2)" }}>
                    <tr>
                      <th>#</th>
                      <th>Stall Name</th>
                      <th>Location</th>
                      <th>Category</th>
                      <th>Capacity</th>
                      <th>Status</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {stalls.map((stall, index) => (
                      <tr key={stall.id}>
                        <td>{index + 1}</td>
                        <td>{stall.name}</td>
                        <td>{stall.location}</td>
                        <td>
                          <span className="badge bg-info">{stall.category}</span>
                        </td>
                        <td>{stall.capacity}</td>
                        <td>
                          <span
                            className={`badge ${
                              stall.status === "AVAILABLE"
                                ? "bg-success"
                                : "bg-secondary"
                            }`}
                          >
                            {stall.status}
                          </span>
                        </td>
                        <td>
                          <button
                            className="btn btn-sm btn-outline-light me-2"
                            onClick={() => handleEdit(stall)}
                          >
                            ✏️ Edit
                          </button>
                          <button
                            className="btn btn-sm btn-outline-danger"
                            onClick={() => handleDelete(stall.id)}
                          >
                            🗑️ Delete
                          </button>
                        </td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            )}
          </div>
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
                  <h5 className="modal-title">
                    {editingStall ? "Edit Stall" : "Add New Stall"}
                  </h5>
                  <button className="btn-close" onClick={resetForm}></button>
                </div>
                <form onSubmit={handleSubmit}>
                  <div className="modal-body">
                    <div className="mb-3">
                      <label className="form-label">Stall Name *</label>
                      <input
                        type="text"
                        className="form-control"
                        value={formData.name}
                        onChange={(e) =>
                          setFormData({ ...formData, name: e.target.value })
                        }
                        required
                      />
                    </div>
                    <div className="mb-3">
                      <label className="form-label">Location *</label>
                      <input
                        type="text"
                        className="form-control"
                        value={formData.location}
                        onChange={(e) =>
                          setFormData({ ...formData, location: e.target.value })
                        }
                        required
                      />
                    </div>
                    <div className="mb-3">
                      <label className="form-label">Category *</label>
                      <select
                        className="form-select"
                        value={formData.category}
                        onChange={(e) =>
                          setFormData({ ...formData, category: e.target.value })
                        }
                        required
                      >
                        <option value="">Select Category</option>
                        <option value="Food">Food</option>
                        <option value="Games">Games</option>
                        <option value="Merchandise">Merchandise</option>
                        <option value="Information">Information</option>
                      </select>
                    </div>
                    <div className="mb-3">
                      <label className="form-label">Capacity *</label>
                      <input
                        type="number"
                        className="form-control"
                        value={formData.capacity}
                        onChange={(e) =>
                          setFormData({ ...formData, capacity: e.target.value })
                        }
                        required
                      />
                    </div>
                    <div className="mb-3">
                      <label className="form-label">Status</label>
                      <select
                        className="form-select"
                        value={formData.status}
                        onChange={(e) =>
                          setFormData({ ...formData, status: e.target.value })
                        }
                      >
                        <option value="AVAILABLE">Available</option>
                        <option value="OCCUPIED">Occupied</option>
                      </select>
                    </div>
                  </div>
                  <div className="modal-footer">
                    <button
                      type="button"
                      className="btn btn-secondary"
                      onClick={resetForm}
                    >
                      Cancel
                    </button>
                    <button type="submit" className="btn btn-primary">
                      {editingStall ? "Update" : "Create"} Stall
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

export default ManageStalls;
