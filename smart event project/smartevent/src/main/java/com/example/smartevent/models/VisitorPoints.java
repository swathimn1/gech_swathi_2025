package com.example.smartevent.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "visitor_points")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitorPoints {

    public VisitorPoints(Long id, int pointsEarned, User visitor, Stall stall) {
		super();
		this.id = id;
		this.pointsEarned = pointsEarned;
		this.visitor = visitor;
		this.stall = stall;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pointsEarned;

    // ✅ Many points belong to one visitor (User)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor_id")
    @JsonBackReference(value = "user-points") // Matches @JsonManagedReference in User
    private User visitor;

    // ✅ Each VisitorPoint belongs to one Stall
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stall_id")
    @JsonBackReference(value = "stall-points") // Matches @JsonManagedReference in Stall
    private Stall stall;

    public VisitorPoints(User visitor, Stall stall, int pointsEarned) {
        this.visitor = visitor;
        this.stall = stall;
        this.pointsEarned = pointsEarned;
    }

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

	public User getVisitor() {
		return visitor;
	}

	public void setVisitor(User visitor) {
		this.visitor = visitor;
	}

	public Stall getStall() {
		return stall;
	}

	public void setStall(Stall stall) {
		this.stall = stall;
	}

	public VisitorPoints() {
		super();
	}
}

