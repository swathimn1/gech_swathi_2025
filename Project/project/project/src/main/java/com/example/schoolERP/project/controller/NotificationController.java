package com.example.schoolERP.project.controller;

import com.example.schoolERP.project.dto.NotificationDTO;
import com.example.schoolERP.project.service.NotificationService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/faculty/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // ✅ View all notifications
    @GetMapping
    public String listNotifications(Model model, Authentication authentication) {
        String email = authentication.getName();
        List<NotificationDTO> notifications = notificationService.getAllByFaculty(email);
        model.addAttribute("notifications", notifications);
        return "faculty/notifications/view_notifications";
    }

    // ✅ Show add notification form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("notificationDTO", new NotificationDTO());
        return "faculty/notifications/add_notification";
    }

    // ✅ Save new notification
    @PostMapping("/add")
    public String saveNotification(@ModelAttribute("notificationDTO") @Valid NotificationDTO notificationDTO,
                                   Authentication authentication) {
        String email = authentication.getName();
        notificationService.saveNotification(notificationDTO, email);
        return "redirect:/faculty/notifications";
    }

    // ✅ Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        NotificationDTO dto = notificationService.getById(id);
        model.addAttribute("notificationDTO", dto);
        return "faculty/notifications/edit_notification";
    }

    // ✅ Update existing notification
    @PostMapping("/edit/{id}")
    public String updateNotification(@PathVariable Long id,
                                     @ModelAttribute("notificationDTO") @Valid NotificationDTO notificationDTO,
                                     Authentication authentication) {
        String email = authentication.getName();
        notificationService.updateNotification(id, notificationDTO, email);
        return "redirect:/faculty/notifications";
    }

    // ✅ Delete notification
    @GetMapping("/delete/{id}")
    public String deleteNotification(@PathVariable Long id) {
        notificationService.deleteById(id);
        return "redirect:/faculty/notifications";
    }
}
