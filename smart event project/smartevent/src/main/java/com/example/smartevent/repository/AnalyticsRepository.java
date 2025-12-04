package com.example.smartevent.repository;

import com.example.smartevent.dto.EventVisitorsDTO;
import com.example.smartevent.dto.StallScanDTO;
import com.example.smartevent.dto.StallRatingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.smartevent.models.Event;
import com.example.smartevent.models.Stall;
import java.util.List;

@Repository
public interface AnalyticsRepository extends JpaRepository<Event, Long> {

    // ✅ Event Visitor Count (uses VisitorEvent)
    @Query("""
        SELECT new com.example.smartevent.dto.EventVisitorsDTO(
            e.title,
            COUNT(ve.id)
        )
        FROM Event e
        LEFT JOIN VisitorEvent ve ON ve.event.id = e.id
        GROUP BY e.id, e.title
        ORDER BY COUNT(ve.id) DESC
    """)
    List<EventVisitorsDTO> findVisitorCountsPerEvent();


    // ✅ Stall Scan Count (uses QRScan.stallId)
    @Query("""
        SELECT new com.example.smartevent.dto.StallScanDTO(
            s.name,
            COUNT(q.id)
        )
        FROM Stall s
        LEFT JOIN QRScan q ON q.stallId = s.id
        GROUP BY s.id, s.name
        ORDER BY COUNT(q.id) DESC
    """)
    List<StallScanDTO> findScanCountsPerStall();


    // ✅ Stall Rating (uses Feedback.stallId)
    @Query("""
        SELECT new com.example.smartevent.dto.StallRatingDTO(
            s.name,
            COALESCE(AVG(f.rating), 0)
        )
        FROM Stall s
        LEFT JOIN Feedback f ON f.stallId = s.id
        GROUP BY s.id, s.name
        ORDER BY AVG(f.rating) DESC
    """)
    List<StallRatingDTO> findAvgRatingPerStall();

}
