package com.example.smartevent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor

@AllArgsConstructor
public class StallStatsDTO {
    private Long stallId;
    private String stallName;
    private Long totalScans;
    private Long totalVisitors;
    private Double averageRating;
    private Long totalFeedback;
    private Long pendingQueries;
    private Long answeredQueries;
    private Long totalPointsDistributed;
	public Long getStallId() {
		return stallId;
	}
	public void setStallId(Long stallId) {
		this.stallId = stallId;
	}
	public String getStallName() {
		return stallName;
	}
	public void setStallName(String stallName) {
		this.stallName = stallName;
	}
	public Long getTotalScans() {
		return totalScans;
	}
	public void setTotalScans(Long totalScans) {
		this.totalScans = totalScans;
	}
	public Long getTotalVisitors() {
		return totalVisitors;
	}
	public void setTotalVisitors(Long totalVisitors) {
		this.totalVisitors = totalVisitors;
	}
	public Double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
	public Long getTotalFeedback() {
		return totalFeedback;
	}
	public void setTotalFeedback(Long totalFeedback) {
		this.totalFeedback = totalFeedback;
	}
	public Long getPendingQueries() {
		return pendingQueries;
	}
	public void setPendingQueries(Long pendingQueries) {
		this.pendingQueries = pendingQueries;
	}
	public Long getAnsweredQueries() {
		return answeredQueries;
	}
	public void setAnsweredQueries(Long answeredQueries) {
		this.answeredQueries = answeredQueries;
	}
	public Long getTotalPointsDistributed() {
		return totalPointsDistributed;
	}
	public void setTotalPointsDistributed(Long totalPointsDistributed) {
		this.totalPointsDistributed = totalPointsDistributed;
	}
	public StallStatsDTO(Long stallId, String stallName, Long totalScans, Long totalVisitors, Double averageRating,
			Long totalFeedback, Long pendingQueries, Long answeredQueries, Long totalPointsDistributed) {
		super();
		this.stallId = stallId;
		this.stallName = stallName;
		this.totalScans = totalScans;
		this.totalVisitors = totalVisitors;
		this.averageRating = averageRating;
		this.totalFeedback = totalFeedback;
		this.pendingQueries = pendingQueries;
		this.answeredQueries = answeredQueries;
		this.totalPointsDistributed = totalPointsDistributed;
	}
	public StallStatsDTO() {
		super();
	}
    
}
