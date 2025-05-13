package com.example.schoolERP.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.schoolERP.project.service.UserService;

import org.springframework.ui.Model;

@Controller
public class SchoolERPController {
	 @Autowired
	    private UserService userService;
    public SchoolERPController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/")
    public String home() {
        return "home";
    }

    // GET for login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // POST for login form submission
    @PostMapping("/login")
    public String doLogin(@RequestParam String role, RedirectAttributes redirectAttributes) {
        // Directly route based on the selected role (no validation)
        if (role.equalsIgnoreCase("admin")) {
            return "redirect:/admin/dashboard";
        } else if (role.equalsIgnoreCase("faculty")) {
            return "redirect:/faculty/dashboard";
        } else if (role.equalsIgnoreCase("student")) {
            return "redirect:/student/dashboard";
        } else {
            // If no role selected or invalid role
            redirectAttributes.addFlashAttribute("error", "Please select a valid role.");
            return "redirect:/login";
        }
    }


   
    }

   

    