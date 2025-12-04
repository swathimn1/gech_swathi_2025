package com.example.smartevent.dto;

import lombok.Data;

@Data
public class VisitorEventRequest {
    private Long visitorId;
    private Long eventId;
	public Long getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(Long visitorId) {
		this.visitorId = visitorId;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
    
}
