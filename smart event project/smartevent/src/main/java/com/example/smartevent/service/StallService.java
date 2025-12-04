package com.example.smartevent.service;

import com.example.smartevent.dto.StallDTO;
import com.example.smartevent.dto.StallOwnerDashboardDTO;
import com.example.smartevent.dto.StallRequest;
import com.example.smartevent.dto.StallResponse;
import com.example.smartevent.models.Event;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.EventRepository;
import com.example.smartevent.repository.StallRepository;
import com.example.smartevent.repository.UserRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class  StallService {

    private final StallRepository stallRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;

    
   

	public StallService(StallRepository stallRepository, EventRepository eventRepository, UserRepository userRepository,
			EmailService emailService) {
		super();
		this.stallRepository = stallRepository;
		this.eventRepository = eventRepository;
		this.userRepository = userRepository;
		this.emailService = emailService;
	}


	public List<StallResponse> getAllStalls() {
        return stallRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    
    public List<StallResponse> getStallsByEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        return stallRepository.findAll()
                .stream()
                .filter(stall -> stall.getEvent() != null && stall.getEvent().equals(event))
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    public List<StallResponse> getStallsByOwner(Long ownerId) {
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        return stallRepository.findByOwner(owner)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    
    public StallResponse createStall(StallRequest request, Long eventId, Long ownerId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        Stall stall = new Stall();
        stall.setName(request.getName());
        stall.setLocation(request.getLocation());
        stall.setCategory(request.getCategory());
        stall.setCapacity(request.getCapacity());
        stall.setStatus(Stall.Status.valueOf(request.getStatus().toUpperCase()));
        stall.setEvent(event);
        stall.setOwner(owner);
        stall.setCreatedAt(LocalDateTime.now());
        stall.setUpdatedAt(LocalDateTime.now());

        Stall saved = stallRepository.save(stall);
        return mapToResponse(saved);
    }

   
    public StallResponse updateStall(Long id, StallRequest request) {
        Stall stall = stallRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stall not found"));

        stall.setName(request.getName());
        stall.setLocation(request.getLocation());
        stall.setCategory(request.getCategory());
        stall.setCapacity(request.getCapacity());
        stall.setStatus(Stall.Status.valueOf(request.getStatus().toUpperCase()));
        stall.setUpdatedAt(LocalDateTime.now());

        Stall updated = stallRepository.save(stall);
        return mapToResponse(updated);
    }

   
    public void deleteStall(Long id) {
        if (!stallRepository.existsById(id)) {
            throw new RuntimeException("Stall not found");
        }
        stallRepository.deleteById(id);
    }

    // ✅ Helper method to map Stall → StallResponse
    private StallResponse mapToResponse(Stall stall) {
        StallResponse response = new StallResponse();
        response.setId(stall.getId());
        response.setName(stall.getName());
        response.setLocation(stall.getLocation());
        response.setCategory(stall.getCategory());
        response.setCapacity(stall.getCapacity());
        response.setStatus(stall.getStatus().name());
        response.setCreatedAt(stall.getCreatedAt());
        response.setUpdatedAt(stall.getUpdatedAt());

        if (stall.getOwner() != null) {
            response.setOwnerId(stall.getOwner().getId());
           
        }

        return response;
    }
    public Stall approveStall(Long stallId) throws Exception {
        Stall stall = stallRepository.findById(stallId).orElseThrow();
        stall.setApproved(true);
        Stall saved = stallRepository.save(stall);

        emailService.sendEmail(
                stall.getOwner().getEmail(),
                "Your Stall Has Been Approved!",
                "stall-approved.html",
                new String[][]{
                        {"{{ownerName}}", stall.getOwner().getFullName()},
                        {"{{stallName}}", stall.getName()}
                }
        );

        return saved;
    }
//    public StallDTO getStallByIdAndOwner(Long id, String username) {
//        User owner = userRepository.findByUsername(username)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//        
//        Stall stall = stallRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Stall not found"));
//        
//        if (!stall.getOwner().getId().equals(owner.getId())) {
//            throw new UnauthorizedException("You don't have permission to access this stall");
//        }
//        
//        return convertToDTO(stall);
//    }
//    public StallOwnerDashboardDTO getOwnerDashboard(String username) {
//        User owner = userRepository.findByUsername(username)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//        
//        List<Stall> allStalls = stallRepository.findByOwnerId(owner.getId());
//        
//        long totalStalls = allStalls.size();
//        long approvedStalls = allStalls.stream().filter(s -> "APPROVED".equals(s.getStatus())).count();
//        long pendingStalls = allStalls.stream().filter(s -> "PENDING".equals(s.getStatus())).count();
//        long rejectedStalls = allStalls.stream().filter(s -> "REJECTED".equals(s.getStatus())).count();
//        
//        List<Long> stallIds = allStalls.stream().map(Stall::getId).collect(Collectors.toList());
//        
//        Long totalScans = stallIds.isEmpty() ? 0L : qrScanRepository.countByStallIdIn(stallIds);
//        Long totalVisitors = stallIds.isEmpty() ? 0L : qrScanRepository.countDistinctVisitorsByStallIdIn(stallIds);
//        Long pendingQueries = stallIds.isEmpty() ? 0L : queryRepository.countByStallIdInAndStatus(stallIds, "PENDING");
//        Long unreadNotifications = notificationService.getUnreadCount(username);
//        Double averageRating = stallIds.isEmpty() ? 0.0 : feedbackRepository.getAverageRatingByStallIdIn(stallIds);
//        
//        List<StallDTO> recentStalls = allStalls.stream()
//                .sorted((s1, s2) -> s2.getCreatedAt().compareTo(s1.getCreatedAt()))
//                .limit(5)
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//        
//        return StallOwnerDashboardDTO.builder()
//                .totalStalls(totalStalls)
//                .approvedStalls(approvedStalls)
//                .pendingStalls(pendingStalls)
//                .rejectedStalls(rejectedStalls)
//                .totalScans(totalScans)
//                .totalVisitors(totalVisitors)
//                .pendingQueries(pendingQueries)
//                .unreadNotifications(unreadNotifications)
//                .averageRating(averageRating != null ? averageRating : 0.0)
//                .recentStalls(recentStalls)
//                .build();
//    }


	
}
