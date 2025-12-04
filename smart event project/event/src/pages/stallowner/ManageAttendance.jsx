import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Layout from "../../components/Layout";
import { API_BASE_URL, API_ENDPOINTS, getAuthHeader } from "../../config/api";

const ManageAttendance = () => {
  const navigate = useNavigate();
  const [attendance, setAttendance] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [formData, setFormData] = useState({
    visitorName: "",
    visitorEmail: "",
    checkInTime: "",
    purpose: "",
    stallVisited: "",
  });

  // ✅ Fetch attendance records from backend
  useEffect(() => {
    fetch(`${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.ATTENDANCE}`, {
      headers: getAuthHeader(),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to fetch attendance");
        return res.json();
      })
      .then((data) => setAttendance(data))
      .catch((err) => console.error(err));
  }, []);

  // ✅ Add new visitor record
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await fetch(`${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.ATTENDANCE}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          ...getAuthHeader(),
        },
        body: JSON.stringify(formData),
      });

      if (!res.ok) throw new Error("Failed to add attendance");
      const newRecord = await res.json();
      setAttendance([newRecord, ...attendance]);

      // Reset form and close modal
      setFormData({
        visitorName: "",
        visitorEmail: "",
        checkInTime: "",
        purpose: "",
        stallVisited: "",
      });
      setShowModal(false);
    } catch (error) {
      console.error(error);
    }
  };

  // ✅ Check out visitor
  const handleCheckOut = async (id) => {
    try {
      const res = await fetch(
        `${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.ATTENDANCE}/${id}/checkout`,
        {
          method: "PUT",
          headers: getAuthHeader(),
        }
      );

      if (!res.ok) throw new Error("Failed to check out");
      const updatedRecord = await res.json();

      setAttendance((prev) =>
        prev.map((item) => (item.id === id ? updatedRecord : item))
      );
    } catch (error) {
      console.error(error);
    }
  };

  // ✅ Delete visitor record
  const handleDelete = async (id) => {
    if (!window.confirm("Are you sure you want to delete this record?")) return;

    try {
      const res = await fetch(
        `${API_BASE_URL}${API_ENDPOINTS.STALL_OWNER.ATTENDANCE}/${id}`,
        {
          method: "DELETE",
          headers: getAuthHeader(),
        }
      );

      if (!res.ok) throw new Error("Failed to delete record");

      setAttendance((prev) => prev.filter((item) => item.id !== id));
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <Layout title="Manage Attendance - Smart Event System">
      <div className="container py-5">
        <div className="d-flex justify-content-between align-items-center mb-4">
          <button
            className="btn btn-light"
            onClick={() => navigate("/stall-owner/dashboard")}
          >
            ← Back to Dashboard
          </button>
          <h2 className="text-white mb-0">📋 Manage Attendance</h2>
          <button
            className="btn btn-warning text-dark"
            onClick={() => setShowModal(true)}
          >
            + Add Visitor
          </button>
        </div>

        <div className="card shadow-lg">
          <div className="card-body">
            {attendance.length === 0 ? (
              <p className="text-center text-muted py-5">
                No attendance records yet.
              </p>
            ) : (
              <div className="table-responsive">
                <table className="table table-hover align-middle">
                  <thead className="table-light">
                    <tr>
                      <th>#</th>
                      <th>Visitor Name</th>
                      <th>Email</th>
                      <th>Date</th>
                      <th>Check-In</th>
                      <th>Check-Out</th>
                      <th>Stall</th>
                      <th>Purpose</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {attendance.map((record, index) => (
                      <tr key={record.id}>
                        <td>{index + 1}</td>
                        <td>{record.visitorName}</td>
                        <td>{record.visitorEmail}</td>
                        <td>{record.date}</td>
                        <td>
                          <span className="badge bg-success">
                            {record.checkInTime}
                          </span>
                        </td>
                        <td>
                          {record.checkOutTime ? (
                            <span className="badge bg-secondary">
                              {record.checkOutTime}
                            </span>
                          ) : (
                            <button
                              className="btn btn-sm btn-warning text-dark"
                              onClick={() => handleCheckOut(record.id)}
                            >
                              Check Out
                            </button>
                          )}
                        </td>
                        <td>{record.stallVisited}</td>
                        <td>
                          <span className="badge bg-info">{record.purpose}</span>
                        </td>
                        <td>
                          <button
                            className="btn btn-sm btn-danger"
                            onClick={() => handleDelete(record.id)}
                          >
                            🗑️
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

        {/* ✅ Modal for Add Record */}
        {showModal && (
          <div
            className="modal show d-block"
            style={{ backgroundColor: "rgba(0,0,0,0.5)" }}
          >
            <div className="modal-dialog">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title">Add Visitor Record</h5>
                  <button
                    className="btn-close"
                    onClick={() => setShowModal(false)}
                  ></button>
                </div>
                <form onSubmit={handleSubmit}>
                  <div className="modal-body">
                    <div className="mb-3">
                      <label className="form-label">Visitor Name *</label>
                      <input
                        type="text"
                        className="form-control"
                        value={formData.visitorName}
                        onChange={(e) =>
                          setFormData({
                            ...formData,
                            visitorName: e.target.value,
                          })
                        }
                        required
                      />
                    </div>

                    <div className="mb-3">
                      <label className="form-label">Email *</label>
                      <input
                        type="email"
                        className="form-control"
                        value={formData.visitorEmail}
                        onChange={(e) =>
                          setFormData({
                            ...formData,
                            visitorEmail: e.target.value,
                          })
                        }
                        required
                      />
                    </div>

                    <div className="mb-3">
                      <label className="form-label">Check-In Time *</label>
                      <input
                        type="time"
                        className="form-control"
                        value={formData.checkInTime}
                        onChange={(e) =>
                          setFormData({
                            ...formData,
                            checkInTime: e.target.value,
                          })
                        }
                        required
                      />
                    </div>

                    <div className="mb-3">
                      <label className="form-label">Stall Visited *</label>
                      <input
                        type="text"
                        className="form-control"
                        value={formData.stallVisited}
                        onChange={(e) =>
                          setFormData({
                            ...formData,
                            stallVisited: e.target.value,
                          })
                        }
                        required
                      />
                    </div>

                    <div className="mb-3">
                      <label className="form-label">Purpose *</label>
                      <select
                        className="form-select"
                        value={formData.purpose}
                        onChange={(e) =>
                          setFormData({
                            ...formData,
                            purpose: e.target.value,
                          })
                        }
                        required
                      >
                        <option value="">Select Purpose</option>
                        <option value="Purchase">Purchase</option>
                        <option value="Inquiry">Inquiry</option>
                        <option value="Visit">Visit</option>
                        <option value="Event">Event</option>
                      </select>
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
                    <button type="submit" className="btn btn-warning text-dark">
                      Add Record
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

export default ManageAttendance;
