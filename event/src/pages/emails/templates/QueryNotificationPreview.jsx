import React from "react";

export default function QueryNotificationPreview() {
  return (
    <div className="p-6">
      <h1 className="text-xl font-bold mb-4">New Query Notification Email Preview</h1>

      <div className="border p-6 rounded bg-white shadow">
        <h2 className="text-lg font-semibold">New Query Received</h2>
        <p>Hello {{ownerName}},</p>
        <p>You have received a new query from visitor <strong>{{visitorName}}</strong>.</p>
        <p>Please check your dashboard to respond.</p>
      </div>
    </div>
  );
}
