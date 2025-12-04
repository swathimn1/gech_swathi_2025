package com.example.smartevent.service;

import com.example.smartevent.dto.UserDTO;
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

    public User registerUser(User user) {
        // prevent duplicate email
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // default role
        if (user.getRole() == null) {
            user.setRole(Role.VISITOR);
        }

        return userRepository.save(user);
    }

    // ✅ Find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
            .map(UserDTO::new)
            .toList(); // or .collect(Collectors.toList()) if using Java 8
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
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        return userRepository.save(user);
    }

    public User updateUserRole(Long id, Role role) {
        User user = getUserById(id);
        user.setRole(role);
        return userRepository.save(user);
    }


    // ✅ Update password
    public void updatePassword(Long id, String newPassword) {
        User user = getUserById(id);
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User authenticateUser(String email, String rawPassword) {
        User user = findByEmail(email);
        if (!user.isActive()) {
            throw new RuntimeException("User is not active");
        }
        // Matches raw input password vs hashed password in DB
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return user; // Successful login!
    }


}