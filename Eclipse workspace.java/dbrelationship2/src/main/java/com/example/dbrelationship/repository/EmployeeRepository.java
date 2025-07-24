package com.example.dbrelationship.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dbrelationship.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
//	 @EntityGraph(attributePaths = {"department", "roles", "address", "tasks"})
	Optional<Employee> findByEmail(String email);
//	 @EntityGraph(attributePaths = {"department", "roles", "address", "tasks"})
	 Optional<Employee> findById(Long id);



}
