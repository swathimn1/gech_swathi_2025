import { Link } from "react-router-dom";
import { Users, ArrowRight, Lightbulb, ShieldCheck, Globe2, BarChart3 } from "lucide-react";
import Layout from "../components/Layout";

const About = () => {
  return (
    <Layout title="About Smart Event System">
      <div className="container py-5">
        <div className="row justify-content-center">
          <div className="col-lg-10">

            {/* HERO SECTION */}
            <div className="text-center mb-5">
              <h1 className="fw-bold display-4" style={{ color: "#1a2b4b" }}>
                Smart Event System
              </h1>
              <p className="lead text-muted mt-3" style={{ maxWidth: "700px", margin: "0 auto" }}>
                A powerful platform designed to simplify event management and deliver seamless, smart experiences.
              </p>
            </div>

            {/* WHO WE ARE */}
            <div className="card shadow-sm border-0 rounded-4 mb-5">
              <div className="card-body p-5">
                <h2 className="fw-bold fs-2 mb-3" style={{ color: "#1a2b4b" }}>Who We Are</h2>
                <p className="text-muted fs-5">
                  We are a team of innovators passionate about transforming the event industry.
                  From small workshops to large conferences, Smart Event System offers tools that make planning,
                  management, and execution effortless.
                </p>
              </div>
            </div>

            {/* FEATURES GRID */}
            <div className="row g-4 mb-5">

              <div className="col-md-6">
                <div className="p-4 rounded-4 shadow-sm h-100" style={{ background: "#eef7ff" }}>
                  <Users size={40} className="mb-3 text-primary" />
                  <h4 className="fw-bold text-dark">Smarter Event Planning</h4>
                  <p className="text-muted mb-0">
                    Organize events with intelligent scheduling, automation, and streamlined coordination.
                  </p>
                </div>
              </div>

              <div className="col-md-6">
                <div className="p-4 rounded-4 shadow-sm h-100" style={{ background: "#fdf1ff" }}>
                  <BarChart3 size={40} className="mb-3" style={{ color: "#b026b0" }} />
                  <h4 className="fw-bold text-dark">Live Analytics</h4>
                  <p className="text-muted mb-0">
                    Visualize real-time insights to make better decisions and deliver successful events.
                  </p>
                </div>
              </div>

              <div className="col-md-6">
                <div className="p-4 rounded-4 shadow-sm h-100" style={{ background: "#fff4e6" }}>
                  <Lightbulb size={40} className="mb-3" style={{ color: "#ff9800" }} />
                  <h4 className="fw-bold text-dark">Secure & Intelligent</h4>
                  <p className="text-muted mb-0">
                    Built with modern security standards to ensure safe event management anytime.
                  </p>
                </div>
              </div>

              <div className="col-md-6">
                <div className="p-4 rounded-4 shadow-sm h-100" style={{ background: "#e8fff1" }}>
                  <ShieldCheck size={40} className="mb-3" style={{ color: "#2e7d32" }} />
                  <h4 className="fw-bold text-dark">Reliable & Scalable</h4>
                  <p className="text-muted mb-0">
                    Whether it’s 50 attendees or 50,000 — our system scales according to your needs.
                  </p>
                </div>
              </div>

            </div>

            {/* GLOBAL IMPACT */}
            <div className="card shadow-sm border-0 rounded-4 mb-5">
              <div className="card-body p-5 text-center">
                <Globe2 size={50} className="text-primary mb-3" />
                <h2 className="fw-bold fs-2 mb-4" style={{ color: "#1a2b4b" }}>Our Global Reach</h2>

                <div className="row text-center">
                  <div className="col-md-3 mb-4">
                    <h3 className="fw-bold display-6">500+</h3>
                    <p className="text-muted">Events</p>
                  </div>
                  <div className="col-md-3 mb-4">
                    <h3 className="fw-bold display-6">10K+</h3>
                    <p className="text-muted">Users</p>
                  </div>
                  <div className="col-md-3 mb-4">
                    <h3 className="fw-bold display-6">40+</h3>
                    <p className="text-muted">Cities</p>
                  </div>
                  <div className="col-md-3 mb-4">
                    <h3 className="fw-bold display-6">99.9%</h3>
                    <p className="text-muted">Uptime</p>
                  </div>
                </div>
              </div>
            </div>

            {/* CTA */}
            <div
              className="p-5 rounded-4 text-center shadow-sm mb-5"
              style={{ background: "linear-gradient(135deg, #4fc3f7, #007bff)" }}
            >
              <h2 className="fw-bold text-white mb-3">Ready to Create Smart Events?</h2>
              <p className="text-white fs-5 mb-4">
                Start your journey with our smart and powerful event management platform.
              </p>
              <Link
                to="/register"
                className="btn btn-light px-5 py-3 fw-semibold"
                style={{ borderRadius: "12px", fontSize: "1.2rem" }}
              >
                Get Started <ArrowRight size={20} className="ms-2" />
              </Link>
            </div>

          </div>
        </div>
      </div>
    </Layout>
  );
};

export default About;
