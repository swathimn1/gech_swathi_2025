package com.profileForm.profileForm.controller;

import com.profileForm.profileForm.dto.profileFormDTO;
import com.profileForm.profileForm.models.profileForm;
import com.profileForm.profileForm.service.profileFormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class profileFormController {

    @Autowired
    private profileFormService service;

    @GetMapping("/profile")
    public String showForm(Model model) {
        model.addAttribute("profileDto", new profileFormDTO());
        model.addAttribute("profiles", service.getAllProfiles());
        return "profile-form";
    }

    @PostMapping("/profile")
    public String submitForm(@ModelAttribute profileFormDTO dto) {
        profileForm profile = new profileForm();
        profile.setName(dto.getName());
        profile.setGender(dto.getGender());
        profile.setColor(dto.getColor());
        profile.setFontSize(dto.getFontSize());
        service.saveProfile(profile);
        return "redirect:/profile";
    }

    @GetMapping("/profile/delete/{id}")
    public String deleteProfile(@PathVariable Long id) {
        service.deleteProfile(id);
        return "redirect:/profile";
    }
}
