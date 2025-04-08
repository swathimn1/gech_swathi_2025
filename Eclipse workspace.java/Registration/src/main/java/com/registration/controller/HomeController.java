package com.registration.controller;

import com.registration.dto.DTO;
import com.registration.model.Registration;
import com.registration.service.RegistrationService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/registration")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private RegistrationService service;
    
    @GetMapping({"" , "/"}) 
    public String home() {
        return "redirect:/registration/list";
    }


    @GetMapping("/register")
    public String showForm(Model model) {
        logger.info("Displaying registration form.");
        model.addAttribute("dto", new DTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute DTO dto,
            BindingResult result,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            logger.warn("Validation errors occurred during user registration.");
            return "register";
        }
        service.register(dto);
        attributes.addFlashAttribute("success", "User registered successfully!");
        logger.info("User registration completed successfully.");
        return "redirect:/registration/list";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        logger.info("Fetching list of all registered users.");
        List<Registration> users = service.getAllRegistration();
        model.addAttribute("register", users);
        return "register-list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        logger.info("Fetching user details for editing. User ID: {}", id);
        Registration user = service.getRegistrationById(id);
        if (user == null) {
            logger.error("User with ID: {} not found.", id);
            return "redirect:/registration/list";
        }
        model.addAttribute("registration", user);
        return "register-edit";
    }

    @PostMapping("/update/{id}")
    public String updateUser(
            @PathVariable long id,
            @Valid @ModelAttribute("registration") Registration registration,
            BindingResult result,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            logger.warn("Validation errors occurred during user update. User ID: {}", id);
            return "register-edit";
        }
        service.updateRegistration(id, registration);
        attributes.addFlashAttribute("edit", "User updated successfully!");
        logger.info("User with ID: {} updated successfully.", id);
        return "redirect:/registration/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id, RedirectAttributes attributes) {
        logger.info("Attempting to delete user with ID: {}", id);
        try {
            service.deleteRegistration(id);
            attributes.addFlashAttribute("delete", "User deleted successfully!");
            logger.info("User with ID: {} deleted successfully.", id);
        } catch (RuntimeException e) {
            attributes.addFlashAttribute("error", e.getMessage());
            logger.error("Failed to delete user with ID: {}. Error: {}", id, e.getMessage());
        }
        return "redirect:/registration/list";
    }
}




