package com.example.smartevent.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.smartevent.models.Event;

public class EventDTO {
    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private String category;
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate localDate) { this.startDate = localDate; }
    
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Event toEntity() {
        Event event = new Event();
        event.setTitle(this.title);
        event.setLocation(this.location);
        event.setDescription(this.description);
        event.setStartDate(this.startDate);
        event.setEndDate(this.endDate);
        // Set default if category is null or blank
        event.setCategory(this.category != null && !this.category.trim().isEmpty() 
            ? this.category.trim() 
            : "Workshop");
        return event;
    }
}