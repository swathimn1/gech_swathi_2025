package com.example.schoolERP.project.controller;

import com.example.schoolERP.project.model.Assignment;
import com.example.schoolERP.project.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;

	@GetMapping("/viewAssignments")
	public String viewAssignments(Model model) {
		List<Assignment> assignments = assignmentService.getAllAssignments();
		model.addAttribute("assignments", assignments);
		return "faculty/assignments/view_assignments";
	}

	@GetMapping("/assignments/add")
	public String showAddForm(Model model) {
		model.addAttribute("assignment", new Assignment());
		return "faculty/assignments/add_assignments"; // must match path under templates/
	}

	@PostMapping("/assignments/save")
	public String addAssignment(@ModelAttribute Assignment assignment) {
		assignmentService.saveAssignment(assignment);
		return "redirect:/viewAssignments";
	}

	@GetMapping("/assignments/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Assignment assignment = assignmentService.getAssignmentById(id); // or findById(id)
		model.addAttribute("assignment", assignment);
		return "faculty/assignments/edit_assignment"; // this file exists
	}

	@PostMapping("assignments/update")
	public String updateAssignment(@ModelAttribute Assignment assignment) {
		assignmentService.saveAssignment(assignment);
		return "redirect:/viewAssignments";
	}

	@GetMapping("/assignments/delete/{id}")
	public String deleteAssignment(@PathVariable Long id) {
		assignmentService.deleteAssignment(id);
		return "redirect:/viewAssignments";
	}
}
