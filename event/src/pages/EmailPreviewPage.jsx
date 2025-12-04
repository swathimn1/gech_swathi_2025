import React, { useState, useEffect } from "react";
import axios from "axios";
import "./EmailPreview.css";
import { API_BASE_URL, getAuthHeader } from "../config/api";
import Layout from "../components/Layout";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";

export default function EmailPreviewPage() {
  const navigate = useNavigate();
  const { user } = useAuth();
  const [templates, setTemplates] = useState([]);
  const [loading, setLoading] = useState(true);
  const [selectedTemplate, setSelectedTemplate] = useState(null);
  const [placeholders, setPlaceholders] = useState({});
  const [previewHtml, setPreviewHtml] = useState("");
  const [testEmail, setTestEmail] = useState("");

  const handleBack = () => {
    if (!user || !user.role) {
      navigate("/login");
      return;
    }

    if (user.role === "ADMIN") navigate("/admin/dashboard");
    else if (user.role === "STALL_OWNER") navigate("/stall-owner/dashboard");
    else if (user.role === "VISITOR") navigate("/visitor/dashboard");
    else navigate("/login");
  };
  // Load templates from backend
  const loadTemplates = async () => {
    try {
      setLoading(true);
      const res = await axios.get(`${API_BASE_URL}/email/templates`, {
        headers: getAuthHeader(),
      });
      setTemplates(res.data);
    } catch (err) {
      console.error("Error loading templates", err);
      alert("Failed to load templates");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    loadTemplates();
  }, []);

  // Handle template selection
  const handleSelectTemplate = (template) => {
    setSelectedTemplate(template);

    if (!template.html) {
      setPlaceholders({});
      setPreviewHtml("<p>No HTML found.</p>");
      return;
    }

    // Extract placeholders from template HTML
    const regex = /{{(.*?)}}/g;
    const found = [...template.html.matchAll(regex)].map((m) => m[1]);

    const placeholderObj = {};
    found.forEach((key) => (placeholderObj[key] = ""));
    setPlaceholders(placeholderObj);

    updatePreview(template.html, placeholderObj);
  };

  // Update preview HTML
  const updatePreview = (html, data) => {
    if (!html) return;
    let updatedHtml = html.replace(
      /{{(.*?)}}/g,
      (match, key) => data[key] || ""
    );
    setPreviewHtml(updatedHtml);
  };

  // Handle placeholder value change
  const handlePlaceholderChange = (key, value) => {
    const updated = { ...placeholders, [key]: value };
    setPlaceholders(updated);
    updatePreview(selectedTemplate.html, updated);
  };

  // Add new placeholder manually
  const addPlaceholder = () => {
    const newKey = prompt("Enter placeholder name (without {{}}):");
    if (!newKey || placeholders[newKey]) return;
    const updated = { ...placeholders, [newKey]: "" };
    setPlaceholders(updated);
    updatePreview(selectedTemplate.html, updated);
  };

  // Remove a placeholder
  const removePlaceholder = (key) => {
    const updated = { ...placeholders };
    delete updated[key];
    setPlaceholders(updated);
    updatePreview(selectedTemplate.html, updated);
  };

  // Send test email
  const sendTestEmail = async () => {
    if (!testEmail.trim()) return alert("Enter email!");
    if (!selectedTemplate) return alert("Select a template!");

    try {
      const formattedPlaceholders = Object.keys(placeholders).map((key) => ({
        key,
        value: placeholders[key],
      }));

      await axios.post(
        `${API_BASE_URL}/email/send-test`,
        {
          to: testEmail,
          templateName: selectedTemplate.name,
          placeholders: formattedPlaceholders,
        },
        { headers: getAuthHeader() }
      );

      alert(" email sent successfully!");
    } catch (err) {
      console.error(err);
      alert("Error sending  email");
    }
  };

  return (
    <Layout title="Admin Dashboard | Smart Event System">
      <div className="mb-3">
        <button className="btn btn-secondary" onClick={handleBack}>
          ⬅ Back to Dashboard
        </button>
      </div>
      <div className="email-preview-container">
        {/* Sidebar */}
        <div className="sidebar">
          <div className="sidebar-header">
            <h3>Email Templates</h3>
            <button className="refresh-btn" onClick={loadTemplates}>
              ⟳
            </button>
          </div>

          {loading ? (
            <p>Loading templates...</p>
          ) : (
            templates.map((t) => (
              <div
                key={t.name}
                className={`template-item ${
                  selectedTemplate?.name === t.name ? "active" : ""
                }`}
                onClick={() => handleSelectTemplate(t)}
              >
                {t.displayName || t.name}
              </div>
            ))
          )}
        </div>

        {/* Preview Section */}
        <div className="preview-area">
          {!selectedTemplate ? (
            <p className="select-message">Select a template to preview</p>
          ) : (
            <>
              <h2>{selectedTemplate.displayName || selectedTemplate.name}</h2>

              {/* Placeholders Inputs */}
              <div className="input-section">
                {/* <h3>Replace Placeholders</h3> */}
                <button onClick={addPlaceholder}>+ Add Placeholder</button>

                {Object.keys(placeholders).length === 0 ? (
                  <p>No dynamic placeholders found.</p>
                ) : (
                  Object.keys(placeholders).map((key) => (
                    <div className="placeholder-row" key={key}>
                      <label>{key}:</label>
                      <input
                        type="text"
                        value={placeholders[key]}
                        onChange={(e) =>
                          handlePlaceholderChange(key, e.target.value)
                        }
                      />
                      <button onClick={() => removePlaceholder(key)}>✖</button>
                    </div>
                  ))
                )}
              </div>

              {/* HTML Preview Box */}
              <h3>Email Preview</h3>
              <div
                className="email-preview-box"
                dangerouslySetInnerHTML={{ __html: previewHtml }}
              />

              {/* Test Email */}
              <div className="send-test-section">
                <input
                  type="email"
                  placeholder="Enter  email address"
                  value={testEmail}
                  onChange={(e) => setTestEmail(e.target.value)}
                />
                <button onClick={sendTestEmail}>Send Email</button>
              </div>
            </>
          )}
        </div>
      </div>
    </Layout>
  );
}
