import React, { useEffect, useState } from "react";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";

const ViewStalls = () => {
  const [stalls, setStalls] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  const [editingId, setEditingId] = useState(null);

  const [formData, setFormData] = useState({
    name: "",
    description: "",
    price: "",
    category: "",
  });

  const API_URL = "http://localhost:8080/api/stalls";

  // ✅ Fetch stalls
  const fetchStalls = async () => {
    try {
      const res = await axios.get(API_URL);
      setStalls(res.data);
    } catch (err) {
      setError("Failed to fetch stalls");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchStalls();
  }, []);

  // ✅ Handle change
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // ✅ Add stall
  const handleAdd = async (e) => {
    e.preventDefault();
    try {
      await axios.post(API_URL, formData);
      setFormData({ name: "", description: "", price: "", category: "" });
      fetchStalls();
    } catch (err) {
      alert("Error adding stall");
    }
  };

  // ✅ Edit stall
  const handleEdit = (stall) => {
    setEditingId(stall.id);
    setFormData({
      name: stall.name,
      description: stall.description,
      price: stall.price,
      category: stall.category,
    });
  };

  // ✅ Update stall
  const handleUpdate = async (e) => {
    e.preventDefault();
    try {
      await axios.put(`${API_URL}/${editingId}`, formData);
      setEditingId(null);
      setFormData({ name: "", description: "", price: "", category: "" });
      fetchStalls();
    } catch (err) {
      alert("Error updating stall");
    }
  };

  // ✅ Delete stall
  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this stall?")) {
      try {
        await axios.delete(`${API_URL}/${id}`);
        fetchStalls();
      } catch (err) {
        alert("Error deleting stall");
      }
    }
  };

  if (loading) return <div className="text-center mt-5">Loading stalls...</div>;
  if (error) return <div className="alert alert-danger mt-3">{error}</div>;

  return (
    <div className="container my-5">
      <h2 className="text-center mb-4 fw-bold text-primary">Manage Stalls</h2>

      {/* ✅ Add / Update Form */}
      <div className="card shadow-sm mb-4">
        <div className="card-body">
          <h5 className="card-title">{editingId ? "Update Stall" : "Add New Stall"}</h5>
          <form onSubmit={editingId ? handleUpdate : handleAdd}>
            <div className="row g-3">
              <div className="col-md-4">
                <input
                  type="text"
                  name="name"
                  value={formData.name}
                  onChange={handleChange}
                  placeholder="Stall Name"
                  className="form-control"
                  required
                />
              </div>
              <div className="col-md-4">
                <input
                  type="number"
                  name="price"
                  value={formData.price}
                  onChange={handleChange}
                  placeholder="Price"
                  className="form-control"
                  required
                />
              </div>
              <div className="col-md-4">
                <input
                  type="text"
                  name="category"
                  value={formData.category}
                  onChange={handleChange}
                  placeholder="Category"
                  className="form-control"
                />
              </div>
              <div className="col-12">
                <textarea
                  name="description"
                  value={formData.description}
                  onChange={handleChange}
                  placeholder="Description"
                  rows="2"
                  className="form-control"
                ></textarea>
              </div>
            </div>
            <button className="btn btn-primary mt-3">
              {editingId ? "Update Stall" : "Add Stall"}
            </button>
            {editingId && (
              <button
                type="button"
                className="btn btn-secondary mt-3 ms-2"
                onClick={() => {
                  setEditingId(null);
                  setFormData({ name: "", description: "", price: "", category: "" });
                }}
              >
                Cancel
              </button>
            )}
          </form>
        </div>
      </div>

      {/* ✅ Stall List */}
      {stalls.length === 0 ? (
        <div className="alert alert-info text-center">No stalls available</div>
      ) : (
        <div className="table-responsive shadow-sm">
          <table className="table table-striped align-middle">
            <thead className="table-dark">
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Description</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {stalls.map((stall) => (
                <tr key={stall.id}>
                  <td>{stall.id}</td>
                  <td>{stall.name}</td>
                  <td>{stall.category}</td>
                  <td>₹{stall.price}</td>
                  <td>{stall.description}</td>
                  <td>
                    <button
                      className="btn btn-warning btn-sm me-2"
                      onClick={() => handleEdit(stall)}
                    >
                      Edit
                    </button>
                    <button
                      className="btn btn-danger btn-sm"
                      onClick={() => handleDelete(stall.id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default ViewStalls;
