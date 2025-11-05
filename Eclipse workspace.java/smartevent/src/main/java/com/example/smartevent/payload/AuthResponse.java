package com.example.smartevent.payload;

public class AuthResponse {
    private String token;
    private String role;

    // ✅ Constructors
    public AuthResponse() {}

    public AuthResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

    // ✅ Getters and Setters
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
