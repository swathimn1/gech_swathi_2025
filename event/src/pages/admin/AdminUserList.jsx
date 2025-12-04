import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate, useLocation } from "react-router-dom";
import Layout from "../../components/Layout";
import "bootstrap/dist/css/bootstrap.min.css";

const AdminUserList = () => {
  const navigate = useNavigate();
  const location = useLocation();

  const isAdminPage = location.pathname.startsWith("/admin");
  const token = localStorage.getItem("token");

  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [showModal, setShowModal] = useState(false);
  const [editingUser, setEditingUser] = useState(null);
  const [formData, setFormData] = useState({
    fullName: "",
    username: "",
    email: "",
    role: "VISITOR",
    password: "",
  });
  const [deleteConfirm, setDeleteConfirm] = useState(null);

  // Determine correct API base
  const API_BASE = isAdminPage
    ? "http://localhost:8080/api/admin"
    : "http://localhost:8080/api";

  const fetchUsers = async () => {
    setLoading(true);
    try {
      const response = await axios.get(`${API_BASE}/users`, {
        headers: isAdminPage ? { Authorization: `Bearer ${token}` } : {},
      });
      setUsers(response.data);
    } catch (error) {
      console.error("Failed to fetch users:", error.response || error.message);
      alert("❌ Failed to fetch users from server");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchUsers();
  }, [location.pathname]);

  const handleOpenModal = (user = null) => {
    if (!isAdminPage) return; // Only admin can open modal
    if (user) {
      setEditingUser(user);
      setFormData({
        // fullName: user.fullName,
        username: user.username,
        email: user.email,
        role: user.role,
      });
    } else {
      setEditingUser(null);
      // setFormData({ fullName: "", username: "", email: "", role: "VISITOR" });
      setFormData({  username: "", email: "", role: "VISITOR" });
    }
    setShowModal(true);
  };

  const handleCloseModal = () => {
    setShowModal(false);
    setEditingUser(null);
    // setFormData({ fullName: "", username: "", email: "", role: "VISITOR" });
    setFormData({  username: "", email: "", role: "VISITOR" });
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!isAdminPage) return;

    try {
      if (editingUser) {
        const response = await axios.put(
          `${API_BASE}/users/${editingUser.id}`,
          formData,
          { headers: { Authorization: `Bearer ${token}` } }
        );
        setUsers(
          users.map((u) => (u.id === editingUser.id ? response.data : u))
        );
        alert("✅ User updated successfully!");
      } else {
        const response = await axios.post(`${API_BASE}/users`, formData, {
          headers: { Authorization: `Bearer ${token}` },
        });
        setUsers([...users, response.data]);
        alert("✅ User created successfully!");
      }
      handleCloseModal();
    } catch (error) {
      console.error("Error saving user:", error.response || error.message);
      alert("❌ Failed to save user");
    }
  };

  const handleDelete = async (userId) => {
    if (!isAdminPage) return;

    try {
      await axios.delete(`${API_BASE}/users/${userId}`, {
        headers: { Authorization: `Bearer ${token}` },
      });
      setUsers(users.filter((u) => u.id !== userId));
      setDeleteConfirm(null);
      alert("🗑️ User deleted successfully!");
    } catch (error) {
      console.error("Failed to delete user:", error.response || error.message);
      alert("❌ Failed to delete user");
    }
  };

  return (
    <Layout title={isAdminPage ? "Admin - Manage Users" : "Users"}>
      <div className="container py-4">

        {isAdminPage && (
          <button
            className="btn btn-outline-light mb-3"
            onClick={() => navigate("/admin/dashboard")}
          >
            ⬅ Back to Dashboard
          </button>
        )}

        <div className="d-flex justify-content-between align-items-center mb-4">
          <h2 className="fw-bold text-white">
            {isAdminPage ? "👑 User Management" : "👥 Users"}
          </h2>
          {isAdminPage && (
            <button className="btn btn-light fw-semibold" onClick={() => handleOpenModal()}>
              + Add User
            </button>
          )}
        </div>

        {loading ? (
          <div className="text-center text-white py-5">
            <div className="spinner-border text-light"></div>
            <p className="mt-3">Loading users...</p>
          </div>
        ) : users.length === 0 ? (
          <div
            className="alert text-center fw-semibold"
            style={{
              background: "rgba(255,255,255,0.2)",
              backdropFilter: "blur(8px)",
              color: "#fff",
              borderRadius: "15px",
            }}
          >
            No users found.
          </div>
        ) : (
          <div
            className="card shadow-lg border-0"
            style={{
              background: "rgba(255,255,255,0.15)",
              borderRadius: "15px",
              backdropFilter: "blur(10px)",
            }}
          >
            <div className="card-header bg-dark text-white fw-bold">
              Registered Users
            </div>
            <div className="table-responsive">
              <table className="table table-hover text-white align-middle">
                <thead>
                  <tr>
                    <th>ID</th>
                    {/* <th>Full Name</th> */}
                    <th>Username</th>
                    <th>Email</th>
                    <th>Role</th>
                    {isAdminPage && <th className="text-center">Actions</th>}
                  </tr>
                </thead>
                <tbody>
                  {users.map((user) => (
                    <tr key={user.id}>
                      <td>{user.id}</td>
                      {/* <td>{user.fullName}</td> */}
                      <td>{user.username}</td>
                      <td>{user.email}</td>
                      <td>
                        <span
                          className={`badge ${
                            user.role === "ADMIN"
                              ? "bg-danger"
                              : user.role === "STALL_OWNER"
                              ? "bg-warning text-dark"
                              : "bg-info"
                          }`}
                        >
                          {user.role}
                        </span>
                      </td>
                      {isAdminPage && (
                        <td className="text-center">
                          <button
                            className="btn btn-sm btn-outline-light me-2"
                            onClick={() => handleOpenModal(user)}
                          >
                            Edit
                          </button>
                          <button
                            className="btn btn-sm btn-outline-danger"
                            onClick={() => setDeleteConfirm(user.id)}
                          >
                            Delete
                          </button>
                        </td>
                      )}
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        )}

        {/* Add/Edit Modal */}
        {isAdminPage && showModal && (
          <div
            className="modal show d-block"
            style={{ backgroundColor: "rgba(0,0,0,0.5)" }}
          >
            <div className="modal-dialog modal-dialog-centered">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title">
                    {editingUser ? "Edit User" : "Add New User"}
                  </h5>
                  <button className="btn-close" onClick={handleCloseModal}></button>
                </div>
                <form onSubmit={handleSubmit}>
                  <div className="modal-body">
                    {/* <div className="mb-3">
                      <label className="form-label">Full Name</label>
                      <input
                        type="text"
                        name="fullName"
                        className="form-control"
                        value={formData.fullName}
                        onChange={handleInputChange}
                        required
                      />
                    </div> */}
                    <div className="mb-3">
                      <label className="form-label">Username</label>
                      <input
                        type="text"
                        name="username"
                        className="form-control"
                        value={formData.username}
                        onChange={handleInputChange}
                        required
                      />
                    </div>
                    <div className="mb-3">
                      <label className="form-label">Email</label>
                      <input
                        type="email"
                        name="email"
                        className="form-control"
                        value={formData.email}
                        onChange={handleInputChange}
                        required
                      />
                    </div>
                    <div className="mb-3">
                      <label className="form-label">Role</label>
                      <select
                        name="role"
                        className="form-select"
                        value={formData.role}
                        onChange={handleInputChange}
                      >
                        <option value="VISITOR">VISITOR</option>
                        <option value="STALL_OWNER">STALL_OWNER</option>
                        <option value="ADMIN">ADMIN</option>
                      </select>
                    </div>
                    <div className="mb-3">
                      <label className="form-label">Password</label>
                      <input
                        type="password"
                        name="password"
                        className="form-control"
                        value={formData.password || ""}
                        onChange={handleInputChange}
                        required={!editingUser}
                      />
                    </div>
                  </div>
                  <div className="modal-footer">
                    <button
                      className="btn btn-secondary"
                      onClick={handleCloseModal}
                      type="button"
                    >
                      Cancel
                    </button>
                    <button className="btn btn-primary" type="submit">
                      {editingUser ? "Update" : "Create"}
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        )}

        {/* Delete Confirmation */}
        {isAdminPage && deleteConfirm && (
          <div
            className="modal show d-block"
            style={{ backgroundColor: "rgba(0,0,0,0.5)" }}
          >
            <div className="modal-dialog modal-dialog-centered">
              <div className="modal-content">
                <div className="modal-header bg-danger text-white">
                  <h5 className="modal-title">Confirm Delete</h5>
                  <button
                    className="btn-close btn-close-white"
                    onClick={() => setDeleteConfirm(null)}
                  ></button>
                </div>
                <div className="modal-body">
                  Are you sure you want to delete this user? This action cannot be undone.
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
                    Delete User
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

export default AdminUserList;
