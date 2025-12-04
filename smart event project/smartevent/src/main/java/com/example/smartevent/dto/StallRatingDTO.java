package com.example.smartevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StallRatingDTO {
    private String stallName;
    private double rating;
	
	public StallRatingDTO(String stallName, double rating) {
		super();
		this.stallName = stallName;
		this.rating = rating;
	}
	public String getStallName() {
		return stallName;
	}
	public void setStallName(String stallName) {
		this.stallName = stallName;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
    
}
