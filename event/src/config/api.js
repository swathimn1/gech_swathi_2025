// -------------------------------------
// 🌐 API Base URL
// -------------------------------------
export const API_BASE_URL =
  import.meta.env.VITE_API_BASE_URL || "http://localhost:8080/api";

export const API_ENDPOINTS = {
  // -------------------------------------
  // 🔐 Auth Endpoints
  // -------------------------------------
  AUTH: {
    LOGIN: "/auth/login",
    SIGNUP: "/auth/register",
    REFRESH: "/auth/refresh",
    LOGOUT: "/auth/logout",
  },

  // -------------------------------------
  // 🛠 Admin Endpoints
  // -------------------------------------
  ADMIN: {
    EVENTS: "/admin/events",
    STALLS: "/admin/stalls",
    USERS: "/admin/users",
    ANALYTICS: "/admin/analytics",

    APPROVE_STALL: "/admin/stalls/approve",

    QR_ALL: "/admin/qr",
    QR_BY_USER: (userId) => `/admin/qr/user/${userId}`,
    QR_USER_POINTS: (userId) => `/admin/qr/user/${userId}/points`,
    QR_DELETE: (id) => `/admin/qr/${id}`,
    QR_DELETE_ALL_USER: (userId) => `/admin/qr/user/${userId}/all`,

    QUERIES: "/admin/queries",
  },

  // -------------------------------------
  // 🧑‍🍳 Stall Owner Endpoints
  // -------------------------------------
  STALL_OWNER: {
    STALLS: "/stall-owner/stalls",
    UPLOADRESULTS: "/stall-owner/upload-results",
    ATTENDANCE: "/stall-owner/attendance",
    NOTIFICATIONS: "/stall-owner/notifications",
  },

  // -------------------------------------
  // 👤 Visitor Endpoints
  // -------------------------------------
  VISITOR: {
    EVENTS: "/visitor/events",
    STALLS: "/visitor/stalls",

    FEEDBACK: "/visitor/feedback",
    FEEDBACK_BY_ID: (id) => `/visitor/feedback/${id}`,
    FEEDBACK_BY_USER: (userId) => `/visitor/feedback/user/${userId}`,

    SCAN: "/visitor/scan",
    SCAN_POINTS: "/visitor/scan/points",
    SCAN_DELETE_ALL: "/visitor/scan/all",

    CREATE_QUERY: "/visitor/queries",
    QUERIES_BY_USER: (userId) => `/visitor/queries/user/${userId}`,
    UPDATE_QUERY: (id) => `/visitor/queries/${id}`,
    DELETE_QUERY: (id) => `/visitor/queries/${id}`,
  },
};

// -------------------------------------
// 🔐 Auto Authorization Header
// -------------------------------------
export const getAuthHeader = () => {
  const token = localStorage.getItem("token");
  return token ? { Authorization: `Bearer ${token}` } : {};
};
