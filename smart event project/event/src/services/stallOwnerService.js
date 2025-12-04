// src/services/stallOwnerService.js
import { apiService } from './apiService';
import { API_ENDPOINTS } from '../config/api';

export const stallOwnerService = {
  async getMyStalls(ownerId) {
    return apiService.get(`${API_ENDPOINTS.STALL_OWNER.STALLS}/owner/${ownerId}`);
  },

  async createStall(stallData) {
    return apiService.post(API_ENDPOINTS.STALL_OWNER.STALLS, stallData);
  },

  async updateStall(id, stallData) {
    return apiService.put(`${API_ENDPOINTS.STALL_OWNER.STALLS}/${id}`, stallData);
  },

  async deleteStall(id) {
    return apiService.delete(`${API_ENDPOINTS.STALL_OWNER.STALLS}/${id}`);
  },

  async generateQRCode(stallId) {
    return apiService.get(`${API_ENDPOINTS.STALL_OWNER.QR_CODE}/${stallId}`);
  },

  async getQueries(stallId) {
    return apiService.get(`${API_ENDPOINTS.STALL_OWNER.QUERIES}/${stallId}`);
  },

  async respondToQuery(queryId, response) {
    return apiService.post(`${API_ENDPOINTS.STALL_OWNER.QUERIES}/${queryId}/respond`, { response });
  },

  async getFeedback(stallId) {
    return apiService.get(`${API_ENDPOINTS.STALL_OWNER.FEEDBACK}/${stallId}`);
  },

  async getStallAnalytics(stallId) {
    return apiService.get(`${API_ENDPOINTS.STALL_OWNER.ANALYTICS}/${stallId}`);
  },
};
