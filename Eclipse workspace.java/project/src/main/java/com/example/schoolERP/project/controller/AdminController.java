package com.example.schoolERP.project.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        // Dummy data for admin dashboard
        model.addAttribute("totalStudents", 450);
        model.addAttribute("totalFaculty", 65);
        model.addAttribute("totalClasses", 30);
        model.addAttribute("pendingRequests", 12);
        return "admin_dashboard";
    }
    @GetMapping("/add-student")
    public String addStudentPage() {
        return "add_student";  // Make sure you have 'add_student.html' inside templates
    }


    @GetMapping("/manage_students")
    public String manageStudents() {
        return "manage_students";
    }

    @GetMapping("/manage_faculty")
    public String manageFaculty() {
        return "manage_faculty";
    }

    @GetMapping("/classes")
    public String manageClasses() {
        return "manage_classes";
    }

    @GetMapping("/reports")
    public String reports() {
        return "reports";
    }
}

