package com.example.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.registration.models.User;
import com.example.registration.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; 

    // Convert DTO to Entity
    private User convertToEntity(User user2) {
        User user = new User();
        user.setName(user2.getName());
        user.setAge(user2.getAge());
        user.setEmail(user2.getEmail());
        user.setPhone(user2.getPhone());
        user.setPassword(passwordEncoder.encode(user2.getPassword())); // Encrypt password
        user.setDob(user2.getDob());
        user.setCity(user2.getCity());
        user.setGender(user2.getGender());
        user.setSkills(user2.getSkills());
        user.setAddress(user2.getAddress());
        return user;
    }

    // Save user
    public User saveUser(User user2) {
        if (userRepository.existsByEmail(user2.getEmail())) {
            throw new IllegalArgumentException("Email is already registered!");
        }
        if (userRepository.existsByPhone(user2.getPhone())) {
            throw new IllegalArgumentException("Phone number is already registered!");
        }
        User user = convertToEntity(user2);
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User with ID " + id + " not found.");
        }
        userRepository.deleteById(id);
    }
}