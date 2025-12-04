import { useState, useEffect } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import { Button } from '../components/ui/button';
import { Input } from '../components/ui/input';
import { Label } from '../components/ui/label';
import 'bootstrap/dist/css/bootstrap.min.css';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [isLoading, setIsLoading] = useState(false);

  const { login, user, loading } = useAuth();
  const navigate = useNavigate();

  // Auto redirect if already logged in
  useEffect(() => {
    if (!loading && user) {
      if (user.role === 'ADMIN') navigate('/admin/dashboard');
      else if (user.role === 'STALL_OWNER') navigate('/stall-owner/dashboard');
      else if (user.role === 'VISITOR') navigate('/visitor/dashboard');
    }
  }, [user, loading, navigate]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsLoading(true);

    try {
      const { user } = await login(email, password);

      // Store user data
      localStorage.setItem("user", JSON.stringify(user));
      localStorage.setItem("userId", user.id);
      localStorage.setItem("role", user.role);

      // Correct dashboard redirect
      if (user.role === "ADMIN") navigate("/admin/dashboard");
      else if (user.role === "STALL_OWNER") navigate("/stall-owner/dashboard");
      else if (user.role === "VISITOR") navigate("/visitor/dashboard");

    } catch (error) {
      alert("Login failed! Invalid email or password.");
    } finally {
      setIsLoading(false);
    }
  };

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
        className="card shadow-lg p-4 border-0"
        style={{
          maxWidth: '420px',
          width: '100%',
          borderRadius: '20px',
          background: 'rgba(255, 255, 255, 0.92)',
          backdropFilter: 'blur(10px)',
          boxShadow: '0 8px 25px rgba(0, 0, 0, 0.15)',
        }}
      >
        <div className="text-center mb-4">
          <h2 className="fw-bold text-dark">Welcome Back ✨</h2>
          <p className="text-muted">
            Enter your credentials to access your account
          </p>
        </div>

        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <Label htmlFor="email" className="form-label fw-semibold">
              Email
            </Label>
            <Input
              id="email"
              type="email"
              placeholder="Enter your email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
              className="form-control rounded-pill shadow-sm"
            />
          </div>

          <div className="mb-3">
            <Label htmlFor="password" className="form-label fw-semibold">
              Password
            </Label>
            <Input
              id="password"
              type="password"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
              className="form-control rounded-pill shadow-sm"
            />
          </div>

          <div className="d-grid mt-4">
            <Button
              type="submit"
              className="btn btn-primary rounded-pill fw-semibold py-2 shadow-sm"
              disabled={isLoading}
              style={{
                background:
                  'linear-gradient(90deg, #ee0979 0%, #ff6a00 100%)',
                border: 'none',
              }}
            >
              {isLoading ? 'Logging in...' : 'Login'}
            </Button>
          </div>
        </form>

        <div className="text-center mt-4">
          <p className="text-muted">
            Don't have an account?{' '}
            <Link
              to="/auth/signup"
              className="fw-semibold text-decoration-none"
              style={{ color: '#ee0979' }}
            >
              Sign up
            </Link>
          </p>

          <Link
            to="/"
            className="btn btn-outline-dark rounded-pill fw-semibold px-4"
          >
            Go to Home Page
          </Link>
        </div>

      </div>
    </div>
  );
};

export default Login;
