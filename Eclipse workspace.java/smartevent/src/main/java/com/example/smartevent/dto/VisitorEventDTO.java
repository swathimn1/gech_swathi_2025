package com.example.smartevent.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VisitorEventDTO {
    private Long id;
    private Long visitorId;
    private Long eventId;
    private String title;
    private String date;
    private String time;
    private String location;
    private String description;
    private String category;
    private LocalDateTime bookmarkedAt;
    private LocalDate eventStartDate;
    private LocalDate eventEndDate;
    
    // Getters and setters for all fields
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getVisitorId() { return visitorId; }
    public void setVisitorId(Long visitorId) { this.visitorId = visitorId; }
    
    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public LocalDateTime getBookmarkedAt() { return bookmarkedAt; }
    public void setBookmarkedAt(LocalDateTime bookmarkedAt) { this.bookmarkedAt = bookmarkedAt; }
    
    public LocalDate getEventStartDate() { return eventStartDate; }
    public void setEventStartDate(LocalDate localDate) { this.eventStartDate = localDate; }
    
    public LocalDate getEventEndDate() { return eventEndDate; }
    public void setEventEndDate(LocalDate eventEndDate) { this.eventEndDate = eventEndDate; }
}