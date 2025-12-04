import axios from 'axios';

// Read JWT token
const getAuthConfig = () => {
  const token = localStorage.getItem('token');
  return {
    headers: {
      Authorization: `Bearer ${token}`,
      'Content-Type': 'application/json'
    }
  };
};

// Base URL → example: http://localhost:8080/api/events
const API_BASE_URL = `${import.meta.env.VITE_API_BASE_URL}/events`;

// CLEAN allowed event fields only
const cleanEvent = (event) => ({
  title: event.title,
  description: event.description,
  location: event.location,
  startDate: event.startDate,
  endDate: event.endDate,
});

export const adminEventService = {
  getAll: () => axios.get(API_BASE_URL, getAuthConfig()),

  getById: (id) => axios.get(`${API_BASE_URL}/${id}`, getAuthConfig()),

  create: (event) =>
    axios.post(API_BASE_URL, cleanEvent(event), getAuthConfig()),

  update: (id, event) =>
    axios.put(`${API_BASE_URL}/${id}`, cleanEvent(event), getAuthConfig()),

  delete: (id) =>
    axios.delete(`${API_BASE_URL}/${id}`, getAuthConfig()),
};
