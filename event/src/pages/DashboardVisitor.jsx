import React, { useEffect, useState } from "react";
import axios from "../api/axios";

export default function DashboardVisitor() {
  const [profile, setProfile] = useState(null);

  useEffect(() => {
    axios.get("/visitors/me")
      .then(res => setProfile(res.data))
      .catch(() => {});
  }, []);

  return (
    <div className="max-w-6xl mx-auto p-6">
      <h1 className="text-2xl font-bold mb-4">My Dashboard</h1>
      {!profile ? <div>Loading...</div> : (
        <div className="bg-white p-4 rounded shadow">
          <p className="text-sm text-gray-600">Points</p>
          <div className="text-3xl font-semibold">{profile.totalPoints || 0}</div>
          <p className="mt-3 text-gray-700">Scans: {profile.totalScans || 0}</p>
        </div>
      )}
    </div>
  );
}
