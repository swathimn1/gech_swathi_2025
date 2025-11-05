package com.example.smartevent.controller;

import com.example.smartevent.models.Event;
import com.example.smartevent.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend
public class EventController {

	private final EventService eventService;

	public EventController(EventService eventService) {
		super();
		this.eventService = eventService;
	}

	// ✅ Get all events
	@GetMapping
	public ResponseEntity<List<Event>> getAllEvents() {
		return ResponseEntity.ok(eventService.getAllEvents());
	}

	// ✅ Get event by ID
	@GetMapping("/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable Long id) {
		Event event = eventService.getEventById(id);
		return ResponseEntity.ok(event);
	}

	// ✅ Add new event
	@PostMapping
	public ResponseEntity<Event> createEvent(@RequestBody Event event) {
		Event savedEvent = eventService.saveEvent(event);
		return ResponseEntity.ok(savedEvent);
	}

	// ✅ Update event
	@PutMapping("/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
		Event existingEvent = eventService.getEventById(id);

		existingEvent.setName(eventDetails.getName());
		existingEvent.setDescription(eventDetails.getDescription());
		existingEvent.setLocation(eventDetails.getLocation());
		existingEvent.setStartDate(eventDetails.getStartDate());
		existingEvent.setEndDate(eventDetails.getEndDate());

		Event updatedEvent = eventService.saveEvent(existingEvent);
		return ResponseEntity.ok(updatedEvent);
	}

	// ✅ Delete event
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
		eventService.deleteEvent(id);
		return ResponseEntity.ok("Event deleted successfully!");
	}
}
