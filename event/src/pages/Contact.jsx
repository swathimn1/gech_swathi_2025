import { useState } from "react";
import { Mail, Phone, MapPin, Send, Instagram, Facebook, Linkedin, Twitter } from "lucide-react";
import Layout from "../components/Layout";
import "bootstrap/dist/css/bootstrap.min.css";

const Contact = () => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    subject: "",
    message: "",
  });

  const [sent, setSent] = useState(false);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setSent(true);
    setTimeout(() => {
      setSent(false);
      setFormData({ name: "", email: "", subject: "", message: "" });
    }, 2500);
  };

  return (
    <Layout title="Contact Us">
      <div
        className="py-5"
        style={{
          background: "linear-gradient(135deg, #ff758c, #ff7eb3)",
          minHeight: "100vh",
        }}
      >
        <div className="container">

          {/* TITLE */}
          <div className="text-center text-white mb-5">
            <h1 className="display-4 fw-bold">Let’s Talk</h1>
            <p className="lead">
              We are here to help. Reach out with any queries or feedback.
            </p>
          </div>

          <div className="row g-4 justify-content-center align-items-start">

            {/* LEFT CARD */}
            <div className="col-lg-4">
              <div
                className="p-4 shadow-lg text-white"
                style={{
                  borderRadius: "20px",
                  backdropFilter: "blur(12px)",
                  background: "rgba(255, 255, 255, 0.12)",
                }}
              >
                <h3 className="fw-bold mb-4">Contact Details</h3>

                <div className="d-flex align-items-center mb-4">
                  <div className="me-3 p-3 rounded-circle bg-white text-dark shadow">
                    <Mail size={22} />
                  </div>
                  <div>
                    <p className="mb-1 fw-bold">Email</p>
                    <p className="small mb-0">support@smartevent.com</p>
                  </div>
                </div>

                <div className="d-flex align-items-center mb-4">
                  <div className="me-3 p-3 rounded-circle bg-white text-dark shadow">
                    <Phone size={22} />
                  </div>
                  <div>
                    <p className="mb-1 fw-bold">Phone</p>
                    <p className="small mb-0">+91 98765 43210</p>
                  </div>
                </div>

                <div className="d-flex align-items-center mb-4">
                  <div className="me-3 p-3 rounded-circle bg-white text-dark shadow">
                    <MapPin size={22} />
                  </div>
                  <div>
                    <p className="mb-1 fw-bold">Office</p>
                    <p className="small mb-0">Bengaluru, Karnataka</p>
                  </div>
                </div>

                {/* Social */}
                <h5 className="fw-bold mt-4 mb-3">Follow Us</h5>
                <div className="d-flex gap-3">
                  {[Facebook, Twitter, Instagram, Linkedin].map((Icon, i) => (
                    <div
                      key={i}
                      className="d-flex align-items-center justify-content-center shadow"
                      style={{
                        width: "45px",
                        height: "45px",
                        borderRadius: "50%",
                        background: "rgba(255,255,255,0.2)",
                        cursor: "pointer",
                        transition: "0.3s",
                      }}
                      onMouseEnter={(e) =>
                        (e.currentTarget.style.background = "white")
                      }
                      onMouseLeave={(e) =>
                        (e.currentTarget.style.background =
                          "rgba(255,255,255,0.2)")
                      }
                    >
                      <Icon size={22} color="white" />
                    </div>
                  ))}
                </div>
              </div>
            </div>

            {/* RIGHT FORM */}
            <div className="col-lg-8">
              <div
                className="p-5 bg-white shadow-lg"
                style={{
                  borderRadius: "20px",
                }}
              >
                <h2 className="fw-bold mb-4" style={{ color: "#1f1c2c" }}>
                  Send a Message
                </h2>

                {sent && (
                  <div className="alert alert-success fw-bold mb-4">
                    Message sent successfully!
                  </div>
                )}

                <form onSubmit={handleSubmit}>
                  <div className="row">
                    <div className="col-md-6 mb-4">
                      <label className="fw-semibold">Your Name</label>
                      <input
                        type="text"
                        name="name"
                        required
                        placeholder="Enter your full name"
                        className="form-control"
                        style={{
                          borderRadius: "12px",
                          padding: "12px 15px",
                          border: "2px solid #ddd",
                        }}
                        value={formData.name}
                        onChange={handleChange}
                      />
                    </div>

                    <div className="col-md-6 mb-4">
                      <label className="fw-semibold">Email</label>
                      <input
                        type="email"
                        name="email"
                        required
                        placeholder="Enter your email address"
                        className="form-control"
                        style={{
                          borderRadius: "12px",
                          padding: "12px 15px",
                          border: "2px solid #ddd",
                        }}
                        value={formData.email}
                        onChange={handleChange}
                      />
                    </div>
                  </div>

                  <div className="mb-4">
                    <label className="fw-semibold">Subject</label>
                    <input
                      type="text"
                      name="subject"
                      required
                      placeholder="Enter the subject of your message"
                      className="form-control"
                      style={{
                        borderRadius: "12px",
                        padding: "12px 15px",
                        border: "2px solid #ddd",
                      }}
                      value={formData.subject}
                      onChange={handleChange}
                    />
                  </div>

                  <div className="mb-4">
                    <label className="fw-semibold">Message</label>
                    <textarea
                      name="message"
                      rows="6"
                      required
                      placeholder="Type your message here..."
                      className="form-control"
                      style={{
                        borderRadius: "12px",
                        padding: "12px 15px",
                        border: "2px solid #ddd",
                      }}
                      value={formData.message}
                      onChange={handleChange}
                    ></textarea>
                  </div>

                  <button
                    type="submit"
                    className="btn w-100 text-white fw-bold py-3"
                    style={{
                      fontSize: "1.2rem",
                      borderRadius: "12px",
                      background: "linear-gradient(135deg, #ff758c, #ff7eb3)",
                      transition: "0.3s",
                      boxShadow: "0 4px 20px rgba(0,0,0,0.2)",
                    }}
                  >
                    <Send size={20} className="me-2" />
                    Send Message
                  </button>
                </form>
              </div>
            </div>

          </div>
        </div>
      </div>
    </Layout>
  );
};

export default Contact;
