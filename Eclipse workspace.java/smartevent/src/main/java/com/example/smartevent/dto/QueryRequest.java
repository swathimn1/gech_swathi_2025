package com.example.smartevent.dto;

import com.example.smartevent.models.User;

import lombok.Data;
@Data
public class QueryRequest {
    private Long eventId; // ✅ send eventId only
    private String category;
    private String priority;
    private String status;
    private String description;
    private Long userId;
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
//	public String getTitle() {
//		// TODO Auto-generated method stub
//		return null;
//	}
    
}
