package com.example.schoolERP.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacultyController {

    @GetMapping("/faculty/dashboard")
    public String facultyDashboard() {
        return "faculty_dashboard";
    }

   
}

