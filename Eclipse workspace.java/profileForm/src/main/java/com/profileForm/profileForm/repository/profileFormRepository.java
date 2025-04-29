package com.profileForm.profileForm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profileForm.profileForm.models.profileForm;

public interface profileFormRepository extends JpaRepository<profileForm, Long> {

    // Example custom query method (optional)
    profileForm findByName(String name);
}
