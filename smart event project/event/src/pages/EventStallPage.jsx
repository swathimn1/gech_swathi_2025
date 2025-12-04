import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "../api/axios";

const EventStallsPage = () => {
  const { id } = useParams(); // event ID from URL
  const [stalls, setStalls] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios.get(`/stalls/event/${id}`)
      .then((res) => setStalls(res.data || []))
      .catch(() => {})
      .finally(() => setLoading(false));
  }, [id]);

  return (
    <div className="min-h-screen bg-gray-50 p-6">
      <h1 className="text-2xl font-bold mb-4">Stalls for Event #{id}</h1>
      {loading ? (
        <p>Loading stalls...</p>
      ) : stalls.length === 0 ? (
        <p>No stalls found for this event.</p>
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
          {stalls.map((stall) => (
            <div key={stall.id} className="bg-white p-4 rounded shadow">
              <h2 className="font-semibold text-lg">{stall.name}</h2>
              <p className="text-sm text-gray-600">{stall.category}</p>
              <p className="text-sm mt-2">{stall.description}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default EventStallsPage;