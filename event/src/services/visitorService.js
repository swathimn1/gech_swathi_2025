import { apiService } from "./apiService";
import { API_ENDPOINTS } from "../config/api";

export const visitorService = {
  // ✅ Events - NOW USING ADMIN EVENTS ENDPOINT
  async getEvents() {
    // Changed from VISITOR.EVENTS to direct /events endpoint
    return apiService.get("/events");
  },

  async getEventById(id) {
    // Changed to use /events endpoint
    return apiService.get(`/events/${id}`);
  },

  // ✅ Stalls
  async getStallsByEvent(eventId) {
    return apiService.get(
      `${API_ENDPOINTS.VISITOR.STALLS}?eventId=${eventId}`
    );
  },

  async getStallById(id) {
    return apiService.get(`${API_ENDPOINTS.VISITOR.STALLS}/${id}`);
  },

  // ✅ QR Code Scanning
  async scanQRCode(content) {
    return apiService.post(API_ENDPOINTS.VISITOR.SCAN, { content });
  },

  // ✅ Feedback
  async submitFeedback(feedbackData) {
    return apiService.post(API_ENDPOINTS.VISITOR.FEEDBACK, feedbackData);
  },

  async getMyFeedback() {
    return apiService.get(API_ENDPOINTS.VISITOR.FEEDBACK);
  },

  // ✅ Queries
  async submitQuery(queryData) {
    return apiService.post(API_ENDPOINTS.VISITOR.CREATE_QUERY, queryData);
  },

  async getMyQueries(userId) {
    return apiService.get(API_ENDPOINTS.VISITOR.QUERIES_BY_USER(userId));
  },

  // ✅ Points
  async getMyPoints() {
    return apiService.get(API_ENDPOINTS.VISITOR.SCAN_POINTS);
  },
};