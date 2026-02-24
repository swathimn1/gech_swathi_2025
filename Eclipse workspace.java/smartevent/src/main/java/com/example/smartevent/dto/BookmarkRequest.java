package com.example.smartevent.dto;

import jakarta.validation.constraints.NotNull;

public class BookmarkRequest {
    
    @NotNull(message = "Event ID is required")
    private Long eventId;
    
    public Long getEventId() {
        return eventId;
    }
    
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}