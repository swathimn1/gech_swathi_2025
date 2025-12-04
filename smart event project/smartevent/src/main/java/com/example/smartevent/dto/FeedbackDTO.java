package com.example.smartevent.dto;

import java.time.LocalDate;

public class FeedbackDTO {

    private Long id;
    private int rating;
    private String comments;
    private String category;
    private String stallName;
    private LocalDate visitDate;
    private Long userId;

    public FeedbackDTO() {}

    public FeedbackDTO(Long id, int rating, String comments, String category,
                       String stallName, LocalDate visitDate, Long userId) {
        this.id = id;
        this.rating = rating;
        this.comments = comments;
        this.category = category;
        this.stallName = stallName;
        this.visitDate = visitDate;
        this.userId = userId;
    }

    // --- Getters & Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
