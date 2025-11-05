package com.example.smartevent.service;

import com.example.smartevent.models.Role;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	

	// ✅ Register a new user
    public User registerUser(User userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("Email already registered!");
        }

        // Default role if not provided
        String roleName = (userRequest.getRole() == null || userRequest.getRole().isEmpty())
                ? "VISITOR"
                : userRequest.getRole().toUpperCase();

        User user = User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(Role.valueOf(roleName))
                .build();

        return userRepository.save(user);
    }

    // ✅ Find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    // ✅ Get all users (Admin only)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ Get user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // ✅ Delete user by ID
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }

    // ✅ Update user role
    public User updateUserRole(Long id, String role) {
        User user = getUserById(id);
        try {
            user.setRole(Role.valueOf(role.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role: " + role + ". Allowed values: ADMIN, OWNER, VISITOR");
        }
        return userRepository.save(user);
    }

    // ✅ Update password (optional)
    public void updatePassword(Long id, String newPassword) {
        User user = getUserById(id);
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}
