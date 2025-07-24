package com.example.DBRelationEmployee.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.DBRelationEmployee.DTO.EmployeeDTO;
import com.example.DBRelationEmployee.service.EmployeeService;
import jakarta.validation.Valid;

@Controller
public class HomeController {

 private EmployeeService employeeService;


	public HomeController(EmployeeService employeeService) {
	super();
	this.employeeService = employeeService;
}

	@GetMapping({"","/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String registration(Model model) {
		System.out.println("1234567898765432123456");
		model.addAttribute("userDTO", new EmployeeDTO());
	    return "register"; // Returns the view named "register.html"
	}
	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	

	@GetMapping("/employees")
	public String employee() {
		return "employees";
	}


	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
