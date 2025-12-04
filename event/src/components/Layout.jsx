import { useEffect } from "react";
import { Link } from "react-router-dom";
import {
  Home,
  Info,
  Mail,
} from "lucide-react";
import "bootstrap/dist/css/bootstrap.min.css";


const Layout = ({ title, children }) => {
  useEffect(() => {
    document.title = title || "Smart Event System";
  }, [title]);

  return (
    <div
      className="d-flex min-vh-100"
      style={{
        background:
          "linear-gradient(135deg, #ff6a00 0%, #ee0979 50%, #fcb045 100%)",
        color: "#fff",
      }}
    >
      {/* Sidebar */}
      <div
        className="d-flex flex-column p-4"
        style={{
          width: "250px",
          background: "rgba(0, 0, 0, 0.25)",
          backdropFilter: "blur(12px)",
          boxShadow: "0 4px 20px rgba(0,0,0,0.3)",
        }}
      >
        <h4 className="fw-bold text-center mb-4 text-white">
          🎉 Smart Event
        </h4>

        <ul className="nav flex-column">
          <li className="nav-item mb-2">
            <Link
              to="/"
              className="nav-link text-white fw-semibold d-flex align-items-center"
            >
              <Home size={18} className="me-2" /> Home
            </Link>
          </li>
          <li className="nav-item mb-2">
            <Link
              to="/about"
              className="nav-link text-white fw-semibold d-flex align-items-center"
            >
              <Info size={18} className="me-2" /> About
            </Link>
          </li>
          <li className="nav-item mb-2">
            <Link
              to="/contact"
              className="nav-link text-white fw-semibold d-flex align-items-center"
            >
              <Mail size={18} className="me-2" /> Contact
            </Link>
          </li>
          <hr className="text-white my-3" />
          <li className="nav-item mb-2">
            <Link
              to="/admin/dashboard"
              className="nav-link text-white fw-semibold"
            >
              👑 Admin
            </Link>
          </li>
          <li className="nav-item mb-2">
            <Link
              to="/visitor/dashboard"
              className="nav-link text-white fw-semibold"
            >
              🧭 Visitor
            </Link>
          </li>
          <li className="nav-item mb-2">
            <Link
              to="/stall-owner/dashboard"
              className="nav-link text-white fw-semibold"
            >
              🏪 Stall Owner
            </Link>
          </li>
        </ul>

        <div className="mt-auto text-center">
          <Link
            to="/login"
            className="btn btn-light text-primary fw-semibold w-100 mb-2 rounded-pill"
          >
            Login
          </Link>
          <Link
            to="/register"
            className="btn btn-outline-light fw-semibold w-100 rounded-pill"
          >
            Sign Up
          </Link>
        </div>
      </div>

      {/* Main Content */}
      <div className="flex-grow-1 overflow-auto p-4">
        <div
          className="p-4 mx-auto mb-5"
          style={{
            maxWidth: "1000px",
            background: "rgba(255, 255, 255, 0.15)",
            borderRadius: "25px",
            backdropFilter: "blur(15px)",
            boxShadow: "0 10px 30px rgba(0, 0, 0, 0.3)",
          }}
        >
          {children}
        </div>

        {/* Footer */}
        <footer
          className="text-center py-4 rounded-4"
          style={{
            background: "rgba(0,0,0,0.2)",
            color: "#fff",
            backdropFilter: "blur(10px)",
          }}
        >
          <p className="mb-0 fw-semibold">
            © {new Date().getFullYear()} Smart Event System | Made with 💖 by
            Swathi
          </p>
        </footer>
      </div>
    </div>
  );
};

export default Layout;
