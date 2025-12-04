// src/services/authService.js
import { API_BASE_URL, API_ENDPOINTS } from "../config/api";

export const authService = {
  async login(email, password) {
    const response = await fetch(
      `${API_BASE_URL}${API_ENDPOINTS.AUTH.LOGIN}`,
      {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }),
      }
    );

    const text = await response.text();
    let data = {};

    try {
      data = text ? JSON.parse(text) : {};
    } catch {}

    if (!response.ok) throw new Error(data.message || "Login failed");

    return data; // { token, user }
  },
};
