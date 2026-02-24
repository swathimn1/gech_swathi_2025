package com.example.smartevent.service;

import com.example.smartevent.models.Event;
import com.example.smartevent.models.VisitorEvent;
import com.example.smartevent.repository.EventRepository;
import com.example.smartevent.repository.VisitorEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorEventService {
    
    private final VisitorEventRepository visitorEventRepository;
    private final EventRepository eventRepository;
    
    
    public VisitorEventService(VisitorEventRepository visitorEventRepository, EventRepository eventRepository) {
		super();
		this.visitorEventRepository = visitorEventRepository;
		this.eventRepository = eventRepository;
	}

    @Transactional
    public VisitorEvent bookmarkEvent(Long visitorId, Long eventId) {
        // Check if already bookmarked
        if (visitorEventRepository.existsByVisitorIdAndEventId(visitorId, eventId)) {
            throw new IllegalArgumentException("Event already bookmarked");
        }
        
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found with ID: " + eventId));
        
        // Create VisitorEvent without builder
        VisitorEvent visitorEvent = new VisitorEvent();
        visitorEvent.setVisitorId(visitorId);
        visitorEvent.setEvent(event);
        visitorEvent.setCreatedAt(LocalDateTime.now());
        
        return visitorEventRepository.save(visitorEvent);
    }
    
    public List<VisitorEvent> getBookmarkedEventsByVisitorId(Long visitorId) {
        return visitorEventRepository.findByVisitorId(visitorId);
    }
    
    @Transactional
    public void removeBookmark(Long visitorId, Long eventId) {
        VisitorEvent bookmark = visitorEventRepository.findByVisitorIdAndEventId(visitorId, eventId)
                .orElseThrow(() -> new IllegalArgumentException("Bookmark not found"));
        visitorEventRepository.delete(bookmark);
    }
    
    public boolean isEventBookmarked(Long visitorId, Long eventId) {
        return visitorEventRepository.existsByVisitorIdAndEventId(visitorId, eventId);
    }
    
    // Get all bookmarked events (for admin)
    public List<VisitorEvent> getAllBookmarkedEvents() {
        return visitorEventRepository.findAll();
    }

	
}