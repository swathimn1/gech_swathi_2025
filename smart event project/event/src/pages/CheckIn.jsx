import { useState } from "react";
import { QrCode, Download, Share2, CheckCircle } from "lucide-react";
import Layout from "../components/Layout"; // ✅ use same layout
import "bootstrap/dist/css/bootstrap.min.css";

const CheckIn = () => {
  const [eventId, setEventId] = useState("");
  const [qrGenerated, setQrGenerated] = useState(false);

  const generateQR = (e) => {
    e.preventDefault();
    if (eventId.trim()) {
      setQrGenerated(true);
    }
  };

  const downloadQR = () => {
    alert("✅ QR Code downloaded successfully!");
  };

  const shareQR = () => {
    alert("📤 Share functionality coming soon!");
  };

  return (
    <Layout title="Smart Check-In">
      <div className="container py-5">
        <div className="row justify-content-center">
          <div className="col-lg-10 col-xl-8">
            <div
              className="card border-0 shadow-lg"
              style={{
                borderRadius: "25px",
                background: "rgba(255,255,255,0.15)",
                backdropFilter: "blur(10px)",
              }}
            >
              <div className="card-body p-5 text-white">
                {/* Header */}
                <div className="text-center mb-5">
                  <div
                    className="d-inline-flex align-items-center justify-content-center rounded-circle mb-4"
                    style={{
                      width: "100px",
                      height: "100px",
                      background:
                        "linear-gradient(135deg, #667eea, #764ba2)",
                    }}
                  >
                    <QrCode size={50} className="text-white" />
                  </div>
                  <h1 className="fw-bold mb-3" style={{ fontSize: "2.5rem" }}>
                    Smart Check-In QR Code
                  </h1>
                  <p className="text-light fs-5">
                    Generate QR codes for quick and secure event entry
                  </p>
                </div>

                {/* Form Section */}
                <div
                  className="mb-5 p-4 rounded-4"
                  style={{
                    background:
                      "linear-gradient(135deg, rgba(245,247,250,0.2), rgba(195,207,226,0.2))",
                  }}
                >
                  <form onSubmit={generateQR}>
                    <label className="form-label fw-bold fs-5 mb-3 text-white">
                      Enter Event ID or Name
                    </label>
                    <input
                      type="text"
                      className="form-control form-control-lg mb-4 border-2"
                      placeholder="e.g., EVENT2024001 or Tech Conference 2024"
                      value={eventId}
                      onChange={(e) => setEventId(e.target.value)}
                      required
                      style={{
                        borderRadius: "15px",
                        fontSize: "1.1rem",
                        padding: "15px 20px",
                      }}
                    />
                    <button
                      type="submit"
                      className="btn btn-lg w-100 fw-bold shadow text-white"
                      style={{
                        background:
                          "linear-gradient(135deg, #667eea, #764ba2)",
                        borderRadius: "15px",
                        padding: "15px",
                        fontSize: "1.2rem",
                        border: "none",
                      }}
                    >
                      Generate QR Code
                    </button>
                  </form>
                </div>

                {/* QR Display Section */}
                {qrGenerated && eventId && (
                  <div
                    className="text-center p-5 rounded-4 mb-5"
                    style={{
                      border: "3px solid rgba(102,126,234,0.5)",
                      background: "rgba(255,255,255,0.1)",
                    }}
                  >
                    <div
                      className="mx-auto mb-4 d-flex align-items-center justify-content-center rounded-4 shadow-lg"
                      style={{
                        width: "300px",
                        height: "300px",
                        background:
                          "linear-gradient(135deg, #e0c3fc 0%, #8ec5fc 100%)",
                      }}
                    >
                      <div className="text-center">
                        <QrCode size={150} style={{ color: "#667eea" }} />
                        <p
                          className="mt-3 mb-0 fw-bold text-dark"
                          style={{
                            fontFamily: "monospace",
                            fontSize: "0.9rem",
                          }}
                        >
                          {eventId}
                        </p>
                      </div>
                    </div>

                    <div className="d-flex align-items-center justify-content-center gap-2 mb-4">
                      <CheckCircle size={24} className="text-success" />
                      <h3 className="fw-bold mb-0 text-white">
                        QR Code Generated!
                      </h3>
                    </div>
                    <p className="text-light mb-4 fs-5">
                      Scan this code at the event entrance for quick check-in
                    </p>

                    <div className="d-flex gap-3 justify-content-center">
                      <button
                        onClick={downloadQR}
                        className="btn btn-lg px-5 fw-semibold shadow text-white"
                        style={{
                          background: "#667eea",
                          borderRadius: "12px",
                          border: "none",
                        }}
                      >
                        <Download size={20} className="me-2" />
                        Download QR
                      </button>
                      <button
                        onClick={shareQR}
                        className="btn btn-lg btn-outline-light px-5 fw-semibold"
                        style={{
                          borderRadius: "12px",
                          borderWidth: "2px",
                        }}
                      >
                        <Share2 size={20} className="me-2" />
                        Share
                      </button>
                    </div>
                  </div>
                )}

                {/* Features Section */}
                <div className="row g-4">
                  <div className="col-md-4">
                    <div
                      className="text-center p-4 rounded-4 h-100"
                      style={{
                        background:
                          "linear-gradient(135deg, rgba(224,247,250,0.3), rgba(178,235,242,0.3))",
                      }}
                    >
                      <div className="fw-bold fs-2 mb-2 text-info">⚡ Fast</div>
                      <p className="mb-0">Instant QR code generation</p>
                    </div>
                  </div>
                  <div className="col-md-4">
                    <div
                      className="text-center p-4 rounded-4 h-100"
                      style={{
                        background:
                          "linear-gradient(135deg, rgba(232,245,233,0.3), rgba(200,230,201,0.3))",
                      }}
                    >
                      <div className="fw-bold fs-2 mb-2 text-success">
                        🔒 Secure
                      </div>
                      <p className="mb-0">Encrypted event verification</p>
                    </div>
                  </div>
                  <div className="col-md-4">
                    <div
                      className="text-center p-4 rounded-4 h-100"
                      style={{
                        background:
                          "linear-gradient(135deg, rgba(243,229,245,0.3), rgba(225,190,231,0.3))",
                      }}
                    >
                      <div className="fw-bold fs-2 mb-2 text-warning">
                        ✅ Easy
                      </div>
                      <p className="mb-0">Simple scan-and-enter process</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </Layout>
  );
};

export default CheckIn;
