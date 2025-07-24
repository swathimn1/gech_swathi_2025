package com.example.dbrelationship.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dbrelationship.dto.TaskDTO;
import com.example.dbrelationship.model.Employee;
import com.example.dbrelationship.model.Task;
import com.example.dbrelationship.repository.EmployeeRepository;
import com.example.dbrelationship.repository.TaskRepository;

import jakarta.validation.Valid;

@Service
public class TaskService {

	private final TaskRepository taskRepository;
	private final EmployeeRepository employeeRepository;

	public TaskService(TaskRepository taskRepository, EmployeeRepository employeeRepository) {
		this.taskRepository = taskRepository;
		this.employeeRepository = employeeRepository;
	}

	public void saveTask(@Valid TaskDTO taskDTO, Employee employee) {
		Task task = new Task();
		task.setTitle(taskDTO.getTitle());
		task.setDescription(taskDTO.getDescription());
		task.setEmployee(employee);
		taskRepository.save(task);
	}

	public void updateTask(@Valid TaskDTO taskDTO, Long id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
		task.setTitle(taskDTO.getTitle().toUpperCase());
		task.setDescription(taskDTO.getDescription());
		taskRepository.save(task);
	}

	public void saveTaskForEmployee(Long employeeId, String title, String description) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		if (optionalEmployee.isEmpty()) {
			throw new RuntimeException("Employee not found with ID: " + employeeId);
		}

		Task task = new Task();
		task.setTitle(title);
		task.setDescription(description);
		task.setEmployee(optionalEmployee.get());

		taskRepository.save(task);
	}
}
