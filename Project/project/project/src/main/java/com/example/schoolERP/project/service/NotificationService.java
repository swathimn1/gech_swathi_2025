package com.example.schoolERP.project.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.schoolERP.project.dto.NotificationDTO;
import com.example.schoolERP.project.model.Faculty;
import com.example.schoolERP.project.model.Notification;
import com.example.schoolERP.project.repository.FacultyRepository;
import com.example.schoolERP.project.repository.NotificationRepository;

@Service
public class NotificationService {
	private final NotificationRepository notificationRepository;
    private final FacultyRepository facultyRepository;
	public NotificationService(NotificationRepository notificationRepository, FacultyRepository facultyRepository) {
		super();
		this.notificationRepository = notificationRepository;
		this.facultyRepository = facultyRepository;
	}
		
	public void saveNotification(NotificationDTO notificationDTO, String facultyEmail) {
	    Faculty faculty = facultyRepository.findByEmail(facultyEmail);

	    if (faculty == null) {
	        throw new IllegalArgumentException("Invalid faculty email: " + facultyEmail);
	    }

	    Notification notification = new Notification();
	    notification.setTitle(notificationDTO.getTitle());
	    notification.setMessage(notificationDTO.getMessage());
	    notification.setCreatedAt(LocalDateTime.now());
	    notification.setFaculty(faculty);

	    notificationRepository.save(notification);
	}

	public List<NotificationDTO> getAllByFaculty(String facultyEmail) {
	    Faculty faculty = facultyRepository.findByEmail(facultyEmail);

	    if (faculty == null) {
	        throw new IllegalArgumentException("Invalid faculty email: " + facultyEmail);
	    }

	    List<Notification> notifications = notificationRepository.findByFaculty(faculty);

	    return notifications.stream().map(notification -> {
	        NotificationDTO dto = new NotificationDTO();
	        dto.setId(notification.getId());
	        dto.setTitle(notification.getTitle());
	        dto.setMessage(notification.getMessage());
	        dto.setCreatedAt(notification.getCreatedAt());
	        return dto;
	    }).collect(Collectors.toList());
	}

	 public NotificationDTO getById(Long id) {
	        Notification notification = notificationRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid notification ID: " + id));

	        NotificationDTO dto = new NotificationDTO();
	        dto.setId(notification.getId());
	        dto.setTitle(notification.getTitle());
	        dto.setMessage(notification.getMessage());
	        dto.setCreatedAt(notification.getCreatedAt());
	        return dto;
	    }
	 public void deleteById(Long id) {
	        notificationRepository.deleteById(id);
	    }
	 public void updateNotification(Long id, NotificationDTO notificationDTO, String facultyEmail) {
		    Faculty faculty = facultyRepository.findByEmail(facultyEmail);
		    if (faculty == null) {
		        throw new IllegalArgumentException("Invalid faculty email: " + facultyEmail);
		    }

		    Notification existing = notificationRepository.findById(id)
		            .orElseThrow(() -> new IllegalArgumentException("Notification not found with ID: " + id));

		    // Ensure that the notification belongs to the current faculty
		    if (!existing.getFaculty().getId().equals(faculty.getId())) {
		        throw new SecurityException("You are not authorized to update this notification.");
		    }

		    // Update fields
		    existing.setTitle(notificationDTO.getTitle());
		    existing.setMessage(notificationDTO.getMessage());
		    existing.setCreatedAt(LocalDateTime.now()); // optional: you can keep original createdAt if needed

		    notificationRepository.save(existing);
		}

}
