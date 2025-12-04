import React from "react";
import { Link } from "react-router-dom";

export default function StallCard({ stall }) {
  return (
    <div className="bg-white border rounded shadow-sm p-4 flex flex-col">
      <div className="h-40 w-full bg-gray-100 flex items-center justify-center overflow-hidden rounded">
        {stall.imageUrl ? (
          <img src={stall.imageUrl} alt={stall.name} className="object-cover w-full h-full" />
        ) : (
          <div className="text-gray-400">No image</div>
        )}
      </div>
      <h3 className="mt-3 font-semibold text-lg">{stall.name}</h3>
      <p className="text-sm text-gray-600 line-clamp-3 mt-1">{stall.description}</p>
      <div className="mt-auto flex items-center justify-between">
        <span className="text-sm text-gray-700">Points: {stall.pointsForVisit ?? 0}</span>
        <Link to={`/stalls/${stall.id}`} className="text-sky-600 text-sm">Open</Link>
      </div>
    </div>
  );
}
