package com.example.smartevent.controller;

import com.example.smartevent.models.User;
import com.example.smartevent.payload.AuthRequest;
import com.example.smartevent.payload.AuthResponse;
import com.example.smartevent.security.JwtUtil;
import com.example.smartevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ Register a new user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            final String jwt = jwtUtil.generateToken(user.getEmail(), user.getRole().name());


            // Return full AuthResponse object
            AuthResponse response = new AuthResponse(jwt, savedUser.getRole().name(), savedUser);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Always return JSON for errors
            return ResponseEntity.badRequest().body(Map.of("message", "Registration failed: " + e.getMessage()));
        }
    }

    // ✅ Login existing user
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            User user = userService.authenticateUser(authRequest.getEmail(), authRequest.getPassword());
            final String jwt = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
            AuthResponse response = new AuthResponse(jwt, user.getRole().name(), user);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("message", "Login failed: " + e.getMessage()));
        }
    }


}
