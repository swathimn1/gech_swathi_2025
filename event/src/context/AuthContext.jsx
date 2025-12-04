import { createContext, useContext, useState, useEffect } from "react";
import { authService } from "../services/authService";

const AuthContext = createContext(null);
export const useAuth = () => useContext(AuthContext);

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  // Restore login status on refresh
  useEffect(() => {
    const token = localStorage.getItem("token");
    const storedUser = localStorage.getItem("user");

    if (token && storedUser) {
      const parsedUser = JSON.parse(storedUser);

      const role = parsedUser.role
        ?.toUpperCase()
        .replace("ROLE_", "");

      setUser({ ...parsedUser, role });
    }

    setLoading(false);
  }, []);

  // LOGIN
  const login = async (email, password) => {
    const data = await authService.login(email, password);

    const userRole = data.user.role
      ?.toUpperCase()
      .replace("Role_", "")
      .replace("ROLE_", "");

    const normalizedUser = { ...data.user, role: userRole };

    localStorage.setItem("token", data.token);
    localStorage.setItem("user", JSON.stringify(normalizedUser));

    setUser(normalizedUser);

    return { token: data.token, user: normalizedUser };
  };

  // LOGOUT
  const logout = () => {
    localStorage.clear();
    setUser(null);
  };

  return (
    <AuthContext.Provider
      value={{
        user,
        loading,
        login,
        logout,
        isAuthenticated: !!user,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};
