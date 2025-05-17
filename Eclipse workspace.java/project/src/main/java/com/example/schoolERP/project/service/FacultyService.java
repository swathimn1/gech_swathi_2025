package com.example.schoolERP.project.service;
import com.example.schoolERP.project.model.Faculty;
import com.example.schoolERP.project.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    // Get all faculty members
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    // Get faculty by ID
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    // Save a new faculty or update an existing faculty
    public void saveFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    // Delete faculty by ID
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
