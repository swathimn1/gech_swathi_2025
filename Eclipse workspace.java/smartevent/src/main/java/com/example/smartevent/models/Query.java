package com.example.smartevent.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "queries")
public class Query {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private boolean response;

    @ManyToOne
    @JoinColumn(name = "stall_id")
    private Stall stall;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private User visitor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getResponse() {
		return response;
	}

	public void setResponse(boolean b) {
		this.response = b;
	}

	public Stall getStall() {
		return stall;
	}

	public void setStall(Stall stall) {
		this.stall = stall;
	}

	public User getVisitor() {
		return visitor;
	}

	public void setVisitor(User visitor) {
		this.visitor = visitor;
	}

	
    
}
