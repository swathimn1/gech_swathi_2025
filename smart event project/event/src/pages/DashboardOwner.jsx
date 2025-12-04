import React, { useEffect, useState } from "react";
import axios from "../api/axios";

export default function DashboardOwner() {
  const [data, setData] = useState(null);

  useEffect(() => {
    axios.get("/owner/dashboard")
      .then(res => setData(res.data))
      .catch(() => {});
  }, []);

  return (
    <div className="max-w-6xl mx-auto p-6">
      <h1 className="text-2xl font-bold mb-4">Stall Owner Dashboard</h1>
      {!data ? <div>Loading...</div> : (
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
          <div className="bg-white p-4 rounded shadow"><h4 className="text-sm">Your Stalls</h4><div className="text-xl font-semibold">{data.stallCount}</div></div>
          <div className="bg-white p-4 rounded shadow"><h4 className="text-sm">Total Scans</h4><div className="text-xl font-semibold">{data.totalScans}</div></div>
          <div className="bg-white p-4 rounded shadow"><h4 className="text-sm">Avg Rating</h4><div className="text-xl font-semibold">{data.avgRating || 0}</div></div>
        </div>
      )}
    </div>
  );
}
