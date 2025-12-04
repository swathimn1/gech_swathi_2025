package com.example.smartevent.service;

import com.example.smartevent.models.Event;
import com.example.smartevent.models.VisitorEvent;
import com.example.smartevent.repository.EventRepository;
import com.example.smartevent.repository.VisitorEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorEventService {

    @Autowired
    private VisitorEventRepository visitorEventRepository;

    @Autowired
    private EventRepository eventRepository;

    // ✅ Get all saved/bookmarked events
    public List<VisitorEvent> getAllEvents() {
        return visitorEventRepository.findAll();
    }

    // ✅ Get saved event by ID
    public VisitorEvent getEventById(Long id) {
        return visitorEventRepository.findById(id).orElse(null);
    }

    // ✅ Save/bookmark event for a visitor
    public VisitorEvent createEvent(Long visitorId, Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        VisitorEvent ve = new VisitorEvent();
        ve.setVisitorId(visitorId);
        ve.setEvent(event);

        return visitorEventRepository.save(ve);
    }

    // ✅ Update saved event (rarely needed, but included)
    public VisitorEvent updateEvent(Long id, Long visitorId, Long eventId) {
        return visitorEventRepository.findById(id)
                .map(saved -> {
                    saved.setVisitorId(visitorId);

                    Event event = eventRepository.findById(eventId)
                            .orElseThrow(() -> new RuntimeException("Event not found"));

                    saved.setEvent(event);
                    return visitorEventRepository.save(saved);
                })
                .orElse(null);
    }

    // ✅ Delete saved event entry
    public void deleteEvent(Long id) {
        visitorEventRepository.deleteById(id);
    }
}
