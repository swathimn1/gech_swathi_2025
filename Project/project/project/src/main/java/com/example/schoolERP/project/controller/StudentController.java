package com.example.schoolERP.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/student/dashboard")
    public String studentDashboard() {
        return "student_dashboard";
    }

    // Add other student-specific mappings here if needed
}

