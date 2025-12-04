import { useState } from "react";
import { QrCodeScan, CheckCircle } from "lucide-react";
import { Link } from "react-router-dom";
import axios from "axios";
import { QrReader } from "react-qr-reader";

const CheckInPage = () => {
  const [scannedData, setScannedData] = useState("");
  const [message, setMessage] = useState("");

  const handleScan = async (result) => {
    if (result?.text) {
      setScannedData(result.text);

      const userIdMatch = result.text.match(/USER_ID:(\d+)/);
      if (userIdMatch) {
        const userId = userIdMatch[1];
        try {
          const res = await axios.post(`http://localhost:8080/api/checkin/confirm/${userId}`);
          setMessage(res.data);
        } catch {
          setMessage("❌ Invalid QR or user not found!");
        }
      } else {
        setMessage("⚠️ Invalid QR format!");
      }
    }
  };

  return (
    <div
      className="min-vh-100 d-flex flex-column align-items-center justify-content-center text-white"
      style={{
        background: "linear-gradient(135deg, #00b09b, #96c93d)",
      }}
    >
      <div className="container text-center p-5">
        <h2 className="fw-bold mb-4">
          <QrCodeScan size={30} className="me-2" /> Smart Event Entry Check-In
        </h2>

        <div className="bg-light text-dark rounded p-4 shadow w-75 mx-auto">
          <QrReader
            onResult={(result) => handleScan(result)}
            constraints={{ facingMode: "environment" }}
            style={{ width: "100%" }}
          />
        </div>

        {scannedData && (
          <p className="mt-3 text-light">
            <strong>Scanned Data:</strong> {scannedData}
          </p>
        )}

        {message && (
          <div className="alert alert-light mt-3 fw-bold">
            <CheckCircle className="me-2 text-success" />
            {message}
          </div>
        )}

        <Link to="/" className="btn btn-outline-light mt-4">
          ← Back to Home
        </Link>
      </div>
    </div>
  );
};

export default CheckInPage;
