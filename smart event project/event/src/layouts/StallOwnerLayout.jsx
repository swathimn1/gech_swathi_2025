import React from 'react';
import { Outlet, useNavigate } from 'react-router-dom';

const StallOwnerLayout = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    if (window.confirm('Are you sure you want to logout?')) {
      localStorage.removeItem('isLoggedIn');
      localStorage.removeItem('userRole');
      navigate('/login');
    }
  };

  return (
    <div className="min-vh-100" style={{ background: 'linear-gradient(135deg, #667eea 0%, #764ba2 100%)' }}>
      {/* Navigation Bar */}
      <nav className="navbar navbar-expand-lg" style={{ backgroundColor: '#d2691e' }}>
        <div className="container-fluid">
          <a 
            className="navbar-brand text-white fw-bold" 
            href="#" 
            onClick={(e) => {
              e.preventDefault();
              navigate('/stall-owner/dashboard');
            }}
            style={{ cursor: 'pointer' }}
          >
            🎪 Smart Event System
          </a>
          <div className="d-flex gap-2">
            <button 
              className="btn btn-outline-light"
              onClick={() => navigate('/stall-owner/dashboard')}
            >
              🏠 Home
            </button>
            <button 
              className="btn btn-danger"
              onClick={handleLogout}
            >
              🚪 Logout
            </button>
          </div>
        </div>
      </nav>

      {/* Page Content */}
      <Outlet />

      {/* Footer */}
      <footer className="text-center text-white py-3 mt-5" style={{ backgroundColor: 'rgba(0,0,0,0.3)' }}>
        <p className="mb-0">© 2025 Smart Event System | Stall Owner Dashboard</p>
      </footer>

      {/* Bootstrap CSS */}
      <link 
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
        rel="stylesheet"
      />
    </div>
  );
};

export default StallOwnerLayout;