package com.example.dbrelationship.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.dbrelationship.dto.DepartmentDTO;
import com.example.dbrelationship.model.Department;
import com.example.dbrelationship.model.Employee;
import com.example.dbrelationship.repository.DepartmentsRepository;

import jakarta.validation.Valid;

@Service
public class DepartmentService {

	private final DepartmentsRepository departmentsRepository;

	public DepartmentService(DepartmentsRepository departmentsRepository) {
		this.departmentsRepository = departmentsRepository;
	}

	public void saveDepartment(@Valid DepartmentDTO departmentDTO) {
		Department department = new Department();
		department.setName(departmentDTO.getName().toUpperCase());

		// Handle employees if DTO supports it, else comment out
		Set<Employee> employees = departmentDTO.getEmployees() != null ? departmentDTO.getEmployees() : new HashSet<>();
		for (Employee employee : employees) {
			employee.setDepartment(department);
		}
		department.setEmployees(employees);

		departmentsRepository.save(department);
	}

	public void updateDepartment(@Valid DepartmentDTO departmentDTO, Long id) {
		Department department = departmentsRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Department not found with id: " + id));

		department.setName(departmentDTO.getName().toUpperCase());

		Set<Employee> employees = departmentDTO.getEmployees() != null ? departmentDTO.getEmployees() : new HashSet<>();
		for (Employee employee : employees) {
			employee.setDepartment(department);
		}
		department.setEmployees(employees);

		departmentsRepository.save(department);
	}

	public void deleteDepartment(Long id) {
		departmentsRepository.deleteById(id);
	}
}
