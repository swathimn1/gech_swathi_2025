package com.example.smartevent.dto;

import lombok.Data;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;

@Data
public class StallResponse {
    
    private Long id;
    private String name;
    private String location;
    private String category;
    private Integer capacity;
    private String status;
    private Long ownerId;
    private String ownerName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @NotNull(message = "Event ID is required")
    private Long eventId;
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public StallResponse() {
		super();
	}
	
	public StallResponse(Long id, String name, String location, String category, Integer capacity, String status,
			Long ownerId, String ownerName, LocalDateTime createdAt, LocalDateTime updatedAt,
			@NotNull(message = "Event ID is required") Long eventId) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.category = category;
		this.capacity = capacity;
		this.status = status;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.eventId = eventId;
	}
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
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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
}
