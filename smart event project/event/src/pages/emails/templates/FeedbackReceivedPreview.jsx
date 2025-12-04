import React from "react";

export default function FeedbackReceivedPreview() {
  return (
    <div className="p-6">
      <h1 className="text-xl font-bold mb-4">Feedback Received Email Preview</h1>

      <div className="border p-6 rounded bg-white shadow">
        <h2 className="text-lg font-semibold">New Feedback Received</h2>
        <p>Hello {{ownerName}},</p>
        <p>Your stall has received new feedback.</p>
        <p>Check the dashboard to view details!</p>
      </div>
    </div>
  );
}
