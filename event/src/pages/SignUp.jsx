import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import Layout from "../components/Layout";
import { Button } from "../components/ui/button";
import { Input } from "../components/ui/input";
import { Label } from "../components/ui/label";
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "../components/ui/card";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "../components/ui/select";
import { useToast } from "../hooks/use-toast";
import { API_BASE_URL } from "../config/api";

const Signup = () => {
  const [formData, setFormData] = useState({
    username: "",
    fullName: "",
    email: "",
    password: "",
    confirmPassword: "",
    role: "VISITOR",
    phone: "",
  });

  const [isLoading, setIsLoading] = useState(false);
  const { login } = useAuth(); // Use login instead of signup
  const { toast } = useToast();
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (formData.password !== formData.confirmPassword) {
      toast({
        variant: "destructive",
        title: "Password mismatch",
        description: "Passwords do not match",
      });
      return;
    }

    setIsLoading(true);

    try {
      const { confirmPassword, ...signupData } = formData;

      // Map frontend field names to backend expectations
      const payload = {
        username: signupData.username,
        name: signupData.fullName, // Backend might expect 'name' instead of 'fullName'
        email: signupData.email,
        password: signupData.password,
        role: signupData.role,
        phone: signupData.phone,
      };

      console.log("Sending signup payload:", payload);

      // Call backend /auth/register directly
      const response = await fetch(`${API_BASE_URL}/auth/register`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(payload),
      });

      if (!response.ok) {
        const errorText = await response.text();
        console.error("Signup error:", errorText);
        throw new Error(errorText || "Signup failed");
      }

      const data = await response.json();

      toast({
        title: "Account created successfully 🎉",
        description: `Welcome, ${data.user?.name || data.user?.fullName || formData.fullName}!`,
      });

      // Auto-login after successful signup
      await login({
        username: formData.username,
        password: formData.password,
      });

      // Redirect based on user role
      if (data.user?.role === "ADMIN") {
        navigate("/admin/dashboard");
      } else if (data.user?.role === "STALL_OWNER") {
        navigate("/stall-owner/dashboard");
      } else {
        navigate("/visitor/dashboard");
      }
    } catch (err) {
      toast({
        variant: "destructive",
        title: "Signup failed ❌",
        description: err.message || "Something went wrong",
      });
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <Layout title="Signup - Smart Event System">
      <div
        className="d-flex align-items-center justify-content-center"
        style={{ minHeight: "80vh" }}
      >
        <Card
          className="w-100 shadow-lg"
          style={{
            maxWidth: "450px",
            background: "rgba(255, 255, 255, 0.15)",
            borderRadius: "20px",
            backdropFilter: "blur(12px)",
            boxShadow: "0 8px 20px rgba(0,0,0,0.3)",
            color: "#fff",
          }}
        >
          <CardHeader className="text-center">
            <CardTitle className="text-3xl fw-bold text-white">
              Create Account ✨
            </CardTitle>
            <CardDescription className="text-light">
              Fill in your details to get started
            </CardDescription>
          </CardHeader>

          <form onSubmit={handleSubmit}>
            <CardContent className="space-y-3">
              {/* Username */}
              <div className="space-y-1">
                <Label htmlFor="username" className="text-white fw-semibold">
                  Username
                </Label>
                <Input
                  id="username"
                  name="username"
                  placeholder="Enter your username"
                  value={formData.username}
                  onChange={handleChange}
                  required
                  className="bg-transparent border-light text-white"
                />
              </div>

              {/* Full Name */}
              <div className="space-y-1">
                <Label htmlFor="fullName" className="text-white fw-semibold">
                  Full Name
                </Label>
                <Input
                  id="fullName"
                  name="fullName"
                  placeholder="Enter your full name"
                  value={formData.fullName}
                  onChange={handleChange}
                  required
                  className="bg-transparent border-light text-white"
                />
              </div>

              {/* Email */}
              <div className="space-y-1">
                <Label htmlFor="email" className="text-white fw-semibold">
                  Email
                </Label>
                <Input
                  id="email"
                  name="email"
                  type="email"
                  placeholder="Enter your email"
                  value={formData.email}
                  onChange={handleChange}
                  required
                  className="bg-transparent border-light text-white"
                />
              </div>

              {/* Phone */}
              <div className="space-y-1">
                <Label htmlFor="phone" className="text-white fw-semibold">
                  Phone Number
                </Label>
                <Input
                  id="phone"
                  name="phone"
                  type="tel"
                  placeholder="Enter your phone"
                  value={formData.phone}
                  onChange={handleChange}
                  required
                  className="bg-transparent border-light text-white"
                />
              </div>

              {/* Role */}
              <div className="space-y-1">
                <Label htmlFor="role" className="text-white fw-semibold">
                  I am a
                </Label>
                <Select
                  value={formData.role}
                  onValueChange={(value) =>
                    setFormData({ ...formData, role: value })
                  }
                >
                  <SelectTrigger className="bg-transparent border-light text-white">
                    <SelectValue placeholder="Select role" />
                  </SelectTrigger>
                  <SelectContent>
                    <SelectItem value="VISITOR">Visitor</SelectItem>
                    <SelectItem value="STALL_OWNER">Stall Owner</SelectItem>
                    <SelectItem value="ADMIN">Admin</SelectItem>
                  </SelectContent>
                </Select>
              </div>

              {/* Password */}
              <div className="space-y-1">
                <Label htmlFor="password" className="text-white fw-semibold">
                  Password
                </Label>
                <Input
                  id="password"
                  name="password"
                  type="password"
                  placeholder="Create a password"
                  value={formData.password}
                  onChange={handleChange}
                  required
                  className="bg-transparent border-light text-white"
                />
              </div>

              {/* Confirm Password */}
              <div className="space-y-1">
                <Label
                  htmlFor="confirmPassword"
                  className="text-white fw-semibold"
                >
                  Confirm Password
                </Label>
                <Input
                  id="confirmPassword"
                  name="confirmPassword"
                  type="password"
                  placeholder="Confirm your password"
                  value={formData.confirmPassword}
                  onChange={handleChange}
                  required
                  className="bg-transparent border-light text-white"
                />
              </div>
            </CardContent>

            <CardFooter className="flex flex-column gap-3">
              <Button
                type="submit"
                disabled={isLoading}
                className="w-100 fw-bold shadow-lg"
                style={{
                  background:
                    "linear-gradient(90deg, #ff6b6b, #f7b42c, #4facfe)",
                  border: "none",
                  color: "#fff",
                }}
              >
                {isLoading ? "Creating account..." : "Sign Up"}
              </Button>

              <p className="text-center text-light mb-0">
                Already have an account?{" "}
                <Link
                  to="/auth/login"
                  className="fw-semibold text-white text-decoration-underline"
                >
                  Login
                </Link>
              </p>
            </CardFooter>
          </form>
        </Card>
      </div>
    </Layout>
  );
};

export default Signup;