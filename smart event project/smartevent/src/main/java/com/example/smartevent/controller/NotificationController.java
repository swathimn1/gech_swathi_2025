package com.example.smartevent.controller;

import com.example.smartevent.dto.NotificationRequest;
import com.example.smartevent.models.Notification;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.NotificationRepository;
import com.example.smartevent.repository.UserRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stall-owner/notifications")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class NotificationController {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationController(NotificationRepository notificationRepository, UserRepository userRepository) {
		super();
		this.notificationRepository = notificationRepository;
		this.userRepository = userRepository;
	}

	public NotificationRepository getNotificationRepository() {
		return notificationRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	@GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications(Authentication authentication) {
        User user = getUserFromAuth(authentication);
        List<Notification> notifications = notificationRepository.findByUserIdOrderByTimestampDesc(user.getId());
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/unread")
    public ResponseEntity<List<Notification>> getUnreadNotifications(Authentication authentication) {
        User user = getUserFromAuth(authentication);
        List<Notification> notifications = notificationRepository.findByUserIdAndReadFalse(user.getId());
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/unread/count")
    public ResponseEntity<Long> getUnreadCount(Authentication authentication) {
        User user = getUserFromAuth(authentication);
        Long count = notificationRepository.countByUserIdAndReadFalse(user.getId());
        return ResponseEntity.ok(count);
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(
            @Valid @RequestBody NotificationRequest request,
            Authentication authentication) {

        User user = getUserFromAuth(authentication);

        Notification notification = new Notification();
        notification.setTitle(request.getTitle());
        notification.setMessage(request.getMessage());
        notification.setPriority(Notification.Priority.valueOf(
                (request.getPriority() != null ? request.getPriority().toUpperCase() : "NORMAL")));
        notification.setCategory(Notification.Category.valueOf(
                (request.getCategory() != null ? request.getCategory().toUpperCase() : "GENERAL")));
        notification.setRead(false);
        notification.setUser(user);

        Notification savedNotification = notificationRepository.save(notification);
        return ResponseEntity.ok(savedNotification);
    }

    @PutMapping("/{id}/read")
    public ResponseEntity<Notification> markAsRead(@PathVariable Long id, Authentication authentication) {
        User user = getUserFromAuth(authentication);
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        if (!notification.getUser().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        notification.setRead(true);
        Notification updated = notificationRepository.save(notification);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/read-all")
    public ResponseEntity<?> markAllAsRead(Authentication authentication) {
        User user = getUserFromAuth(authentication);
        List<Notification> notifications = notificationRepository.findByUserIdAndReadFalse(user.getId());

        notifications.forEach(n -> n.setRead(true));
        notificationRepository.saveAll(notifications);

        return ResponseEntity.ok().body("All notifications marked as read");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNotification(@PathVariable Long id, Authentication authentication) {
        User user = getUserFromAuth(authentication);
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        if (!notification.getUser().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        notificationRepository.delete(notification);
        return ResponseEntity.ok().body("Notification deleted successfully");
    }

    private User getUserFromAuth(Authentication authentication) {
        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("Authentication is missing or invalid");
        }
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    
   
}
