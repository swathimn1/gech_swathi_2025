package com.example.smartevent.controller;

import com.example.smartevent.dto.VisitorEventDTO;
import com.example.smartevent.dto.VisitorEventRequest;
import com.example.smartevent.models.VisitorEvent;
import com.example.smartevent.service.VisitorEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitor/events")
@CrossOrigin(origins = "http://localhost:5173")
public class VisitorEventController {

    @Autowired
    private VisitorEventService visitorEventService;

    @PostMapping
    public ResponseEntity<VisitorEventDTO> createEvent(@RequestBody VisitorEventRequest request) {
        try {
            VisitorEvent saved = visitorEventService.createEvent(request.getVisitorId(), request.getEventId());
            return ResponseEntity.ok(mapToDTO(saved));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<VisitorEventDTO>> getAllEvents() {
        List<VisitorEvent> list = visitorEventService.getAllEvents();
        List<VisitorEventDTO> dtos = list.stream().map(this::mapToDTO).toList();
        return ResponseEntity.ok(dtos);
    }

    private VisitorEventDTO mapToDTO(VisitorEvent ve) {
        VisitorEventDTO dto = new VisitorEventDTO();
        dto.setId(ve.getId());
        dto.setTitle(ve.getEvent().getTitle());
        dto.setDate(ve.getEvent().getStartDate() != null ? ve.getEvent().getStartDate().toString() : "N/A");
        dto.setTime("N/A");
        dto.setLocation(ve.getEvent().getLocation());
        dto.setDescription(ve.getEvent().getDescription());
        dto.setCategory(ve.getEvent().getCategory() != null ? ve.getEvent().getCategory() : "N/A");
        return dto;
    }
}
