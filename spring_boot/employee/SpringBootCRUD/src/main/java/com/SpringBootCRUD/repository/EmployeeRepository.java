package com.SpringBootCRUD.repository;

import com.SpringBootCRUD.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
