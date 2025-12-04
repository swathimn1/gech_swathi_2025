package com.example.smartevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventVisitorsDTO {
    private String eventName;
    private long visitors;
	
	public EventVisitorsDTO(String eventName, long visitors) {
		super();
		this.eventName = eventName;
		this.visitors = visitors;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public long getVisitors() {
		return visitors;
	}
	public void setVisitors(long visitors) {
		this.visitors = visitors;
	}
    
}
