import React, { useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import { AuthContext } from "../auth/AuthContext";

export default function Navbar() {
  const { user, logout } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate("/login");
  };

  return (
    <nav className="bg-white border-b shadow-sm">
      <div className="max-w-6xl mx-auto px-4 py-3 flex items-center justify-between">
        <div className="flex items-center gap-4">
          <Link to="/" className="text-xl font-bold text-sky-600">SmartEvent</Link>
          <Link to="/" className="text-sm text-gray-600 hover:underline">Events</Link>
          {user && user.role === "STALL_OWNER" && (
            <Link to="/owner" className="text-sm text-gray-600 hover:underline">Owner Dashboard</Link>
          )}
          {user && user.role === "ADMIN" && (
            <Link to="/admin" className="text-sm text-gray-600 hover:underline">Admin Dashboard</Link>
          )}
        </div>

        <div className="flex items-center gap-4">
          {user ? (
            <>
              <span className="text-sm text-gray-700">Hi, {user.name}</span>
              <button
                onClick={handleLogout}
                className="bg-red-500 text-white px-3 py-1 rounded text-sm"
              >
                Logout
              </button>
            </>
          ) : (
            <>
              <Link to="/login" className="text-sm text-gray-700 hover:underline">Login</Link>
              <Link to="/register" className="text-sm text-sky-600 font-medium">Register</Link>
            </>
          )}
        </div>
      </div>
    </nav>
  );
}
