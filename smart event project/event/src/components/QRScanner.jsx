import React, { useState, useEffect, useRef } from "react";
import axios from "../api/axios";
import { Html5QrcodeScanner } from "html5-qrcode";
import QRCode from "react-qr-code";
import Layout from "../components/Layout";
import { API_ENDPOINTS, getAuthHeader } from "../config/api";
import "bootstrap/dist/css/bootstrap.min.css";

const QRScanner = () => {
  const [scannedData, setScannedData] = useState([]);
  const [points, setPoints] = useState(0);
  const [showScanner, setShowScanner] = useState(false);
  const [showPointsAnimation, setShowPointsAnimation] = useState(false);
  const [qrInput, setQrInput] = useState("Hello World!");
  const qrRef = useRef();
  const scannerRef = useRef(null);

  useEffect(() => {
    fetchScans();
    fetchPoints();
  }, []);

  const fetchScans = async () => {
    try {
      const res = await axios.get(API_ENDPOINTS.VISITOR.SCAN, {
        headers: getAuthHeader(),
      });
      setScannedData(res.data);
    } catch (error) {
      console.error("Error fetching scans:", error);
    }
  };

  const fetchPoints = async () => {
    try {
      const res = await axios.get(API_ENDPOINTS.VISITOR.SCAN_POINTS, {
        headers: getAuthHeader(),
      });
      setPoints(res.data.totalPoints);
    } catch (error) {
      console.error("Error fetching points:", error);
    }
  };

  const addScan = async (content) => {
    try {
      const res = await axios.post(
        API_ENDPOINTS.VISITOR.SCAN,
        { content },
        { headers: { "Content-Type": "application/json", ...getAuthHeader() } }
      );

      setScannedData((prev) => [...prev, res.data]);
      setPoints((prev) => prev + 10);

      fetchPoints(); 

      setShowPointsAnimation(true);
      setTimeout(() => setShowPointsAnimation(false), 2000);
    } catch (error) {
      console.error("Error adding scan:", error);
    }
  };

  const deleteScan = async (id) => {
    if (window.confirm("Delete this scan?")) {
      try {
        await axios.delete(`${API_ENDPOINTS.VISITOR.SCAN}/${id}`, {
          headers: getAuthHeader(),
        });
        fetchScans();
        fetchPoints();
      } catch (error) {
        console.error("Error deleting scan:", error);
      }
    }
  };

  const deleteAllScans = async () => {
    if (window.confirm("Delete all scans?")) {
      try {
        await axios.delete(API_ENDPOINTS.VISITOR.SCAN_DELETE_ALL, {
          headers: getAuthHeader(),
        });
        setScannedData([]);
        setPoints(0);
      } catch (error) {
        console.error("Error deleting all scans:", error);
      }
    }
  };

  useEffect(() => {
    if (showScanner && !scannerRef.current) {
      try {
        scannerRef.current = new Html5QrcodeScanner("reader", {
          qrbox: { width: 250, height: 250 },
          fps: 5,
        });
        scannerRef.current.render(onScanSuccess, onScanError);
      } catch (err) {
        console.error("Error initializing scanner:", err);
      }
    }

    return () => {
      if (scannerRef.current && !showScanner) {
        scannerRef.current.clear().catch(console.error);
        scannerRef.current = null;
      }
    };
  }, [showScanner]);

  const onScanSuccess = (decodedText) => {
    addScan(decodedText);
    setShowScanner(false);
  };

  const onScanError = () => {};

  const scanGeneratedQRCode = () => {
    addScan(qrInput);
  };

  return (
    <Layout title="QR Scanner">
      <div className="container py-4 text-white">
        <h1 className="text-center fw-bold mb-4">📷 QR Code Scanner & Generator</h1>

        {/* QR Generator */}
        <div className="p-4 mb-5 rounded" style={glassStyle}>
          <h5 className="fw-bold mb-3">Generate QR Code</h5>
          <input
            type="text"
            className="form-control mb-3 bg-transparent text-white border-light"
            value={qrInput}
            onChange={(e) => setQrInput(e.target.value)}
          />
          <div className="text-center mb-3 p-3 bg-white rounded" ref={qrRef}>
            <QRCode value={qrInput} size={200} />
          </div>
          <div className="text-center">
            <button className="btn btn-info" onClick={scanGeneratedQRCode}>
              📷 Scan Generated QR
            </button>
          </div>
        </div>

        {/* Camera Scanner */}
        <div className="p-4 mb-4 rounded" style={glassStyle}>
          <h5 className="fw-bold mb-3">Camera Scanner</h5>
          <div className="d-flex gap-2 align-items-center flex-wrap">
            <button
              className={`btn ${showScanner ? "btn-danger" : "btn-success"}`}
              onClick={() => setShowScanner(!showScanner)}
            >
              {showScanner ? "Stop Scanning" : "Start Scanning"}
            </button>
          </div>
          {showScanner && <div id="reader" className="mt-3"></div>}
        </div>

        {/* Scanned Data */}
        <div className="p-4 rounded" style={glassStyle}>
          <h5 className="fw-bold mb-3">Scanned Data</h5>
          {scannedData.length === 0 ? (
            <p className="text-muted">No scans yet.</p>
          ) : (
            <ul className="list-group">
              {scannedData.map((scan) => (
                <li
                  key={scan.id}
                  className="list-group-item d-flex justify-content-between align-items-center bg-transparent text-white border-light"
                >
                  <span>
                    {scan.content} <br />
                    <small className="text-secondary">
                      {new Date(scan.timestamp).toLocaleString()}
                    </small>
                  </span>
                  <button
                    className="btn btn-sm btn-danger"
                    onClick={() => deleteScan(scan.id)}
                  >
                    🗑️
                  </button>
                </li>
              ))}
            </ul>
          )}
          {scannedData.length > 0 && (
            <div className="text-center mt-3">
              <button className="btn btn-warning" onClick={deleteAllScans}>
                🧹 Clear All
              </button>
            </div>
          )}
        </div>

        {/* Points */}
        <div
          className="mt-4 p-3 rounded text-center"
          style={{ ...glassStyle, position: "relative" }}
        >
          <h4 className="fw-bold">⭐ Total Points: {points}</h4>
          {showPointsAnimation && (
            <div className="text-success fw-bold fs-4 animate__animated animate__fadeInUp">
              +10 Points!
            </div>
          )}
        </div>
      </div>
    </Layout>
  );
};

const glassStyle = {
  background: "rgba(255, 255, 255, 0.1)",
  borderRadius: "12px",
  border: "1px solid rgba(255, 255, 255, 0.2)",
  boxShadow: "0 4px 30px rgba(0, 0, 0, 0.3)",
  backdropFilter: "blur(8px)",
};

export default QRScanner;
