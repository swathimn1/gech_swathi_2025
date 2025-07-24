package com.example.dbrelationship.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dbrelationship.model.Department;

@Repository
public interface DepartmentsRepository extends JpaRepository<Department, Long> {
	Optional<Department> findByName(String name);
}
