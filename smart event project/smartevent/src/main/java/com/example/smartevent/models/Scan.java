package com.example.smartevent.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scans")
public class Scan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Who scanned (visitor)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // What was scanned (stall or event)
    @ManyToOne
    @JoinColumn(name = "stall_id", nullable = true)
    private Stall stall;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = true)
    private Event event;

    // When it was scanned
    private LocalDateTime scannedAt;

    // Optional: type of scan (e.g., ENTRY, EXIT, STALL_VISIT)
    private String scanType;

    // Constructors
    public Scan() {}

    public Scan(User user, Stall stall, Event event, LocalDateTime scannedAt, String scanType) {
        this.user = user;
        this.stall = stall;
        this.event = event;
        this.scannedAt = scannedAt;
        this.scanType = scanType;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stall getStall() {
        return stall;
    }

    public void setStall(Stall stall) {
        this.stall = stall;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getScannedAt() {
        return scannedAt;
    }

    public void setScannedAt(LocalDateTime scannedAt) {
        this.scannedAt = scannedAt;
    }

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }
}