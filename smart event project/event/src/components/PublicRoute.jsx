import { Navigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";

export const PublicRoute = ({ children }) => {
  const { user } = useAuth();

  if (user?.role === "ADMIN") return <Navigate to="/admin/dashboard" replace />;
  if (user?.role === "STALL_OWNER") return <Navigate to="/stall-owner/dashboard" replace />;
  if (user?.role === "VISITOR") return <Navigate to="/visitor/dashboard" replace />;

  return children;
};