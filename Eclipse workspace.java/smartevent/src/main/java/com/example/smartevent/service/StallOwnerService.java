package com.example.smartevent.service;

import com.example.smartevent.dto.StallDTO;
import com.example.smartevent.exception.ResourceNotFoundException;
import com.example.smartevent.models.Event;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.EventRepository;
import com.example.smartevent.repository.StallRepository;
import com.example.smartevent.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StallOwnerService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final StallRepository stallRepository;
    

    // -------------------- CREATE A STALL ------------------------

    public StallOwnerService(UserRepository userRepository, EventRepository eventRepository,
			StallRepository stallRepository) {
		super();
		this.userRepository = userRepository;
		this.eventRepository = eventRepository;
		this.stallRepository = stallRepository;
	}

	public StallDTO createStall(String username, StallDTO stallDTO) {

        User owner = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Event event = eventRepository.findById(stallDTO.getEventId())
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        Stall stall = new Stall();
        stall.setName(stallDTO.getName());
        stall.setDescription(stallDTO.getDescription());
        stall.setCategory(stallDTO.getCategory());
        stall.setLocation(stallDTO.getLocation());
        stall.setImageUrls(stallDTO.getImageUrls());
        stall.setVideoUrl(stallDTO.getVideoUrl());
        stall.setQrCode(stallDTO.getQrCode());
        stall.setPointsPerVisit(stallDTO.getPointsPerVisit());
        stall.setEvent(event);
        stall.setOwner(owner);
        stall.setStatus(Stall.Status.PENDING);

        Stall saved = stallRepository.save(stall);
        return convertToDTO(saved);
    }

    // -------------------- GET STALLS OF OWNER --------------------

    public List<StallDTO> getMyStalls(String username) {

        User owner = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<Stall> stalls = stallRepository.findByOwnerId(owner.getId());

        return stalls.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // -------------------- GET ONE STALL --------------------

    public StallDTO getStall(Long id, String username) {

        Stall stall = stallRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stall not found"));

        if (!stall.getOwner().getUsername().equals(username)) {
            throw new ResourceNotFoundException("You do not own this stall");
        }

        return convertToDTO(stall);
    }

    // -------------------- UPDATE A STALL ------------------------

    public StallDTO updateStall(Long id, String username, StallDTO stallDTO) {

        Stall stall = stallRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stall not found"));

        if (!stall.getOwner().getUsername().equals(username)) {
            throw new ResourceNotFoundException("You do not own this stall");
        }

        stall.setName(stallDTO.getName());
        stall.setDescription(stallDTO.getDescription());
        stall.setCategory(stallDTO.getCategory());
        stall.setLocation(stallDTO.getLocation());
        stall.setImageUrls(stallDTO.getImageUrls());
        stall.setVideoUrl(stallDTO.getVideoUrl());
        stall.setPointsPerVisit(stallDTO.getPointsPerVisit());

        Stall updated = stallRepository.save(stall);
        return convertToDTO(updated);
    }

    // -------------------- DELETE A STALL ------------------------

    public void deleteStall(Long id, String username) {

        Stall stall = stallRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stall not found"));

        if (!stall.getOwner().getUsername().equals(username)) {
            throw new ResourceNotFoundException("You do not own this stall");
        }

        stallRepository.delete(stall);
    }

    // -------------------- DTO CONVERTER ------------------------

    private StallDTO convertToDTO(Stall s) {
        StallDTO dto = new StallDTO();

        dto.setId(s.getId());
        dto.setName(s.getName());
        dto.setDescription(s.getDescription());
        dto.setCategory(s.getCategory());
        dto.setLocation(s.getLocation());
        dto.setImageUrls(s.getImageUrls());
        dto.setVideoUrl(s.getVideoUrl());
        dto.setQrCode(s.getQrCode());
        dto.setPointsPerVisit(s.getPointsPerVisit());
        dto.setStatus(s.getStatus().name());
        dto.setCreatedAt(s.getCreatedAt());
        dto.setUpdatedAt(s.getUpdatedAt());

        if (s.getEvent() != null) {
            dto.setEventId(s.getEvent().getId());
            dto.setEventName(s.getEvent().getTitle());
        }

        if (s.getOwner() != null) {
            dto.setOwnerName(s.getOwner().getFullName());
            dto.setOwnerEmail(s.getOwner().getEmail());
        }

        return dto;
    }
}
