import React from "react";
import { Link } from "react-router-dom";

export default function EmailPreviewList() {
  const templates = [
    { name: "Welcome Visitor Email", path: "/email-preview/welcome-visitor" },
    { name: "Stall Approved Email", path: "/email-preview/stall-approved" },
    { name: "New Query Notification", path: "/email-preview/query-notification" },
    { name: "Feedback Received Email", path: "/email-preview/feedback-received" },
  ];

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-4">Email Templates Preview</h1>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        {templates.map((t) => (
          <Link key={t.path} to={t.path}>
            <div className="border p-4 rounded-lg bg-gray-50 shadow hover:bg-gray-100 cursor-pointer">
              <h2 className="font-semibold">{t.name}</h2>
              <p className="text-sm text-gray-600">Click to preview</p>
            </div>
          </Link>
        ))}
      </div>
    </div>
  );
}
