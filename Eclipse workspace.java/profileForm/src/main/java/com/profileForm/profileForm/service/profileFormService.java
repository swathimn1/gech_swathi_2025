package com.profileForm.profileForm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.profileForm.profileForm.models.profileForm;
import com.profileForm.profileForm.repository.profileFormRepository;

@Service
public class profileFormService {

    @Autowired
    private profileFormRepository repository;

    // Save a profile
    public void saveProfile(profileForm profile) {
        repository.save(profile);
    }

    // Get all profiles
    public List<profileForm> getAllProfiles() {
        return repository.findAll();
    }

    // Delete a profile by ID
    public void deleteProfile(Long id) {
        repository.deleteById(id);
    }
}
