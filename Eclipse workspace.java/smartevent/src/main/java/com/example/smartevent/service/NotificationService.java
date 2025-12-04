package com.example.smartevent.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.smartevent.dto.NotificationDTO;
import com.example.smartevent.exception.ResourceNotFoundException;
import com.example.smartevent.exception.UnauthorizedException;
import com.example.smartevent.models.Notification;
import com.example.smartevent.models.Query;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.NotificationRepository;
import com.example.smartevent.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    

    // ------------------------- GET NOTIFICATIONS -------------------------

    public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository) {
		super();
		this.notificationRepository = notificationRepository;
		this.userRepository = userRepository;
	}

	public List<NotificationDTO> getNotificationsByUser(String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<Notification> notifications =
                notificationRepository.findByUserIdOrderByTimestampDesc(user.getId());

        return notifications.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // ------------------------- MARK AS READ -------------------------

    public NotificationDTO markAsRead(Long id, String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found"));

        if (!notification.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedException("You are not allowed to read this notification");
        }

        notification.setRead(true);
        return convertToDTO(notificationRepository.save(notification));
    }

    // ------------------------- MARK ALL AS READ -------------------------

    public void markAllAsRead(String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<Notification> notifications =
                notificationRepository.findByUserIdAndRead(user.getId(), false);

        notifications.forEach(n -> n.setRead(true));
        notificationRepository.saveAll(notifications);
    }

    // ------------------------- DELETE -------------------------

    public void deleteNotification(Long id, String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found"));

        if (!notification.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedException("You cannot delete this notification");
        }

        notificationRepository.delete(notification);
    }

    // ------------------------- UNREAD COUNT -------------------------

    public long getUnreadCount(String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return notificationRepository.countByUserIdAndRead(user.getId(), false);
    }

    // ------------------------- NOTIFICATION TRIGGERS -------------------------

    public void notifyAdminNewStall(Stall stall) {

        List<User> admins = userRepository.findByRole("ADMIN");

        for (User admin : admins) {
            createNotification(
                    admin,
                    "New Stall Registration",
                    "A new stall '" + stall.getName() + "' is pending approval.",
                    Notification.Category.UPDATE,
                    stall.getId(),
                    "STALL"
            );
        }
    }

    public void notifyVisitorQueryAnswered(Query query) {

        User user = userRepository.findById(query.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Query user not found"));

        createNotification(
                user,
                "Query Answered",
                "Your query about '" + query.getStall().getName() + "' has been answered.",
                Notification.Category.ALERT,
                query.getId(),
                "QUERY"
        );
    }

    // ------------------------- INTERNAL CREATION METHOD -------------------------

    private void createNotification(User user, String title, String message,
                                    Notification.Category category,
                                    Long relatedEntityId, String relatedEntityType) {

        Notification notification = new Notification();
        notification.setUser(user);
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setCategory(category);
        notification.setRelatedEntityId(relatedEntityId);
        notification.setRelatedEntityType(relatedEntityType);
        notification.setRead(false);
        notification.setTimestamp(LocalDateTime.now());

        notificationRepository.save(notification);
    }

    // ------------------------- DTO CONVERTER (NO BUILDER) -------------------------

    private NotificationDTO convertToDTO(Notification notification) {

        NotificationDTO dto = new NotificationDTO();

        dto.setId(notification.getId());
        dto.setTitle(notification.getTitle());
        dto.setMessage(notification.getMessage());
        dto.setType(notification.getCategory().name());
        dto.setIsRead(notification.isRead());
        dto.setRelatedEntityId(notification.getRelatedEntityId());
        dto.setRelatedEntityType(notification.getRelatedEntityType());
        dto.setCreatedAt(notification.getTimestamp());

        return dto;
    }
}
