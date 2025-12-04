import { apiService } from "./apiService";
import { API_ENDPOINTS } from "../config/api";

const withAuth = () => ({
  headers: {
    Authorization: `Bearer ${localStorage.getItem("token")}`,
  },
});

export const adminService = {
  // 🌱 Events
  getEvents() {
    return apiService.get(API_ENDPOINTS.ADMIN.EVENTS, withAuth());
  },
  createEvent(eventData) {
    return apiService.post(API_ENDPOINTS.ADMIN.EVENTS, eventData, withAuth());
  },
  updateEvent(id, eventData) {
    return apiService.put(
      `${API_ENDPOINTS.ADMIN.EVENTS}/${id}`,
      eventData,
      withAuth()
    );
  },
  deleteEvent(id) {
    return apiService.delete(`${API_ENDPOINTS.ADMIN.EVENTS}/${id}`, withAuth());
  },

  // 🏠 Stalls
  getAllStalls() {
    return apiService.get(API_ENDPOINTS.ADMIN.STALLS, withAuth());
  },
  approveStall(stallId) {
    return apiService.post(
      `${API_ENDPOINTS.ADMIN.APPROVE_STALL}/${stallId}`,
      null,
      withAuth()
    );
  },
  deleteStall(id) {
    return apiService.delete(`${API_ENDPOINTS.ADMIN.STALLS}/${id}`, withAuth());
  },

  // 👥 Users
  getAllUsers() {
    return apiService.get(API_ENDPOINTS.ADMIN.USERS, withAuth());
  },
  createUser(userData) {
    return apiService.post(API_ENDPOINTS.ADMIN.USERS, userData, withAuth());
  },
  updateUser(id, userData) {
    return apiService.put(`${API_ENDPOINTS.ADMIN.USERS}/${id}`, userData, withAuth());
  },
  updateUserRole(id, role) {
    return apiService.put(
      `${API_ENDPOINTS.ADMIN.USERS}/${id}/role?role=${role}`,
      null,
      withAuth()
    );
  },
  deleteUser(id) {
    return apiService.delete(`${API_ENDPOINTS.ADMIN.USERS}/${id}`, withAuth());
  },

  // 📊 Analytics
  async getAnalytics() {
    const res = await apiService.get(API_ENDPOINTS.ADMIN.ANALYTICS, withAuth());
    return res.data;
  },
  getEventVisitors() {
    return apiService.get(API_ENDPOINTS.ADMIN.EVENT_VISITORS, withAuth());
  },
  getStallScans() {
    return apiService.get(API_ENDPOINTS.ADMIN.STALL_SCANS, withAuth());
  },
  getStallRatings() {
    return apiService.get(API_ENDPOINTS.ADMIN.STALL_RATINGS, withAuth());
  },

  // 📨 Queries
  getQueries() {
    return apiService.get(API_ENDPOINTS.ADMIN.QUERIES, withAuth());
  },
  replyQuery(id, replyText) {
    return apiService.post(
      `${API_ENDPOINTS.ADMIN.QUERIES}/${id}/reply`,
      { reply: replyText },
      withAuth()
    );
  },
};
