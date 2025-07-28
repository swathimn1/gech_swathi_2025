package com.example.schoolERP.project.controller;

import java.security.Principal;

import com.example.schoolERP.project.dto.ChangePasswordDTO;
import com.example.schoolERP.project.dto.FacultyDTO;
import com.example.schoolERP.project.service.FacultyService;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication; // ✅ RIGHT

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/faculty_dashboard")
    public String facultyDashboard(Model model) {
        model.addAttribute("facultyName", "Dr. Swathi");
        return "faculty/faculty_dashboard";
    }

    @GetMapping("/viewAttendance")
    public String viewAttendance() {
        return "faculty/view_attendance";
    }

    @GetMapping("/sendNotifications")
    public String sendNotifications() {
        return "faculty/send_notifications";
    }

    @GetMapping("/faculty/manageProfile")
    public String manageProfile(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        FacultyDTO faculty = facultyService.findByEmail(principal.getName());
        if (faculty == null) {
            return "redirect:/faculty/not-found";
        }

        model.addAttribute("faculty", faculty);
        return "faculty/manage_profile";
    }

    @PostMapping("/faculty/updateProfile")
    public String updateProfile(@ModelAttribute FacultyDTO facultyForm,
                                Principal principal,
                                RedirectAttributes redirectAttributes) {
        if (principal == null) {
            return "redirect:/login";
        }

        FacultyDTO existingFaculty = facultyService.findByEmail(principal.getName());
        if (existingFaculty == null) {
            return "redirect:/faculty/not-found";
        }

        // Update allowed fields
        existingFaculty.setName(facultyForm.getName());
        existingFaculty.setEmail(facultyForm.getEmail());

        facultyService.saveFaculty(existingFaculty);

        redirectAttributes.addFlashAttribute("success", "Profile updated successfully!");
        return "redirect:/faculty/viewProfile";
    }

    @GetMapping("/changePassword")
    public String showChangePasswordForm(Model model) {
        model.addAttribute("changePasswordDTO", new ChangePasswordDTO());
        return "faculty/change_password";
    }
    @PostMapping("/changePassword")
    public String changePassword(@Valid @ModelAttribute("changePasswordDTO") ChangePasswordDTO dto,
                                 BindingResult result,
                                 Model model,
                                 Authentication authentication,
                                 RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "faculty/change_password";
        }

        if (!dto.getNewPassword().equals(dto.getConfirmPassword())) {
            model.addAttribute("error", "New password and confirm password do not match.");
            return "faculty/change_password";
        }

        String email = authentication.getName();
        boolean changed = facultyService.changePassword(email, dto);

        if (!changed) {
            model.addAttribute("error", "Current password is incorrect.");
            return "faculty/change_password";
        }

        // ✅ Success
        redirectAttributes.addFlashAttribute("success", "Password changed successfully.");
        return "redirect:/faculty_dashboard";
    }


    

//    @PostMapping("/changePassword")
//    public String changePassword(@Valid @ModelAttribute("changePasswordDTO") ChangePasswordDTO dto,
//                                 BindingResult result,
//                                 Model model,
//                                 Authentication authentication) {
//
//        if (result.hasErrors()) {
//            return "faculty/change_password";
//        }
//
//        if (!dto.getNewPassword().equals(dto.getConfirmPassword())) {
//            model.addAttribute("error", "New password and confirm password do not match.");
//            return "faculty/change_password";
//        }
//
//        String email = authentication.getName(); // ✅ Corrected line
//        boolean changed = facultyService.changePassword(email, dto);
//
//        if (!changed) {
//            model.addAttribute("error", "Current password is incorrect.");
//            return "faculty/change_password";
//        }
//
//        model.addAttribute("success", "Password changed successfully.");
//        return "faculty/change_password";
//    }

    @GetMapping("/faculty/viewProfile")
    public String viewProfile(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        FacultyDTO faculty = facultyService.findByEmail(principal.getName());
        if (faculty == null) {
            return "redirect:/faculty/not-found";
        }

        model.addAttribute("faculty", faculty);
        return "faculty/viewprofile";
    }
}
