package com.example.schoolERP.project.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.schoolERP.project.model.User;
import com.example.schoolERP.project.service.UserService;

@Controller
public class StudentController {

    @Autowired
    private UserService userService;

    @GetMapping("/student/dashboard")
    public String studentDashboard(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username); // correct usage of the service

        if (user != null) {
            model.addAttribute("user", user);
        } else {
            model.addAttribute("error", "User not found");
        }

        return "student_dashboard";
    }
}
