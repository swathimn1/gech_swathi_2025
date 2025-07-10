package com.example.schoolERP.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacultyController {

	@GetMapping("/faculty_dashboard")
	public String facultyDashboard(Model model) {
		model.addAttribute("facultyName", "Dr. Swathi");
		return "faculty/faculty_dashboard";
	}

	

	@GetMapping("/uploadResults")
	public String uploadResults(Model model) {
		// model.addAttribute("resultForm", new ResultDTO());
		return "faculty/upload_results";
	}

	@GetMapping("/viewAttendance")
	public String viewAttendance(Model model) {
		// model.addAttribute("attendanceList", attendanceService.getAll());
		return "faculty/view_attendance";
	}

	@GetMapping("/sendNotifications")
	public String sendNotifications(Model model) {
		// model.addAttribute("notification", new NotificationDTO());
		return "faculty/send_notifications";
	}

	@GetMapping("/manageProfile")
	public String manageProfile(Model model) {
		// model.addAttribute("facultyProfile", facultyService.getLoggedInFaculty());
		return "faculty/manage_profile";
	}

	@GetMapping("/changePassword")
	public String changePassword(Model model) {
		// model.addAttribute("passwordForm", new PasswordDTO());
		return "faculty/change_password";
	}
}
