package com.example.smartevent.controller;

import com.example.smartevent.dto.StallRequest;
import com.example.smartevent.dto.StallResponse;
import com.example.smartevent.models.Stall;
import com.example.smartevent.service.StallService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/stalls")
@RequiredArgsConstructor
public class StallController {

    private final StallService stallService;

    public StallController(StallService stallService) {
		super();
		this.stallService = stallService;
	}

	/**
     * ✅ Get all stalls
     */
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<StallResponse>> getAllStalls() {
        List<StallResponse> stalls = stallService.getAllStalls();
        return ResponseEntity.ok(stalls);
    }

    /**
     * ✅ Get stalls by event ID
     */
    @GetMapping("/event/{eventId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getStallsByEvent(@PathVariable Long eventId) {
        try {
            List<StallResponse> stalls = stallService.getStallsByEvent(eventId);
            return ResponseEntity.ok(stalls);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * ✅ Get stalls by owner ID
     */
    @GetMapping("/owner/{ownerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getStallsByOwner(@PathVariable Long ownerId) {
        try {
            List<StallResponse> stalls = stallService.getStallsByOwner(ownerId);
            return ResponseEntity.ok(stalls);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * ✅ Create a new stall (requires eventId & ownerId)
     */
    @PostMapping("/event/{eventId}/owner/{ownerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createStall(
            @PathVariable Long eventId,
            @PathVariable Long ownerId,
            @Valid @RequestBody StallRequest request
    ) {
        try {
            StallResponse created = stallService.createStall(request, eventId, ownerId);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * ✅ Update an existing stall
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateStall(@PathVariable Long id, @Valid @RequestBody StallRequest request) {
        try {
            StallResponse updated = stallService.updateStall(id, request);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * ✅ Delete a stall by ID
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteStall(@PathVariable Long id) {
        try {
            stallService.deleteStall(id);
            return ResponseEntity.ok("Stall deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/{id}/approve")
    public ResponseEntity<Stall> approve(@PathVariable Long id) throws Exception {
        Stall saved = stallService.approveStall(id);
        return ResponseEntity.ok(saved);
    }
}
