package com.example.schoolERP.project.repository;

import com.example.schoolERP.project.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    // Optional: Get all assignments by a specific faculty
    List<Assignment> findByFacultyId(Long facultyId);
}
