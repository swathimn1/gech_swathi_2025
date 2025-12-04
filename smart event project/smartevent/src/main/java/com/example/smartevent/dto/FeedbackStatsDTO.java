package com.example.smartevent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackStatsDTO {
    private Long stallId;
    private String stallName;
    private Double averageRating;
    private Long totalFeedback;
    private Long rating5Count;
    private Long rating4Count;
    private Long rating3Count;
    private Long rating2Count;
    private Long rating1Count;
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
	public Long getRating5Count() {
		return rating5Count;
	}
	public void setRating5Count(Long rating5Count) {
		this.rating5Count = rating5Count;
	}
	public Long getRating4Count() {
		return rating4Count;
	}
	public void setRating4Count(Long rating4Count) {
		this.rating4Count = rating4Count;
	}
	public Long getRating3Count() {
		return rating3Count;
	}
	public void setRating3Count(Long rating3Count) {
		this.rating3Count = rating3Count;
	}
	public Long getRating2Count() {
		return rating2Count;
	}
	public void setRating2Count(Long rating2Count) {
		this.rating2Count = rating2Count;
	}
	public Long getRating1Count() {
		return rating1Count;
	}
	public void setRating1Count(Long rating1Count) {
		this.rating1Count = rating1Count;
	}
	public FeedbackStatsDTO(Long stallId, String stallName, Double averageRating, Long totalFeedback, Long rating5Count,
			Long rating4Count, Long rating3Count, Long rating2Count, Long rating1Count) {
		super();
		this.stallId = stallId;
		this.stallName = stallName;
		this.averageRating = averageRating;
		this.totalFeedback = totalFeedback;
		this.rating5Count = rating5Count;
		this.rating4Count = rating4Count;
		this.rating3Count = rating3Count;
		this.rating2Count = rating2Count;
		this.rating1Count = rating1Count;
	}
	public FeedbackStatsDTO() {
		super();
	}
    
}