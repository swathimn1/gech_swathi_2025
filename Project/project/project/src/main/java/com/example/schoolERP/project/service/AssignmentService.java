// src/main/java/com/yourpackage/service/AssignmentService.java
package com.example.schoolERP.project.service;

import com.example.schoolERP.project.model.Assignment;
import com.example.schoolERP.project.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Assignment getAssignmentById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }

    public List<Assignment> getAssignmentsByFacultyId(Long facultyId) {
        return assignmentRepository.findByFacultyId(facultyId);
    }
}
