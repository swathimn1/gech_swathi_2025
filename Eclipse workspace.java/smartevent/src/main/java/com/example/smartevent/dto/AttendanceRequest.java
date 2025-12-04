package com.example.smartevent.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AttendanceRequest {
    @NotBlank
    private String visitorName;

    public AttendanceRequest(@NotBlank String visitorName, @NotBlank String visitorEmail, @NotBlank String purpose,
			@NotBlank String stallVisited, @NotNull String checkInTime) {
		super();
		this.visitorName = visitorName;
		this.visitorEmail = visitorEmail;
		this.purpose = purpose;
		this.stallVisited = stallVisited;
		this.checkInTime = checkInTime;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorEmail() {
		return visitorEmail;
	}

	public void setVisitorEmail(String visitorEmail) {
		this.visitorEmail = visitorEmail;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStallVisited() {
		return stallVisited;
	}

	public void setStallVisited(String stallVisited) {
		this.stallVisited = stallVisited;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	@NotBlank
    private String visitorEmail;

    @NotBlank
    private String purpose;

    @NotBlank
    private String stallVisited;

    @NotNull
    private String checkInTime; // format: HH:mm
}
