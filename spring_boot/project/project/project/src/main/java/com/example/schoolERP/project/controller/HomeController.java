package com.example.schoolERP.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"","/"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/admin_dashboard")
	public String adminDashboard() {
		return "admin_dashboard";
	}
	
	
}
