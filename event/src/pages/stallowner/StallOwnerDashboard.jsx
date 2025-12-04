import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Layout from "../../components/Layout";
import {
  Calendar,
  Upload,
  ClipboardList,
  Bell,
  LogOut,
  MessageSquare,
} from "lucide-react";
import { useAuth } from "../../context/AuthContext"; // ✅ Import AuthContext hook
import "bootstrap/dist/css/bootstrap.min.css";

const StallOwnerDashboard = () => {
  const navigate = useNavigate();
  const [showToast, setShowToast] = useState(false);
  const { logout } = useAuth(); // ✅ Get logout function from context

  const handleLogout = () => {
    logout(); // ✅ Clears user + token from context & localStorage
    setShowToast(true);
    setTimeout(() => {
      setShowToast(false);
      navigate("/login");
    }, 2000);
  };

  return (
    <Layout title="Stall Owner Dashboard | Smart Event System">
      {/* ✅ Toast message */}
      {showToast && (
        <div
          className="position-fixed top-0 start-50 translate-middle-x mt-3 z-3"
          style={{ width: "auto", maxWidth: "400px" }}
        >
          <div
            className="alert alert-success alert-dismissible fade show shadow-sm"
            role="alert"
          >
            <strong>Logout Successful!</strong> Redirecting to login page...
          </div>
        </div>
      )}

      <div className="container py-4">
        <div className="d-flex justify-content-between align-items-center mb-4">
          <h2 className="fw-bold mb-0">Welcome, Stall Owner 🎪</h2>
          <button
            className="btn btn-danger fw-semibold d-flex align-items-center"
            onClick={handleLogout}
          >
            <LogOut size={18} className="me-2" /> Logout
          </button>
        </div>

        <div className="row g-4">
          {/* ✅ Manage Stalls */}
          <div className="col-md-6 col-lg-3">
            <div className="card border-0 shadow-lg text-center p-4 h-100 bg-light text-dark">
              <Calendar size={40} className="mx-auto mb-3 text-primary" />
              <h5 className="fw-bold">Manage Stalls</h5>
              <p>View or edit your stall details and availability.</p>
              <Link to="/stall-owner/stalls" className="btn btn-primary w-100">
                View Stalls
              </Link>
            </div>
          </div>

          {/* ✅ Upload Results */}
          <div className="col-md-6 col-lg-3">
            <div className="card border-0 shadow-lg text-center p-4 h-100 bg-light text-dark">
              <Upload size={40} className="mx-auto mb-3 text-success" />
              <h5 className="fw-bold">Upload Results</h5>
              <p>Post event outcomes or performance reports.</p>
              <Link
                to="/stall-owner/upload-results"
                className="btn btn-success w-100"
              >
                Upload Results
              </Link>
            </div>
          </div>

          {/* ✅ Manage Attendance */}
          <div className="col-md-6 col-lg-3">
            <div className="card border-0 shadow-lg text-center p-4 h-100 bg-light text-dark">
              <ClipboardList size={40} className="mx-auto mb-3 text-warning" />
              <h5 className="fw-bold">Manage Attendance</h5>
              <p>Record attendance and visitor logs.</p>
              <Link
                to="/stall-owner/attendance"
                className="btn btn-warning w-100"
              >
                Attendance
              </Link>
            </div>
          </div>

          {/* ✅ Notifications */}
          <div className="col-md-6 col-lg-3">
            <div className="card border-0 shadow-lg text-center p-4 h-100 bg-light text-dark">
              <Bell size={40} className="mx-auto mb-3 text-danger" />
              <h5 className="fw-bold">Notifications</h5>
              <p>Stay updated with the latest event alerts.</p>
              <Link
                to="/stall-owner/notifications"
                className="btn btn-danger w-100"
              >
                View Alerts
              </Link>
            </div>
          </div>

          {/* ✅ Email Templates / Preview */}
          <div className="col-md-6 col-lg-3">
            <div
              className="card border-0 shadow-lg text-center p-4 h-100 bg-light text-dark"
              style={{ cursor: "pointer" }}
              onClick={() => navigate("/email-preview")}
            >
              <MessageSquare size={40} className="mx-auto mb-3 text-info" />
              <h5 className="fw-bold">Email Templates</h5>
              <p>Preview all automated email designs for your events.</p>
            </div>
          </div>
        </div>
      </div>
    </Layout>
  );
};

export default StallOwnerDashboard;
