package com.example.smartevent.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StallOwnerDashboardDTO {
    private Long totalStalls;
    private Long approvedStalls;
    private Long pendingStalls;
    private Long rejectedStalls;
    private Long totalScans;
    private Long totalVisitors;
    private Long pendingQueries;
    private Long unreadNotifications;
    private Double averageRating;
    private List<StallDTO> recentStalls;
    private List<QueryRequest> recentQueries;
    private List<NotificationRequest> recentNotifications;
	public Long getTotalStalls() {
		return totalStalls;
	}
	public void setTotalStalls(Long totalStalls) {
		this.totalStalls = totalStalls;
	}
	public Long getApprovedStalls() {
		return approvedStalls;
	}
	public void setApprovedStalls(Long approvedStalls) {
		this.approvedStalls = approvedStalls;
	}
	public Long getPendingStalls() {
		return pendingStalls;
	}
	public void setPendingStalls(Long pendingStalls) {
		this.pendingStalls = pendingStalls;
	}
	public Long getRejectedStalls() {
		return rejectedStalls;
	}
	public void setRejectedStalls(Long rejectedStalls) {
		this.rejectedStalls = rejectedStalls;
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
	public Long getPendingQueries() {
		return pendingQueries;
	}
	public void setPendingQueries(Long pendingQueries) {
		this.pendingQueries = pendingQueries;
	}
	public Long getUnreadNotifications() {
		return unreadNotifications;
	}
	public void setUnreadNotifications(Long unreadNotifications) {
		this.unreadNotifications = unreadNotifications;
	}
	public Double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
	public List<StallDTO> getRecentStalls() {
		return recentStalls;
	}
	public void setRecentStalls(List<StallDTO> recentStalls) {
		this.recentStalls = recentStalls;
	}
	public List<QueryRequest> getRecentQueries() {
		return recentQueries;
	}
	public void setRecentQueries(List<QueryRequest> recentQueries) {
		this.recentQueries = recentQueries;
	}
	public List<NotificationRequest> getRecentNotifications() {
		return recentNotifications;
	}
	public void setRecentNotifications(List<NotificationRequest> recentNotifications) {
		this.recentNotifications = recentNotifications;
	}
    
}