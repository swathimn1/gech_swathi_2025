package com.example.smartevent.service;

import com.example.smartevent.dto.EventDTO;
import com.example.smartevent.models.Event;
import com.example.smartevent.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class EventService {

	private final EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		super();
		this.eventRepository = eventRepository;
	}

	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	public Event getEventById(Long id) {
		return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
	}

	public Event saveEvent(Event event) {
		return eventRepository.save(event);
	}

	public EventDTO createEvent(EventDTO dto) {
	    Event event = new Event();
	    event.setTitle(dto.getTitle());
	    event.setDescription(dto.getDescription());
	    event.setLocation(dto.getLocation());
	    event.setStartDate(dto.getStartDate());
	    event.setEndDate(dto.getEndDate());
	    event.setCategory(dto.getCategory());
	    eventRepository.save(event);
	    dto.setId(event.getId());
	    return dto;
	}

	public EventDTO updateEvent(Long id, EventDTO dto) {
	    Event event = eventRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Event not found"));
	    event.setTitle(dto.getTitle());
	    event.setDescription(dto.getDescription());
	    event.setLocation(dto.getLocation());
	    event.setStartDate(dto.getStartDate());
	    event.setEndDate(dto.getEndDate());
	    event.setCategory(dto.getCategory());
	    eventRepository.save(event);
	    return dto;
	}



	private Event convertToEntity(EventDTO dto) {
	    Event event = new Event();

	    event.setTitle(dto.getTitle());
	    event.setDescription(dto.getDescription());
	    event.setLocation(dto.getLocation());

	    // Convert LocalDateTime → LocalDate
	    event.setStartDate(dto.getStartDate());
	    event.setEndDate(dto.getEndDate());

	    event.setCategory(dto.getCategory());
	    return event;
	}

	private void validateEventDates(EventDTO eventDTO) {
		if (eventDTO.getEndDate().isBefore(eventDTO.getStartDate())) {
			throw new RuntimeException("End date must be after start date");
		}
	}

	@Transactional
	public void deleteEvent(Long id) {
		if (!eventRepository.existsById(id)) {
			throw new RuntimeException("Event not found with id: " + id);
		}
		eventRepository.deleteById(id);
	}

}