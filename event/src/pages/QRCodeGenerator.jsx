import { useEffect, useState } from "react";
import axios from "axios";
import { QrCode, Download } from "lucide-react";
import { Link } from "react-router-dom";

const QRCodeGenerator = () => {
  const [users, setUsers] = useState([]);
  const [selectedUser, setSelectedUser] = useState("");
  const [qrImage, setQrImage] = useState(null);

  useEffect(() => {
    axios.get("http://localhost:8080/api/auth/users").then((res) => setUsers(res.data));
  }, []);

  const handleGenerate = async () => {
    if (!selectedUser) return alert("Please select a user first!");
    const res = await axios.get(`http://localhost:8080/api/checkin/qrcode/${selectedUser}`, {
      responseType: "arraybuffer",
    });
    const base64 = btoa(
      new Uint8Array(res.data).reduce((data, byte) => data + String.fromCharCode(byte), "")
    );
    setQrImage(`data:image/png;base64,${base64}`);
  };

  return (
    <div
      className="min-vh-100 d-flex flex-column align-items-center justify-content-center"
      style={{
        background: "linear-gradient(135deg, #ff9966, #ff5e62)",
        color: "white",
      }}
    >
      <div className="container text-center p-5">
        <h2 className="fw-bold mb-4">
          <QrCode size={28} className="me-2" /> Smart Event QR Generator
        </h2>

        <select
          className="form-select w-50 mx-auto mb-3"
          onChange={(e) => setSelectedUser(e.target.value)}
        >
          <option value="">-- Select User --</option>
          {users.map((u) => (
            <option key={u.id} value={u.id}>
              {u.username} ({u.email})
            </option>
          ))}
        </select>

        <button onClick={handleGenerate} className="btn btn-light fw-bold">
          Generate QR Code
        </button>

        {qrImage && (
          <div className="mt-4">
            <img src={qrImage} alt="QR Code" width="200" height="200" className="border bg-white p-2 rounded" />
            <a href={qrImage} download={`user-${selectedUser}.png`} className="btn btn-success mt-3">
              <Download className="me-2" size={16} /> Download QR
            </a>
          </div>
        )}

        <Link to="/" className="btn btn-outline-light mt-4">
          ← Back to Home
        </Link>
      </div>
    </div>
  );
};

export default QRCodeGenerator;
