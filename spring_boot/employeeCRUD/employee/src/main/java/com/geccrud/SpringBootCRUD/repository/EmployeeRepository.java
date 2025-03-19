package com.geccrud.SpringBootCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.geccrud.SpringBootCRUD.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

