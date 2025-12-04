package com.example.smartevent.payload;

import com.example.smartevent.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String role;
    private User user;
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
	public User getUser() {
		return user;
	}
	public AuthResponse(String token, String role, User user) {
		super();
		this.token = token;
		this.role = role;
		this.user = user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public AuthResponse() {
		super();
	}
}
