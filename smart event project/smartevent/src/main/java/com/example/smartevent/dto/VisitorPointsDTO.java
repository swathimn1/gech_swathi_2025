package com.example.smartevent.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitorPointsDTO {
    private Long id;
    private int pointsEarned;
    private Long visitorId;
    private Long stallId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getPointsEarned() {
		return pointsEarned;
	}
	public void setPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
	}
	public Long getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(Long visitorId) {
		this.visitorId = visitorId;
	}
	public Long getStallId() {
		return stallId;
	}
	public void setStallId(Long stallId) {
		this.stallId = stallId;
	}
    
}

