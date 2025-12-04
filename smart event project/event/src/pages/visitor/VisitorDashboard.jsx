import { useEffect, useState, useCallback } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";
import { visitorService } from "../../services/visitorService";
import { useToast } from "../../hooks/use-toast";

import {
  Calendar,
  QrCode,
  Star,
  MessageSquare,
  Award,
  LogOut,
} from "lucide-react";
import Layout from "../../components/Layout";

const VisitorDashboard = () => {
  const { user, logout } = useAuth();
  const navigate = useNavigate();
  const { toast } = useToast();

  const [points, setPoints] = useState(null);
  const [events, setEvents] = useState([]);
  const [loading, setLoading] = useState(true);

  /**
   * Robust date formatter for Event backend (LocalDate format)
   */
  const formatDate = (input) => {
    if (input === null || input === undefined || input === "") return "—";

    // If already a Date
    if (input instanceof Date) {
      if (!isNaN(input.getTime())) return input.toLocaleDateString("en-IN");
      return "—";
    }

    // If numeric timestamp (ms)
    if (typeof input === "number") {
      const d = new Date(input);
      return isNaN(d.getTime()) ? "—" : d.toLocaleDateString("en-IN");
    }

    // If string: try parsing
    let s = String(input).trim();

    // Try Date.parse (works for ISO dates like "2025-12-31")
    let parsed = Date.parse(s);
    if (!isNaN(parsed)) {
      return new Date(parsed).toLocaleDateString("en-IN");
    }

    return "—";
  };

  const fetchData = useCallback(async () => {
    try {
      setLoading(true);

      const [pointsData, eventsData] = await Promise.all([
        visitorService.getMyPoints(),
        visitorService.getEvents(), // Now fetches from /events
      ]);

      console.log("Events API Response (raw):", eventsData);

      const totalPoints =
        pointsData?.totalPoints ??
        pointsData?.points ??
        pointsData?.data?.totalPoints ??
        0;

      setPoints(totalPoints);
      setEvents(Array.isArray(eventsData) ? eventsData : []);
    } catch (error) {
      console.error("Dashboard Load Error:", error);
      toast({
        title: "Error",
        description: "Failed to load dashboard data",
        variant: "destructive",
      });
      setPoints(0);
      setEvents([]);
    } finally {
      setLoading(false);
    }
  }, [toast]);

  useEffect(() => {
    fetchData();
  }, [fetchData]);

  const handleLogout = () => {
    logout();
    toast({
      title: "Logout Successful",
      description: "You have been logged out.",
    });
    setTimeout(() => navigate("/login"), 1200);
  };

  const quickActions = [
    {
      label: "Browse Events",
      icon: <Calendar size={28} />,
      link: "/visitor/events",
      sub: `${events.length} available events`,
      color: "linear-gradient(135deg, #2193b0, #6dd5ed)",
    },
    {
      label: "Scan QR Code",
      icon: <QrCode size={28} />,
      link: "/visitor/scan",
      sub: "Earn points instantly",
      color: "linear-gradient(135deg, #56ab2f, #a8e063)",
    },
    {
      label: "My Feedback",
      icon: <Star size={28} />,
      link: "/visitor/feedback",
      sub: "View stall ratings",
      color: "linear-gradient(135deg, #f7971e, #ffd200)",
    },
    {
      label: "My Queries",
      icon: <MessageSquare size={28} />,
      link: "/visitor/queries",
      sub: "Track your questions",
      color: "linear-gradient(135deg, #ff416c, #ff4b2b)",
    },
    {
      label: "Email Templates",
      icon: <MessageSquare size={28} />,
      link: "/email-preview",
      sub: "Preview all automated email designs",
      color: "linear-gradient(135deg, #17a2b8, #63cdda)",
    },
  ];

  return (
    <Layout title="Visitor Dashboard | Smart Event System">
      {/* HEADER */}
      <div className="d-flex justify-content-between align-items-center mb-4 px-1">
        <h2 className="fw-bold text-white mb-0">Visitor Dashboard 🎟️</h2>

        <div
          className="d-flex align-items-center px-3 py-2 rounded-pill shadow"
          style={{
            background: "rgba(255,255,255,0.15)",
            backdropFilter: "blur(8px)",
            border: "1px solid rgba(255,255,255,0.25)",
          }}
        >
          <span className="me-3 fw-semibold text-white">
            Hello,&nbsp;{user?.name || "Visitor"}
          </span>
          <button
            className="btn btn-danger btn-sm d-flex align-items-center fw-semibold px-3"
            style={{ borderRadius: "50px" }}
            onClick={handleLogout}
          >
            <LogOut size={16} className="me-2" />
            Logout
          </button>
        </div>
      </div>

      {/* POINTS CARD */}
      <div
        className="card mb-5 border-0 shadow-lg text-center"
        style={{
          borderRadius: "25px",
          background: "rgba(255,255,255,0.25)",
          backdropFilter: "blur(10px)",
          color: "#fff",
        }}
      >
        <div className="card-body py-5">
          <Award size={50} className="mb-3 text-warning" />
          <h3 className="fw-bold">Your Reward Points</h3>
          <h1 className="display-3 fw-bold text-light">
            {points === null ? "..." : points}
          </h1>
          <p className="text-light opacity-75">Scan stalls to earn more!</p>
        </div>
      </div>

      {/* QUICK ACTION CARDS */}
      <div className="row g-4 mb-5">
        {quickActions.map((action, index) => (
          <div className="col-md-3" key={index}>
            <DashboardCard {...action} />
          </div>
        ))}
      </div>

      {/* UPCOMING EVENTS */}
      <h3 className="fw-bold text-light text-center mb-4">Upcoming Events</h3>

      {events.length === 0 && !loading ? (
        <div
          className="card text-center border-0 shadow-lg py-5"
          style={{
            background: "rgba(255,255,255,0.3)",
            borderRadius: "20px",
            color: "#fff",
          }}
        >
          <div className="card-body">
            <Calendar size={50} className="text-light mb-3 opacity-75" />
            <h4 className="fw-bold">No upcoming events</h4>
            <p className="opacity-75">Please check again later.</p>
          </div>
        </div>
      ) : (
        <div className="row g-4">
          {events.slice(0, 6).map((event) => (
            <div className="col-md-4" key={event.id}>
              <div
                className="card shadow-lg border-0 h-100 hover-scale"
                onClick={() => {
                  if (event.id) {
                    navigate(`/visitor/event-details/${event.id}`);
                  }
                }}
                style={{
                  cursor: event.id ? "pointer" : "default",
                  borderRadius: "20px",
                  background: "rgba(255,255,255,0.92)",
                  transition: "0.3s",
                }}
              >
                <div className="card-body p-4">
                  {/* Changed from event.name to event.title */}
                  <h5 className="fw-bold text-primary mb-1">
                    {event.title || "Untitled Event"}
                  </h5>
                  <p className="text-muted small mb-3">
                    {event.description || ""}
                  </p>

                  <p className="fw-semibold text-dark">
                    {formatDate(event.startDate)} — {formatDate(event.endDate)}
                  </p>
                </div>
              </div>
            </div>
          ))}
        </div>
      )}

      <style>{`
        .hover-scale:hover {
          transform: translateY(-6px);
          box-shadow: 0 20px 40px rgba(0,0,0,0.2) !important;
        }
      `}</style>
    </Layout>
  );
};

export default VisitorDashboard;

/* Small Card Component */
const DashboardCard = ({ icon, label, sub, link, color }) => {
  const navigate = useNavigate();

  return (
    <div
      className="card border-0 shadow-lg text-center p-4 h-100"
      style={{
        background: color || "#f8f9fa",
        cursor: "pointer",
        borderRadius: "18px",
      }}
      onClick={() => navigate(link)}
    >
      {icon}
      <h5 className="fw-bold mt-2">{label}</h5>
      <p>{sub}</p>
    </div>
  );
};