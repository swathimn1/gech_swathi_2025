package com.example.studentform.validation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.studentform.validation.dto.StudentDTO;
import com.example.studentform.validation.models.Student;
import com.example.studentform.validation.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	private final StudentService studentService;

	// Constructor injection
	public HomeController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping({ "", "/" })
	public String home() {
		return "home";
	}

	@GetMapping("/add-student")
	public String addStudent(Model model) {
		model.addAttribute("studentDTO", new StudentDTO());
		return "add_student";
	}
	@GetMapping("/student-list")
	public String listStudents(Model  model) {
		List<Student> students=studentService.getAllStudents();
		model.addAttribute("students",students);
		return "student-list";
		
	}

	@PostMapping("/add-student")
	public String addStudent(@Valid @ModelAttribute StudentDTO studentDTO, BindingResult result, Model model) {
		if (result.hasErrors()) {
           return "add_student";
		}
		System.out.println(studentDTO.getName()+"2");
		studentService.saveStudent(studentDTO);
		return "redirect:/";
	}
}
