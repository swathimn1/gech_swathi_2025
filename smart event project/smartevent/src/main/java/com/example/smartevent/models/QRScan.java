package com.example.smartevent.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "qr_scans")
public class QRScan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private LocalDateTime timestamp;
    private Integer points;
    private Long userId;
    private Long stallId;
    private Long visitorId;
    @Column(name = "scanned_at")
    private LocalDateTime scannedAt;


    

	public LocalDateTime getScannedAt() {
		return scannedAt;
	}

	public Long getStallId() {
		return stallId;
	}

	public void setStallId(Long stallId) {
		this.stallId = stallId;
	}

	public Long getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(Long visitorId) {
		this.visitorId = visitorId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	public void setScannedAt(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
}