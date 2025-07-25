package com.example.schoolERP.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.schoolERP.project.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Optional<Faculty> findByUsername(String username);
    Optional<Faculty> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<Faculty> findByDepartment(String department);
}
