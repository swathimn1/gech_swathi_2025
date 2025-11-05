package com.example.smartevent.service;

import com.example.smartevent.models.Event;
import com.example.smartevent.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
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

	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}
}
