package com.example.studentform.validation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.studentform.validation.dto.StudentDTO;
import com.example.studentform.validation.models.Student;
import com.example.studentform.validation.repository.StudentRepository;
import com.example.studentform.validation.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	private final StudentRepository studentRepository;
	private final StudentService studentService;

	// Constructor injection
	public HomeController(StudentRepository studentRepository, StudentService studentService) {
		super();
		this.studentRepository = studentRepository;
		this.studentService = studentService;
	}

	@GetMapping({ "", "/" })
	public String home(Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);

		return "home";
	}

	@GetMapping("/add-student")
	public String addStudent(Model model) {
		model.addAttribute("studentDTO", new StudentDTO());
		return "add_student";
	}

	@PostMapping("/add-student")
	public String addStudent(@Valid @ModelAttribute StudentDTO studentDTO, BindingResult result, Model model,RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "add_student";
		}
		System.out.println(studentDTO.getName() + "2");
		studentService.saveStudent(studentDTO);
		attributes.addFlashAttribute("success","Student added successfully");
		return "redirect:/";
	}

	@GetMapping("/std-delete")
	public String deleteStudent(@RequestParam int id,RedirectAttributes attributes) {
		studentService.deleteStudent(id);
		attributes.addFlashAttribute("delete","student deleted successfully");
		return "redirect:/";

	}

	@GetMapping("/std-edit")
	public String editStudent(@RequestParam int id, Model model) {
		StudentDTO studentDTO=studentService.editStudent(id );
		 Student student=studentRepository.findById(id).get(); 
		model.addAttribute("studentDTO",studentDTO);
		model.addAttribute("student",student);
		return "edit-student";
	}
		@PostMapping("/edit-student")
		public String updateStudent(@Valid @ModelAttribute StudentDTO studentDTO,BindingResult result,@RequestParam int id,Model model ,RedirectAttributes attributes) {
			if(result.hasErrors()) {
				Student student=studentRepository.findById(id).get();
				 model.addAttribute("student",student);
				return "edit-student";
			}
			studentService.updateStudent(studentDTO,id);
			attributes.addFlashAttribute("edit","student edited successfully");
		return "redirect:/";
	}
}
