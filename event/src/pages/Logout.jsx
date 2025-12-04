import { useEffect } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { LogOut } from 'lucide-react';
import 'bootstrap/dist/css/bootstrap.min.css';

const Logout = () => {
  const navigate = useNavigate();

  useEffect(() => {
    const timer = setTimeout(() => {
      navigate('/login');
    }, 2000);
    return () => clearTimeout(timer);
  }, [navigate]);

  return (
    <div
      className="min-vh-100 d-flex align-items-center justify-content-center"
      style={{
        background:
          'linear-gradient(135deg, #ff6a00 0%, #ee0979 50%, #fcb045 100%)',
        padding: '20px',
      }}
    >
      <div
        className="card shadow-lg p-4 border-0 text-center"
        style={{
          maxWidth: '420px',
          width: '100%',
          borderRadius: '20px',
          background: 'rgba(255, 255, 255, 0.92)',
          backdropFilter: 'blur(10px)',
          boxShadow: '0 8px 25px rgba(0, 0, 0, 0.15)',
        }}
      >
        <div
          className="d-flex justify-content-center align-items-center mb-4 mx-auto"
          style={{
            width: '80px',
            height: '80px',
            background: 'rgba(255, 106, 0, 0.1)',
            borderRadius: '50%',
          }}
        >
          <LogOut size={38} color="#ee0979" />
        </div>

        <h2 className="fw-bold text-dark mb-2">Logout Successful 🎉</h2>

        <p className="text-muted mb-4">
          You have been securely logged out. Redirecting to login page...
        </p>

        <div
          className="spinner-border text-danger mb-3 mx-auto"
          role="status"
          style={{ width: '2.5rem', height: '2.5rem' }}
        >
          <span className="visually-hidden">Loading...</span>
        </div>

        <Link
          to="/login"
          className="btn btn-outline-dark rounded-pill fw-semibold mt-3 px-4"
        >
          Go to Login Page
        </Link>
      </div>
    </div>
  );
};

export default Logout;
