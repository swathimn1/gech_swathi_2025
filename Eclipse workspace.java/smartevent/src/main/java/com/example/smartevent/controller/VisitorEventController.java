package com.example.smartevent.controller;

import com.example.smartevent.dto.BookmarkRequest;
import com.example.smartevent.dto.EventDTO;
import com.example.smartevent.dto.VisitorEventDTO;
import com.example.smartevent.models.Event;
import com.example.smartevent.models.VisitorEvent;
import com.example.smartevent.service.EventService;
import com.example.smartevent.service.VisitorEventService;
import com.example.smartevent.service.VisitorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/visitor/events")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class VisitorEventController {

    private final EventService eventService;
    private final VisitorEventService visitorEventService;
    private final VisitorService visitorService;
    

    public VisitorEventController(EventService eventService, VisitorEventService visitorEventService,
			VisitorService visitorService) {
		super();
		this.eventService = eventService;
		this.visitorEventService = visitorEventService;
		this.visitorService = visitorService;
	}

	@GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        List<EventDTO> dtos = events.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(convertToDTO(event));
    }

    @PostMapping("/bookmark")
    public ResponseEntity<?> bookmarkEvent(@Valid @RequestBody BookmarkRequest request) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName();
            Long visitorId = visitorService.getVisitorIdByUsername(username);
            
            VisitorEvent saved = visitorEventService.bookmarkEvent(visitorId, request.getEventId());
            return ResponseEntity.ok(convertToVisitorEventDTO(saved));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/my-bookmarks")
    public ResponseEntity<List<VisitorEventDTO>> getMyBookmarks() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Long visitorId = visitorService.getVisitorIdByUsername(username);
        
        List<VisitorEvent> bookmarks = visitorEventService.getBookmarkedEventsByVisitorId(visitorId);
        List<VisitorEventDTO> dtos = bookmarks.stream()
                .map(this::convertToVisitorEventDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{eventId}/bookmark")
    public ResponseEntity<?> removeBookmark(@PathVariable Long eventId) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName();
            Long visitorId = visitorService.getVisitorIdByUsername(username);
            
            visitorEventService.removeBookmark(visitorId, eventId);
            return ResponseEntity.ok("Bookmark removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private EventDTO convertToDTO(Event event) {
        EventDTO dto = new EventDTO();
//        dto.setId(event.getId());
        dto.setId(event.getId());
        dto.setTitle(event.getTitle());
        dto.setDescription(event.getDescription());
        dto.setLocation(event.getLocation());
        dto.setStartDate(event.getStartDate());
        dto.setEndDate(event.getEndDate());
        dto.setCategory(event.getCategory());
        return dto;
    }

    private VisitorEventDTO convertToVisitorEventDTO(VisitorEvent ve) {
        VisitorEventDTO dto = new VisitorEventDTO();
        dto.setId(ve.getId());
        dto.setEventId(ve.getEvent().getId());
        dto.setTitle(ve.getEvent().getTitle());
        dto.setDescription(ve.getEvent().getDescription());
        dto.setLocation(ve.getEvent().getLocation());
        dto.setEventStartDate(ve.getEvent().getStartDate());
        dto.setCategory(ve.getEvent().getCategory());
        dto.setBookmarkedAt(ve.getCreatedAt());
        return dto;
    }
}