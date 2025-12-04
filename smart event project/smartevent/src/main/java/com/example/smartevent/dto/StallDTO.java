package com.example.smartevent.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StallDTO {
    private Long id;
    private String name;
    private String description;
    private String location;
    private String category;
    private String imageUrls;
    private String videoUrl;
    private String qrCode;
    private Integer pointsPerVisit;
    private String status; // PENDING, APPROVED, REJECTED
    private Long eventId;
    private String eventName;
    private String ownerName;
    private String ownerEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public Integer getPointsPerVisit() {
		return pointsPerVisit;
	}
	public void setPointsPerVisit(Integer pointsPerVisit) {
		this.pointsPerVisit = pointsPerVisit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public StallDTO(Long id, String name, String description, String location, String category, String imageUrls,
			String videoUrl, String qrCode, Integer pointsPerVisit, String status, Long eventId, String eventName,
			String ownerName, String ownerEmail, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.location = location;
		this.category = category;
		this.imageUrls = imageUrls;
		this.videoUrl = videoUrl;
		this.qrCode = qrCode;
		this.pointsPerVisit = pointsPerVisit;
		this.status = status;
		this.eventId = eventId;
		this.eventName = eventName;
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public StallDTO() {
		super();
	}
	
    
}
