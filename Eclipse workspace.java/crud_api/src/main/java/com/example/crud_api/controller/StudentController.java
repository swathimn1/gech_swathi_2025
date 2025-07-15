package com.example.crud_api.controller;

import com.example.crud_api.dto.StudentDTO;
import com.example.crud_api.model.Student;
import com.example.crud_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students") // Base URL: http://localhost:8080/students
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// 🔹 GET all students
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	// 🔹 GET student by ID
	@GetMapping("/{id}")
	public StudentDTO getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}

	// 🔹 POST: Add a new student
	@PostMapping
	public void saveStudent(@RequestBody StudentDTO studentDTO) {
		studentService.saveStudent(studentDTO);
	}

	// 🔹 PUT: Update an existing student by ID
	@PutMapping("/{id}")
	public void updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
		studentDTO.setId(id);
		studentService.saveStudent(studentDTO); // Same method used for update
	}

	// 🔹 DELETE: Delete a student by ID
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}

	// 🔹 Test Endpoint to verify the controller is loading
	@GetMapping("/test")
	public String testApi() {
		return "✅ API is working!";
	}
}
