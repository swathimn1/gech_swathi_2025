import React from "react";

export default function WelcomeVisitorPreview() {
  return (
    <div className="p-6">
      <h1 className="text-xl font-bold mb-4">Welcome Visitor Email Preview</h1>

      <div className="border p-6 rounded bg-white shadow">
        <h2 className="text-lg font-semibold">Welcome to Smart Event!</h2>
        <p>Hello {{name}},</p>
        <p>Thank you for registering as a visitor. Enjoy exploring stalls and earning points!</p>
        <p>Best Regards,<br/>Smart Event Team</p>
      </div>
    </div>
  );
}
