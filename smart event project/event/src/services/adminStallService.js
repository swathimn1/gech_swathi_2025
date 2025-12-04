// src/services/adminStallService.js
import axios from "axios";

// Helper function to include JWT token in headers
const getAuthConfig = () => {
  const token = localStorage.getItem("token");
  return {
    headers: {
      Authorization: `Bearer ${token}`,
      "Content-Type": "application/json",
    },
  };
};

// Base API URL from environment (e.g., VITE_API_BASE_URL = http://localhost:8080/api)
const API_BASE_URL = `${import.meta.env.VITE_API_BASE_URL}/stalls`;

export const adminStallService = {
  // ✅ Get all stalls
  getAll: () => axios.get(API_BASE_URL, getAuthConfig()),

  // ✅ Get stalls by owner (for stall owner view)
  getByOwner: (ownerId) =>
    axios.get(`${API_BASE_URL}/owner/${ownerId}`, getAuthConfig()),

  // ✅ Get stalls by event (for admin or event view)
  getByEvent: (eventId) =>
    axios.get(`${API_BASE_URL}/event/${eventId}`, getAuthConfig()),

  // ✅ Create a new stall
  create: (stall) => axios.post(API_BASE_URL, stall, getAuthConfig()),

  // ✅ Update an existing stall
  update: (id, stall) =>
    axios.put(`${API_BASE_URL}/${id}`, stall, getAuthConfig()),

  // ✅ Delete a stall
  delete: (id) => axios.delete(`${API_BASE_URL}/${id}`, getAuthConfig()),

  // (Optional future endpoints)
  getFeedback: (stallId) =>
    axios.get(`${API_BASE_URL}/feedback/${stallId}`, getAuthConfig()),

  getQueries: (stallId) =>
    axios.get(`${API_BASE_URL}/queries/${stallId}`, getAuthConfig()),

  replyToQuery: (queryId, responseText) =>
    axios.post(
      `${API_BASE_URL}/queries/${queryId}/reply`,
      { response: responseText },
      getAuthConfig()
    ),
};
