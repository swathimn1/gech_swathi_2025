package com.example.smartevent.dto;

import lombok.Data;

import java.util.List;

@Data
public class AnalyticsDTO {
    private long totalEvents;
    private long totalStalls;
    private long totalVisitors;
    private long totalScans;

    private List<EventVisitorsDTO> visitorsPerEvent;
    private List<StallScanDTO> scansPerStall;
    private List<StallRatingDTO> averageRatings;
	public long getTotalEvents() {
		return totalEvents;
	}
	public void setTotalEvents(long totalEvents) {
		this.totalEvents = totalEvents;
	}
	public long getTotalStalls() {
		return totalStalls;
	}
	public void setTotalStalls(long totalStalls) {
		this.totalStalls = totalStalls;
	}
	public long getTotalVisitors() {
		return totalVisitors;
	}
	public void setTotalVisitors(long totalVisitors) {
		this.totalVisitors = totalVisitors;
	}
	public long getTotalScans() {
		return totalScans;
	}
	public void setTotalScans(long totalScans) {
		this.totalScans = totalScans;
	}
	public List<EventVisitorsDTO> getVisitorsPerEvent() {
		return visitorsPerEvent;
	}
	public void setVisitorsPerEvent(List<EventVisitorsDTO> visitorsPerEvent) {
		this.visitorsPerEvent = visitorsPerEvent;
	}
	public List<StallScanDTO> getScansPerStall() {
		return scansPerStall;
	}
	public void setScansPerStall(List<StallScanDTO> scansPerStall) {
		this.scansPerStall = scansPerStall;
	}
	public List<StallRatingDTO> getAverageRatings() {
		return averageRatings;
	}
	public void setAverageRatings(List<StallRatingDTO> averageRatings) {
		this.averageRatings = averageRatings;
	}
	
}
