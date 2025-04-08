package com.registration.service;

import com.registration.dto.DTO;
import com.registration.model.Registration;
import com.registration.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    // Constructor Injection
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    // Fetch all registrations
    public List<Registration> getAllRegistration() {
        return registrationRepository.findAll();
    }

    // Register a new user
    public Registration register(DTO dto) {
        Registration registration = convertDtoToEntity(dto);
        return registrationRepository.save(registration);
    }

    // Fetch registration by ID
    public Registration getRegistrationById(long id) {
        return registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // Update existing registration
    public void updateRegistration(long id, Registration updatedUser) {
        Registration existingUser = getRegistrationById(id);
        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setAge(updatedUser.getAge());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setCity(updatedUser.getCity());
            existingUser.setDob(updatedUser.getDob());
            existingUser.setGender(updatedUser.getGender());
            existingUser.setPhone(updatedUser.getPhone());
            existingUser.setSkill(updatedUser.getSkill());
            registrationRepository.save(existingUser);
        }
    }

    // Delete registration (Void Return Type)
    public void deleteRegistration(long id) {
        Registration user = getRegistrationById(id);
        if (user != null) {
            registrationRepository.delete(user);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

    // Convert DTO to Entity
    private Registration convertDtoToEntity(DTO dto) {
        Registration registration = new Registration();
        registration.setName(dto.getName());
        registration.setEmail(dto.getEmail());
        registration.setPhone(dto.getPhone());
        registration.setAge(dto.getAge());
        registration.setDob(dto.getDob());
        registration.setCity(dto.getCity());
        registration.setGender(dto.getGender());
        registration.setSkill(dto.getSkill());
        registration.setAddress(dto.getAddress());
        return registration;
    }
}

