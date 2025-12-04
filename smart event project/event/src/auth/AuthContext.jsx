import React, { createContext, useEffect, useState } from "react";
import axios from "../api/axios";

export const AuthContext = createContext();

export function AuthProvider({ children }) {
  const [user, setUser] = useState(() => {
    try {
      return JSON.parse(localStorage.getItem("user"));
    } catch {
      return null;
    }
  });

  const [token, setToken] = useState(() => localStorage.getItem("token"));

  // ✅ Automatically inject token into all axios requests
  useEffect(() => {
    if (token) {
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
    } else {
      delete axios.defaults.headers.common["Authorization"];
    }
  }, [token]);

  
  const login = async (email, password) => {
    const res = await axios.post("/auth/login", { email, password });
    const { token: tkn, user: u } = res.data;

    localStorage.setItem("token", tkn);
    localStorage.setItem("user", JSON.stringify(u));
    setToken(tkn);
    setUser(u);

    return u;
  };

  // ✅ Register (optional auto-login)
  const register = async (payload) => {
    const res = await axios.post("/auth/register", payload);
    return res.data;
  };

  // ✅ Logout and clear session
  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    setToken(null);
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, token, login, logout, register }}>
      {children}
    </AuthContext.Provider>
  );
}