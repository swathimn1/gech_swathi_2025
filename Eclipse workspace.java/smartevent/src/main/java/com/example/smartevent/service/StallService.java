package com.example.smartevent.service;

import com.example.smartevent.models.*;
import com.example.smartevent.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StallService {

    private final StallRepository stallRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    

    public StallService(StallRepository stallRepository, EventRepository eventRepository,
			UserRepository userRepository) {
		super();
		this.stallRepository = stallRepository;
		this.eventRepository = eventRepository;
		this.userRepository = userRepository;
	}

	public List<Stall> getAllStalls() {
        return stallRepository.findAll();
    }

    public List<Stall> getStallsByEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        return stallRepository.findByEvent(event);
    }

    public List<Stall> getStallsByOwner(Long ownerId) {
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        return stallRepository.findByOwner(owner);
    }

    public Stall saveStall(Stall stall) {
        return stallRepository.save(stall);
    }

    public void deleteStall(Long id) {
        stallRepository.deleteById(id);
    }
}

