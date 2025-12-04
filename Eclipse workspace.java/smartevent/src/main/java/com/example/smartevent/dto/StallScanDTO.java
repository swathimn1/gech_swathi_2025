package com.example.smartevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StallScanDTO {
    private String stallName;
    private long scans;
	
	public StallScanDTO(String stallName, long scans) {
		super();
		this.stallName = stallName;
		this.scans = scans;
	}
	public String getStallName() {
		return stallName;
	}
	public void setStallName(String stallName) {
		this.stallName = stallName;
	}
	public long getScans() {
		return scans;
	}
	public void setScans(long scans) {
		this.scans = scans;
	}
}
