package com.example.smartevent.service;

import com.example.smartevent.dto.AnalyticsDTO;
import com.example.smartevent.dto.EventVisitorsDTO;
import com.example.smartevent.dto.StallRatingDTO;
import com.example.smartevent.dto.StallScanDTO;
import com.example.smartevent.models.Event;
import com.example.smartevent.models.Stall;
import com.example.smartevent.repository.EventRepository;
import com.example.smartevent.repository.FeedbackRepository;
import com.example.smartevent.repository.QRScanRepository;
import com.example.smartevent.repository.StallRepository;
import com.example.smartevent.repository.UserRepository;
import com.example.smartevent.repository.VisitorEventRepository;
import com.example.smartevent.repository.VisitorEventRepository;
import com.example.smartevent.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class  AnalyticsService {

    private final EventRepository eventRepository;
    private final StallRepository stallRepository;
    private final VisitorEventRepository visitorRepository; // counts visitors
    private final QRScanRepository qrScanRepository;   // counts scans
    private final FeedbackRepository feedbackRepository;
    

    public AnalyticsService(EventRepository eventRepository, StallRepository stallRepository,
			VisitorEventRepository visitorRepository, QRScanRepository qrScanRepository,
			FeedbackRepository feedbackRepository) {
		super();
		this.eventRepository = eventRepository;
		this.stallRepository = stallRepository;
		this.visitorRepository = visitorRepository;
		this.qrScanRepository = qrScanRepository;
		this.feedbackRepository = feedbackRepository;
	}


	/**
     * Gather analytics data. Marked transactional(readOnly) to ensure consistent reads and optimized queries.
     */
    
    @Transactional(readOnly = true)
    public AnalyticsDTO getAnalytics() {
        AnalyticsDTO dto = new AnalyticsDTO();

        // Summary counts
        dto.setTotalEvents(eventRepository.count());
        dto.setTotalStalls(stallRepository.count());
        dto.setTotalVisitors(visitorRepository.count());
        dto.setTotalScans(qrScanRepository.count());

        // Visitors per event (efficient approach: repository should provide counts; fallback to visitorRepository.countByEventId)
        List<Event> events = eventRepository.findAll();

        List<EventVisitorsDTO> visitorsPerEvent = events.stream()
                .map(event -> {
                    long visitors = visitorRepository.countByEventId(event.getId());
                    return new EventVisitorsDTO(event.getTitle(), visitors);
                })
                .sorted(Comparator.comparingLong(EventVisitorsDTO::getVisitors).reversed())
                .collect(Collectors.toList());

        dto.setVisitorsPerEvent(visitorsPerEvent);

        // Scans per stall
        List<Stall> stalls = stallRepository.findAll();

        List<StallScanDTO> scansPerStall = stalls.stream()
                .map(stall -> {
                    long scans = qrScanRepository.countByStallId(stall.getId());
                    return new StallScanDTO(stall.getName(), scans);
                })
                .sorted(Comparator.comparingLong(StallScanDTO::getScans).reversed())
                .collect(Collectors.toList());

        dto.setScansPerStall(scansPerStall);

        // Average rating per stall (feedbackRepo query returns 0 if no feedback)
        List<StallRatingDTO> avgRatings = stalls.stream()
                .map(stall -> {
                    double avg = feedbackRepository.averageRatingByStallId(stall.getId());
                    return new StallRatingDTO(stall.getName(), Math.round(avg * 100.0) / 100.0);
                })
                .sorted(Comparator.comparingDouble(StallRatingDTO::getRating).reversed())
                .collect(Collectors.toList());

        dto.setAverageRatings(avgRatings);

        return dto;
    }
    public List<EventVisitorsDTO> getVisitorsPerEvent() {
        return eventRepository.findVisitorCountsPerEvent();
    }

    public List<StallScanDTO> getScanCountsPerStall() {
        return stallRepository.findScanCountsPerStall();
    }

    public List<StallRatingDTO> getAvgRatingsPerStall() {
        return stallRepository.findAvgRatingPerStall();
    }
}
