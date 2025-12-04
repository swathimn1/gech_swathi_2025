import React, { useEffect, useState } from "react";
import axios from "../api/axios";

export default function DashboardAdmin() {
  const [stats, setStats] = useState(null);

  useEffect(() => {
    axios.get("/admin/analytics")
      .then(res => setStats(res.data))
      .catch(() => {});
  }, []);

  return (
    <div className="max-w-6xl mx-auto p-6">
      <h1 className="text-2xl font-bold mb-4">Admin Dashboard</h1>
      {!stats ? (
        <div>Loading analytics...</div>
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
          <div className="bg-white p-4 rounded shadow">
            <h3 className="text-sm text-gray-600">Total Events</h3>
            <div className="text-2xl font-semibold">{stats.totalEvents}</div>
          </div>
          <div className="bg-white p-4 rounded shadow">
            <h3 className="text-sm text-gray-600">Total Visitors</h3>
            <div className="text-2xl font-semibold">{stats.totalVisitors}</div>
          </div>
          <div className="bg-white p-4 rounded shadow">
            <h3 className="text-sm text-gray-600">Points Distributed</h3>
            <div className="text-2xl font-semibold">{stats.pointsDistributed}</div>
          </div>
        </div>
      )}
    </div>
  );
}
