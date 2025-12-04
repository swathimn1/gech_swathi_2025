package com.example.smartevent.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignUpRequest {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Full name is required")
    private String fullName;

    private String phone;

    @NotBlank(message = "Role is required")
    private String role; // ADMIN, STALL_OWNER, VISITOR

    private Boolean active = true; // Optional, defaults to true

    private java.util.Date createdAt; // Optional, usually not sent from frontend

    private java.util.Date updatedAt; // Optional, usually not sent from frontend

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public java.util.Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.util.Date createdAt) {
        this.createdAt = createdAt;
    }

    public java.util.Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(java.util.Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Constructor with required fields
    public SignUpRequest(@NotBlank(message = "Username is required") @Size(min = 3, max = 50) String username,
                         @NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
                         @NotBlank(message = "Password is required") @Size(min = 6, message = "Password must be at least 6 characters") String password,
                         @NotBlank(message = "Full name is required") String fullName,
                         String phone,
                         @NotBlank(message = "Role is required") String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.role = role;
        this.active = true; // default on creation
        this.createdAt = null; // usually not set by client
        this.updatedAt = null; // usually not set by client
    }
}
