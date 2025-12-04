import { useEffect } from "react";
import { Link } from "react-router-dom";
import {
  Home,
  Info,
  Mail,
  Calendar,
  Users,
  QrCode,
  Star,
} from "lucide-react";
import "bootstrap/dist/css/bootstrap.min.css";

const Index = () => {
  useEffect(() => {
    document.title = "Smart Event System";
  }, []);

  return (
    <div
      className="d-flex min-vh-100"
      style={{
        background: "linear-gradient(135deg, #ff6a00 0%, #ee0979 50%, #fcb045 100%)",
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
            to="/auth/login"
            className="btn btn-light text-primary fw-semibold w-100 mb-2 rounded-pill"
          >
            Login
          </Link>
          <Link
            to="/auth/register"
            className="btn btn-outline-light fw-semibold w-100 rounded-pill"
          >
            Sign Up
          </Link>
        </div>
      </div>

      {/* Main Content */}
      <div className="flex-grow-1 overflow-auto p-4">
        {/* Hero Section */}
        <div
          className="text-center p-5 mx-auto mb-5"
          style={{
            maxWidth: "800px",
            background: "rgba(255, 255, 255, 0.15)",
            borderRadius: "25px",
            backdropFilter: "blur(15px)",
            boxShadow: "0 10px 30px rgba(0, 0, 0, 0.3)",
          }}
        >
          <h1 className="fw-bold display-4 mb-3 text-white">
            Manage Your Events Smarter ✨
          </h1>
          <p className="lead mb-4 text-light fs-5">
            Create, organize, and track events with ease. Empower your team and
            attendees through a seamless event management experience.
          </p>
          <Link
            to="/events"
            className="btn btn-lg fw-bold text-white rounded-pill px-5 py-3 shadow-lg"
            style={{
              background: "linear-gradient(90deg, #ee0979 0%, #ff6a00 100%)",
              border: "none",
            }}
          >
            Explore Events
          </Link>
        </div>

        {/* Feature Cards */}
        <div className="container mb-5">
          <div className="row g-4">
            {[
              {
                icon: <Calendar size={40} />,
                title: "Upcoming Events",
                text: "Stay updated with all the latest and upcoming events.",
                link: "/events",
                gradient: "linear-gradient(135deg, #667eea 0%, #764ba2 100%)",
              },
              {
                icon: <Users size={40} />,
                title: "User Management",
                text: "Manage attendees, organizers, and volunteers easily.",
                link: "/users",
                gradient: "linear-gradient(135deg, #f093fb 0%, #f5576c 100%)",
              },
              {
                icon: <QrCode size={40} />,
                title: "Smart Check-In",
                text: "Use QR codes for quick and secure event entry.",
                link: "/checkin",
                gradient: "linear-gradient(135deg, #4facfe 0%, #00f2fe 100%)",
              },
              {
                icon: <Star size={40} />,
                title: "Feedback & Ratings",
                text: "Collect reviews to improve future events.",
                link: "/feedback",
                gradient: "linear-gradient(135deg, #43e97b 0%, #38f9d7 100%)",
              },
            ].map((card, index) => (
              <div key={index} className="col-md-6 col-lg-3">
                <Link
                  to={card.link}
                  className="text-decoration-none"
                  style={{ color: "inherit" }}
                >
                  <div
                    className="card h-100 text-center border-0 shadow-lg"
                    style={{
                      background: "rgba(255,255,255,0.25)",
                      borderRadius: "20px",
                      backdropFilter: "blur(10px)",
                      transition: "all 0.3s ease",
                    }}
                    onMouseEnter={(e) => {
                      e.currentTarget.style.transform = "translateY(-10px)";
                      e.currentTarget.style.background = card.gradient;
                    }}
                    onMouseLeave={(e) => {
                      e.currentTarget.style.transform = "translateY(0)";
                      e.currentTarget.style.background =
                        "rgba(255,255,255,0.25)";
                    }}
                  >
                    <div className="card-body p-4">
                      <div
                        className="d-flex justify-content-center align-items-center mb-3"
                        style={{
                          width: "70px",
                          height: "70px",
                          borderRadius: "50%",
                          background: "rgba(255, 255, 255, 0.2)",
                          margin: "0 auto",
                        }}
                      >
                        {card.icon}
                      </div>
                      <h5 className="fw-bold mb-3 fs-4">{card.title}</h5>
                      <p className="mb-0">{card.text}</p>
                    </div>
                  </div>
                </Link>
              </div>
            ))}
          </div>
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

export default Index;
