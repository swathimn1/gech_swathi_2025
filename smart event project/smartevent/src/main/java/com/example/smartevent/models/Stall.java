package com.example.smartevent.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "stalls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer capacity;

    private String description;
    public String getDescription() {
		return description;
	}
	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.AVAILABLE; // Default status

    // ✅ Stall belongs to one owner (User)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @JsonBackReference(value = "user-stalls") // Matches @JsonManagedReference in User
    private User owner;

    // ✅ Stall belongs to one event
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    @JsonBackReference(value = "event-stalls") // Matches @JsonManagedReference in Event
    private Event event;

    // ✅ A stall can have many visitors who earn points
    @OneToMany(mappedBy = "stall", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "stall-points") // Matches @JsonBackReference in VisitorPoints
    private List<VisitorPoints> visitorPoints;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @Column(name = "image_urls", length = 1000)
    private String imageUrls;
    
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

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public Integer getPointsPerVisit() {
		return pointsPerVisit;
	}

	public void setPointsPerVisit(Integer pointsPerVisit) {
		this.pointsPerVisit = pointsPerVisit;
	}
	@Column(name = "video_url")
    private String videoUrl;
    
    @Column(name = "qr_code", unique = true)
    private String qrCode;
    
    @Column(name = "points_per_visit")
    private Integer pointsPerVisit = 10;
    public enum Status {
        AVAILABLE,
        OCCUPIED, PENDING
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    private Boolean approved = false;

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	

	

	public Stall(Long id, String name, String location, String category, Integer capacity, Status status, User owner,
			Event event, List<VisitorPoints> visitorPoints, LocalDateTime createdAt, LocalDateTime updatedAt,
			String imageUrls, String videoUrl, String qrCode, Integer pointsPerVisit, Boolean approved) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.category = category;
		this.capacity = capacity;
		this.status = status;
		this.owner = owner;
		this.event = event;
		this.visitorPoints = visitorPoints;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.imageUrls = imageUrls;
		this.videoUrl = videoUrl;
		this.qrCode = qrCode;
		this.pointsPerVisit = pointsPerVisit;
		this.approved = approved;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<VisitorPoints> getVisitorPoints() {
		return visitorPoints;
	}

	public void setVisitorPoints(List<VisitorPoints> visitorPoints) {
		this.visitorPoints = visitorPoints;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Stall() {
		super();
	}

	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}
}
