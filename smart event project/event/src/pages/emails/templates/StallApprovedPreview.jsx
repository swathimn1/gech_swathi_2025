import React from "react";

export default function StallApprovedPreview() {
  return (
    <div className="p-6">
      <h1 className="text-xl font-bold mb-4">Stall Approved Email Preview</h1>

      <div className="border p-6 rounded bg-white shadow">
        <h2 className="text-lg font-semibold">Your Stall Has Been Approved!</h2>
        <p>Hello {{name}},</p>
        <p>Your stall <strong>{{stallName}}</strong> is now approved and live for visitors.</p>
        <p>Good luck with your business!</p>
      </div>
    </div>
  );
}
