package com.example.dbrelationship.dto;

import java.util.HashSet;
import java.util.Set;

import com.example.dbrelationship.model.Employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class RolesDTO {
	@NotBlank(message="name is required")
 private String name;
	
 private Set<Employee> employees = new HashSet<>();
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<Employee> getEmployees() {
	return employees;
}
public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
}
}
