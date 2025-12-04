import React, { useEffect, useState, useContext } from "react";
import axios from "../api/axios";
import { useParams } from "react-router-dom";
import QRScanner from "../components/QRScanner";
import FeedbackForm from "../components/FeedbackForm";
import { toast } from "react-toastify";
import { AuthContext } from "../auth/AuthContext";

export default function StallDetail() {
  const { id } = useParams();
  const { user } = useContext(AuthContext);
  const [stall, setStall] = useState(null);
  const [showScanner, setShowScanner] = useState(false);
  const [loading, setLoading] = useState(true);
  const [queries, setQueries] = useState([]);

  useEffect(() => {
    let mounted = true;
    axios.get(`/stalls/${id}`)
      .then((res) => { if (mounted) setStall(res.data); })
      .catch(() => {})
      .finally(() => { if (mounted) setLoading(false); });

    axios.get(`/stalls/${id}/queries`)
      .then((res) => { if (mounted) setQueries(res.data || []); })
      .catch(() => {});
    return () => (mounted = false);
  }, [id]);

  const handleScanResult = async (text) => {
    // Expect QR payload as JSON, e.g. { "stallId": "...", "eventId": "...", "signature": "..." }
    if (!user) {
      toast.error("Please login to scan and earn points.");
      setShowScanner(false);
      return;
    }
    try {
      const qr = JSON.parse(text);
      // Optionally verify stall id matches current page
      await axios.post("/scan", qr);
      toast.success("Points awarded!");
      setShowScanner(false);
    } catch (err) {
      console.error(err);
      toast.error(err?.response?.data?.message || "Invalid or duplicate scan");
    }
  };

  if (loading) return <div className="p-6">Loading...</div>;
  if (!stall) return <div className="p-6">Stall not found</div>;

  return (
    <div className="max-w-4xl mx-auto p-6">
      <div className="bg-white p-6 rounded shadow">
        <div className="flex gap-6">
          <div className="w-2/5">
            {stall.imageUrl ? (
              <img src={stall.imageUrl} alt={stall.name} className="w-full rounded" />
            ) : (
              <div className="h-48 bg-gray-100 flex items-center justify-center rounded">No image</div>
            )}
          </div>
          <div className="flex-1">
            <h2 className="text-2xl font-bold">{stall.name}</h2>
            <p className="text-gray-600 mt-2">{stall.description}</p>
            <p className="mt-2 text-sm">Points per visit: <strong>{stall.pointsForVisit ?? 0}</strong></p>

            <div className="mt-4">
              <button
                className="bg-green-600 text-white px-4 py-2 rounded mr-2"
                onClick={() => setShowScanner((s) => !s)}
              >
                {showScanner ? "Close Scanner" : "Scan QR to Earn Points"}
              </button>

              {stall.qrCodeUrl && (
                <a
                  href={stall.qrCodeUrl}
                  target="_blank"
                  rel="noreferrer"
                  className="ml-2 inline-block text-sky-600 underline"
                >
                  Download QR
                </a>
              )}
            </div>
          </div>
        </div>

        {showScanner && (
          <div className="mt-6">
            <QRScanner
              onResult={handleScanResult}
              onError={(err) => { console.error(err); toast.error("Camera error or permission denied"); }}
            />
          </div>
        )}

        <FeedbackForm stallId={stall.id} eventId={stall.eventId} onSubmitted={() => {}} />

        <div className="mt-6">
          <h3 className="font-semibold">Queries</h3>
          {queries.length === 0 ? (
            <p className="text-sm text-gray-600">No queries yet.</p>
          ) : (
            <div className="mt-2 space-y-2">
              {queries.map((q) => (
                <div key={q.id} className="border p-3 rounded">
                  <div className="text-sm text-gray-700"><strong>{q.visitorName}</strong> asked:</div>
                  <div className="mt-1 text-gray-800">{q.questionText}</div>
                  <div className="mt-2 text-sm text-gray-500">Status: {q.status}</div>
                  {q.ownerResponseText && (
                    <div className="mt-2 p-2 bg-gray-50 text-sm rounded">Owner: {q.ownerResponseText}</div>
                  )}
                </div>
              ))}
            </div>
          )}
        </div>

      </div>
    </div>
  );
}
