package com.example.smartevent.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UploadResultRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String date;

    @NotBlank
    private String description;

    @Min(1)
    @Max(10)
    private int performance;

    @PositiveOrZero
    private double revenue;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPerformance() {
		return performance;
	}

	public void setPerformance(int performance) {
		this.performance = performance;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
}
