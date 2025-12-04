package com.example.smartevent.controller;

import com.example.smartevent.dto.AttendanceRequest;
import com.example.smartevent.dto.AttendanceResponse;
import com.example.smartevent.models.Attendance;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.AttendanceRepository;
import com.example.smartevent.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stall-owner/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;

    public AttendanceController(AttendanceRepository attendanceRepository, UserRepository userRepository) {
		super();
		this.attendanceRepository = attendanceRepository;
		this.userRepository = userRepository;
	}

	// ✅ Get all attendance records for logged-in stall owner
    @GetMapping
    public ResponseEntity<List<AttendanceResponse>> getAll(Authentication authentication) {
        User user = getUserFromAuth(authentication);
        List<Attendance> records = attendanceRepository.findByOwnerId(user.getId());
        return ResponseEntity.ok(
                records.stream().map(this::convertToResponse).collect(Collectors.toList())
        );
    }

    // ✅ Create new attendance record
    @PostMapping
    public ResponseEntity<AttendanceResponse> create(
            @Valid @RequestBody AttendanceRequest request,
            Authentication authentication) {

        User user = getUserFromAuth(authentication);

        Attendance record = new Attendance();
        record.setVisitorName(request.getVisitorName());
        record.setVisitorEmail(request.getVisitorEmail());
        record.setPurpose(request.getPurpose());
        record.setStallVisited(request.getStallVisited());
        record.setDate(LocalDate.now());
        record.setCheckInTime(LocalTime.parse(request.getCheckInTime()));
        record.setOwner(user);

        Attendance saved = attendanceRepository.save(record);
        return ResponseEntity.ok(convertToResponse(saved));
    }

    // ✅ Update attendance record (optional edit)
    @PutMapping("/{id}")
    public ResponseEntity<AttendanceResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody AttendanceRequest request,
            Authentication authentication) {

        User user = getUserFromAuth(authentication);
        Attendance record = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        if (!record.getOwner().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        record.setVisitorName(request.getVisitorName());
        record.setVisitorEmail(request.getVisitorEmail());
        record.setPurpose(request.getPurpose());
        record.setStallVisited(request.getStallVisited());
        record.setCheckInTime(LocalTime.parse(request.getCheckInTime()));

        Attendance updated = attendanceRepository.save(record);
        return ResponseEntity.ok(convertToResponse(updated));
    }

    // ✅ Check out visitor (update only checkOutTime)
    @PutMapping("/{id}/checkout")
    public ResponseEntity<AttendanceResponse> checkOut(
            @PathVariable Long id,
            Authentication authentication) {

        User user = getUserFromAuth(authentication);
        Attendance record = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        if (!record.getOwner().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        record.setCheckOutTime(LocalTime.now());
        Attendance updated = attendanceRepository.save(record);
        return ResponseEntity.ok(convertToResponse(updated));
    }

    // ✅ Delete attendance record
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, Authentication authentication) {
        User user = getUserFromAuth(authentication);
        Attendance record = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        if (!record.getOwner().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        attendanceRepository.delete(record);
        return ResponseEntity.ok("Attendance record deleted successfully");
    }

    // ✅ Utility methods
    private User getUserFromAuth(Authentication authentication) {
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private AttendanceResponse convertToResponse(Attendance a) {
        AttendanceResponse r = new AttendanceResponse();
        r.setId(a.getId());
        r.setVisitorName(a.getVisitorName());
        r.setVisitorEmail(a.getVisitorEmail());
        r.setPurpose(a.getPurpose());
        r.setStallVisited(a.getStallVisited());
        r.setDate(a.getDate());
        r.setCheckInTime(a.getCheckInTime());
        r.setCheckOutTime(a.getCheckOutTime());
        r.setOwnerId(a.getOwner().getId());
        r.setCreatedAt(a.getCreatedAt());
        return r;
    }
//    @GetMapping("/attendance/stall/{stallId}/stats")
//    public ResponseEntity<AttendanceStatsDTO> getAttendanceStats(
//            @PathVariable Long stallId,
//            Authentication authentication) {
//        String username = authentication.getName();
//        AttendanceStatsDTO stats = attendanceService.getAttendanceStats(stallId, username);
//        return ResponseEntity.ok(stats);
//    }
}
