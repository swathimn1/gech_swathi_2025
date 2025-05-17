package com.example.schoolERP.project.controller;

import com.example.schoolERP.project.model.Faculty;
import com.example.schoolERP.project.service.FacultyService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/teachers") // Base URL for all teacher-related pages
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // List all teachers
    @GetMapping
    public String listFaculties(Model model) {
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "faculty/list"; // Thymeleaf template for displaying the list of teachers
    }

    // Show the form to create a new teacher
    @GetMapping("/new")
    public String showFacultyForm(Model model) {
        model.addAttribute("faculty", new Faculty()); // Create a new Teacher object for the form
        return "faculty/form"; // Thymeleaf template for the form to add a new teacher
    }

    // Save a new teacher or update an existing one
    @PostMapping
    public String saveFaculty(@Valid @ModelAttribute Faculty faculty,BindingResult bindingResult,Model model) {
    	if (bindingResult.hasErrors()) {
            // If there are validation errors, return to the form page with error messages
            return "faculties/form";
        }
    	facultyService.saveFaculty(faculty);
        return "redirect:/admin/faculties"; // Redirect to the list of teachers after saving
    }

    // Show the form to edit an existing teacher
    @GetMapping("/edit/{id}")
    public String editFaculty(@PathVariable Long id, Model model) {
        Faculty faculty = facultyService.getFacultyById(id);
        if (faculty != null) {
            model.addAttribute("faculty", faculty);
            return "faculties/form"; // Display the teacher edit form with current teacher data
        }
        return "redirect:/admin/faculties"; // If teacher not found, redirect to the list of teachers
    }

    // Delete a teacher by ID
    @GetMapping("/delete/{id}")
    public String deleteFaculty(@PathVariable Long id) {
    	facultyService.deleteFaculty(id);
        return "redirect:/admin/Faculties"; // Redirect to the list of teachers after deletion
    }

	


   
}

