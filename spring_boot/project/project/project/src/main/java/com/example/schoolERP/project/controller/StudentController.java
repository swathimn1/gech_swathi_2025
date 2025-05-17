package com.example.schoolERP.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.schoolERP.project.dto.StudentDTO;
import com.example.schoolERP.project.model.Student;
import com.example.schoolERP.project.service.StudentService;


@Controller
public class StudentController {
	
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping({"","/"})
	public String home() {
		return "home";
	}
	
	@GetMapping
	public String getAllStudents(Model model) {
		List<Student> students =  studentService.getAll();
		model.addAttribute("students",students);
		return "";
	}
}
