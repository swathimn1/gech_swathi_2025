import React from "react";
import { Link, useNavigate } from "react-router-dom";
import { Calendar, Users, QrCode, Star, MessageSquare, LogOut } from "lucide-react";
import "bootstrap/dist/css/bootstrap.min.css";
import Layout from "../../components/Layout";
import { useAuth } from "../../context/AuthContext";
import { useToast } from "../../hooks/use-toast";

const AdminDashboard = () => {
  const navigate = useNavigate();
  const { logout, user } = useAuth();
  const { toast } = useToast();

  const handleLogout = () => {
    logout();
    toast({ title: "Logout Successful", description: "You have been logged out.", duration: 2000 });
    navigate("/login");
  };

  const cards = [
    { icon: <Calendar size={50} className="mx-auto mb-3 text-primary" />, title: "Manage Events", desc: "Add or manage events.", link: "/admin/events", btnClass: "btn-primary" },
    { icon: <Users size={40} className="mx-auto mb-3 text-success" />, title: "Manage Users", desc: "View registered users.", link: "/admin/users", btnClass: "btn-success" },
    { icon: <QrCode size={40} className="mx-auto mb-3 text-warning" />, title: "QR Code System", desc: "Generate & manage QR codes.", link: "/admin/qrcode", btnClass: "btn-warning" },
    { icon: <Star size={40} className="mx-auto mb-3 text-danger" />, title: "Feedback & Ratings", desc: "View visitor feedback.", link: "/admin/feedback", btnClass: "btn-danger" },
    { icon: <MessageSquare size={40} className="mx-auto mb-3 text-secondary" />, title: "Query Management", desc: "Respond to visitor queries.", link: "/admin/queries", btnClass: "btn-secondary" },
    { icon: <MessageSquare size={40} className="mx-auto mb-3 text-info" />, title: "Email Templates", desc: "Preview automated emails.", link: "/email-preview", btnClass: "btn-info" },
  ];

  return (
    <Layout title="Admin Dashboard | Smart Event System">
      <div className="d-flex justify-content-between align-items-center mb-4">
        <h2 className="fw-bold text-white">Welcome back, {user?.fullName || "Admin"} 👑</h2>
        <button className="btn btn-danger btn-sm d-flex align-items-center fw-semibold" onClick={handleLogout}>
          <LogOut size={16} className="me-2" /> Logout
        </button>
      </div>

      <div className="row row-cols-1 row-cols-md-3 g-4">
        {cards.map((card) => (
          <div className="col" key={card.title}>
            <DashboardCard {...card} />
          </div>
        ))}
      </div>
    </Layout>
  );
};

export default AdminDashboard;

const DashboardCard = ({ icon, title, desc, link, btnClass }) => (
  <div className="card border-0 shadow-lg text-center p-4 h-200 bg-light text-dark dashboard-card">
    {icon}
    <h5 className="fw-bold">{title}</h5>
    <p>{desc}</p>
    <Link to={link} className={`btn ${btnClass} w-100`}>
      {title}
    </Link>
  </div>
);
