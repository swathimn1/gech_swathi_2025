import React, { useEffect, useState } from "react";
import Layout from "../../components/Layout";
import { adminService } from "../../services/adminService";

export default function QueriesPage() {
  const [queries, setQueries] = useState([]);
  const [loading, setLoading] = useState(false);

  // Load all queries for admin
  const loadQueries = async () => {
    setLoading(true);
    try {
      const res = await adminService.getQueries(); // GET /api/admin/queries
      setQueries(res.data || []); // backend now returns AdminQueryResponse[]
    } catch (err) {
      console.error("Error loading queries:", err);
      alert("Failed to load queries");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    loadQueries();
  }, []);

  // Send reply for a query
  const replyToQuery = async (queryId) => {
    const replyText = window.prompt("Enter your reply:");
    if (!replyText) return;

    try {
      await adminService.replyQuery(queryId, replyText); // POST /api/admin/queries/{id}/reply
      alert("Reply sent successfully");
      // Update local state instead of reloading all queries
      setQueries(prev =>
        prev.map(q => (q.id === queryId ? { ...q, reply: replyText } : q))
      );
    } catch (err) {
      console.error("Reply failed:", err);
      alert("Failed to send reply");
    }
  };

  return (
    <Layout title="Admin | Visitor Queries">
      <div className="p-6">
        <h2 className="text-2xl font-bold mb-4">Visitor Queries</h2>

        {loading ? (
          <div>Loading...</div>
        ) : queries.length === 0 ? (
          <div>No queries found</div>
        ) : (
          <ul className="space-y-4">
            {queries.map((q) => (
              <li
                key={q.id}
                className="p-4 bg-white rounded shadow border border-gray-200"
              >
                {/* Visitor → Stall */}
                <div className="font-semibold">
                  {q.visitorName} →{" "}
                  <span className="text-blue-600">{q.stallName}</span>
                </div>

                {/* Query message */}
                <div className="text-gray-700 mt-1">{q.message}</div>

                {/* Admin reply */}
                {q.reply && (
                  <div className="mt-2 p-2 bg-green-50 border-l-4 border-green-600">
                    <strong>Admin Reply:</strong> {q.reply}
                  </div>
                )}

                {/* Reply button */}
                {!q.reply && (
                  <button
                    className="mt-3 px-3 py-1 bg-green-600 text-white rounded hover:bg-green-700"
                    onClick={() => replyToQuery(q.id)}
                  >
                    Reply
                  </button>
                )}
              </li>
            ))}
          </ul>
        )}
      </div>
    </Layout>
  );
}
