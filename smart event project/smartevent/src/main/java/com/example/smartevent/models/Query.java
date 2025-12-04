package com.example.smartevent.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "queries")
@Data
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;
    private String priority;
    private String status;
    private String description;

    @Column(name = "asked_at")
    private LocalDateTime askedAt;
    
    public LocalDateTime getAskedAt() {
		return askedAt;
	}

	public void setAskedAt(LocalDateTime askedAt) {
		this.askedAt = askedAt;
	}

	public LocalDateTime getAnsweredAt() {
		return answeredAt;
	}

	public void setAnsweredAt(LocalDateTime answeredAt) {
		this.answeredAt = answeredAt;
	}

	@Column(name = "answered_at")
    private LocalDateTime answeredAt;

    // ❗ Just store userId — no mapping to User
    private Long userId;
    public Long getUserId() {
		return userId;
	}

	

	@ManyToOne
    private Stall stall;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public Stall getStall() {
		return stall;
	}

	public void setStall(Stall stall) {
		this.stall = stall;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	

	
	

	

	
	

	
}
