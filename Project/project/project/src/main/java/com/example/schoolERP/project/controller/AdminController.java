package com.example.schoolERP.project.controller;

import com.example.schoolERP.project.dto.SchoolClassDTO;
import com.example.schoolERP.project.service.SchoolClassService;
import com.example.schoolERP.project.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private SchoolClassService schoolClassService;

	@GetMapping("/admin_dashboard")
	public String adminDashboard() {
		return "admin/admin_dashboard";
	}

	@GetMapping("/manage_students")
	public String manageStudents() {
		return "admin/manage_students";
	}

	

	// Save a new class
	@PostMapping("/save")
	public String saveClass(@ModelAttribute("newClass") SchoolClassDTO dto) {
		schoolClassService.saveClass(dto);
		return "redirect:/classes";
	}

	@GetMapping("/classes/edit/{id}")
	public String editClass(@PathVariable Long id, Model model) {
		SchoolClassDTO dto = schoolClassService.getClassById(id);
		model.addAttribute("newClass", dto);
		model.addAttribute("editMode", true); // Set to true for edit
		model.addAttribute("classList", schoolClassService.getAllClasses());
		return "admin/classes";
	}

	@PostMapping("/classes/update/{id}")
	public String updateClass(@PathVariable Long id, @ModelAttribute("newClass") SchoolClassDTO dto) {
		schoolClassService.updateClass(id, dto);
		return "redirect:/classes";
	}

	@GetMapping("/classes/delete/{id}")
	public String deleteClass(@PathVariable Long id) {
		schoolClassService.deleteClass(id);
		return "redirect:/classes";
	}

	@GetMapping("/manage_faculty")
	public String manageFaculty() {
		return "admin/manage_faculty";
	}
}
