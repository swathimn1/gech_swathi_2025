package com.example.smartevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StallUpdateDTO {
    private String name;
    private String description;
    private String location;
    private String category;
    private String imageUrls;
    private String videoUrl;
    private Integer pointsPerVisit;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public Integer getPointsPerVisit() {
		return pointsPerVisit;
	}
	public void setPointsPerVisit(Integer pointsPerVisit) {
		this.pointsPerVisit = pointsPerVisit;
	}
	public StallUpdateDTO(String name, String description, String location, String category, String imageUrls,
			String videoUrl, Integer pointsPerVisit) {
		super();
		this.name = name;
		this.description = description;
		this.location = location;
		this.category = category;
		this.imageUrls = imageUrls;
		this.videoUrl = videoUrl;
		this.pointsPerVisit = pointsPerVisit;
	}
	public StallUpdateDTO() {
		super();
	}
    
}
