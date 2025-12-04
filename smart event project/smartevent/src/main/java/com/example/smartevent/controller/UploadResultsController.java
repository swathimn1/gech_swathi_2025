package com.example.smartevent.controller;

import com.example.smartevent.dto.UploadResultRequest;
import com.example.smartevent.dto.UploadResultResponse;
import com.example.smartevent.models.User;
import com.example.smartevent.models.UploadResults;
import com.example.smartevent.repository.UploadResultRepository;
import com.example.smartevent.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stall-owner/upload-results")
@RequiredArgsConstructor
public class UploadResultsController {

    private final UploadResultRepository uploadResultRepository;
    public UploadResultsController(UploadResultRepository uploadResultRepository, UserRepository userRepository) {
		super();
		this.uploadResultRepository = uploadResultRepository;
		this.userRepository = userRepository;
	}

	private final UserRepository userRepository;

    // ✅ Get all results uploaded by the logged-in stall owner
    @GetMapping
    public ResponseEntity<List<UploadResultResponse>> getAllResults(Authentication authentication) {
        User user = getUserFromAuth(authentication);
        List<UploadResults> results = uploadResultRepository.findByOwnerId(user.getId());
        return ResponseEntity.ok(
                results.stream().map(this::convertToResponse).collect(Collectors.toList())
        );
    }

    // ✅ Create new result (Upload)
    @PostMapping
    public ResponseEntity<UploadResultResponse> createResult(
            @Valid @RequestBody UploadResultRequest request,
            Authentication authentication) {

        User user = getUserFromAuth(authentication);

        UploadResults result = new UploadResults();
        result.setTitle(request.getTitle());
        result.setDate(request.getDate());
        result.setDescription(request.getDescription());
        result.setPerformance(request.getPerformance());
        result.setRevenue(request.getRevenue());
        result.setOwner(user);

        UploadResults saved = uploadResultRepository.save(result);
        return ResponseEntity.ok(convertToResponse(saved));
    }

    // ✅ Update result
    @PutMapping("/{id}")
    public ResponseEntity<UploadResultResponse> updateResult(
            @PathVariable Long id,
            @Valid @RequestBody UploadResultRequest request,
            Authentication authentication) {

        User user = getUserFromAuth(authentication);
        UploadResults result = uploadResultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));

        if (!result.getOwner().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        result.setTitle(request.getTitle());
        result.setDate(request.getDate());
        result.setDescription(request.getDescription());
        result.setPerformance(request.getPerformance());
        result.setRevenue(request.getRevenue());

        UploadResults updated = uploadResultRepository.save(result);
        return ResponseEntity.ok(convertToResponse(updated));
    }

    // ✅ Delete result
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResult(@PathVariable Long id, Authentication authentication) {
        User user = getUserFromAuth(authentication);
        UploadResults result = uploadResultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));

        if (!result.getOwner().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        uploadResultRepository.delete(result);
        return ResponseEntity.ok("Result deleted successfully");
    }

    // ✅ Utility methods
    private User getUserFromAuth(Authentication authentication) {
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private UploadResultResponse convertToResponse(UploadResults result) {
        UploadResultResponse response = new UploadResultResponse();
        response.setId(result.getId());
        response.setTitle(result.getTitle());
        response.setDate(result.getDate());
        response.setDescription(result.getDescription());
        response.setPerformance(result.getPerformance());
        response.setRevenue(result.getRevenue());
        response.setOwnerId(result.getOwner().getId());
        response.setUploadedAt(result.getUploadedAt());
        return response;
    }
}
