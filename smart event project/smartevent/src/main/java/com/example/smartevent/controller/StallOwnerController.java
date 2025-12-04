package com.example.smartevent.controller;

import com.example.smartevent.dto.*;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.StallRepository;
import com.example.smartevent.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stall-owner/stalls")
@RequiredArgsConstructor
public class StallOwnerController {

    private final StallRepository stallRepository;
    private final UserRepository userRepository;

    public StallOwnerController(StallRepository stallRepository, UserRepository userRepository) {
		super();
		this.stallRepository = stallRepository;
		this.userRepository = userRepository;
	}

	@GetMapping
    public ResponseEntity<List<StallResponse>> getAllStalls(Authentication authentication) {
        User user = getUserFromAuth(authentication);
        List<Stall> stalls = stallRepository.findByOwnerId(user.getId());
        return ResponseEntity.ok(stalls.stream().map(this::convertToResponse).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StallResponse> getStallById(@PathVariable Long id, Authentication authentication) {
        User user = getUserFromAuth(authentication);
        Stall stall = stallRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stall not found"));

        if (!stall.getOwner().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        return ResponseEntity.ok(convertToResponse(stall));
    }

    @PostMapping
    public ResponseEntity<StallResponse> createStall(@Valid @RequestBody StallRequest request, Authentication authentication) {
        User user = getUserFromAuth(authentication);

        Stall stall = new Stall();
        stall.setName(request.getName());
        stall.setLocation(request.getLocation());
        stall.setCategory(request.getCategory());
        stall.setCapacity(request.getCapacity());
        stall.setStatus(request.getStatus() != null ?
                Stall.Status.valueOf(request.getStatus().toUpperCase()) : Stall.Status.AVAILABLE);
        stall.setOwner(user);

        Stall savedStall = stallRepository.save(stall);
        return ResponseEntity.ok(convertToResponse(savedStall));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StallResponse> updateStall(@PathVariable Long id, @Valid @RequestBody StallRequest request,
                                                     Authentication authentication) {
        User user = getUserFromAuth(authentication);
        Stall stall = stallRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stall not found"));

        if (!stall.getOwner().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        stall.setName(request.getName());
        stall.setLocation(request.getLocation());
        stall.setCategory(request.getCategory());
        stall.setCapacity(request.getCapacity());
        if (request.getStatus() != null) {
            stall.setStatus(Stall.Status.valueOf(request.getStatus().toUpperCase()));
        }

        Stall updatedStall = stallRepository.save(stall);
        return ResponseEntity.ok(convertToResponse(updatedStall));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStall(@PathVariable Long id, Authentication authentication) {
        User user = getUserFromAuth(authentication);
        Stall stall = stallRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stall not found"));

        if (!stall.getOwner().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        stallRepository.delete(stall);
        return ResponseEntity.ok().body("Stall deleted successfully");
    }

    private User getUserFromAuth(Authentication authentication) {
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private StallResponse convertToResponse(Stall stall) {
        StallResponse response = new StallResponse();
        response.setId(stall.getId());
        response.setName(stall.getName());
        response.setLocation(stall.getLocation());
        response.setCategory(stall.getCategory());
        response.setCapacity(stall.getCapacity());
        response.setStatus(stall.getStatus().name());
        response.setOwnerId(stall.getOwner().getId());
        response.setCreatedAt(stall.getCreatedAt());
        response.setUpdatedAt(stall.getUpdatedAt());
        return response;
    }
//    @PostMapping("/{id}/upload-images")
//    public ResponseEntity<Map<String, String>> uploadStallImages(
//            @PathVariable Long id,
//            @RequestParam("images") List<MultipartFile> images,
//            Authentication authentication) {
//        String username = authentication.getName();
//        String imageUrls = stallService.uploadStallImages(id, images, username);
//        return ResponseEntity.ok(Map.of("imageUrls", imageUrls));
//    }

    /**
     * Get stall statistics/dashboard data
     */
//    @GetMapping("/{id}/stats")
//    public ResponseEntity<StallStatsDTO> getStallStats(
//            @PathVariable Long id,
//            Authentication authentication) {
//        String username = authentication.getName();
//        StallStatsDTO stats = stallService.getStallStats(id, username);
//        return ResponseEntity.ok(stats);
//    }
    
}
