package com.example.smartevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.smartevent.dto.EventVisitorsDTO;
import com.example.smartevent.models.Event;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long>{
List<Event> findByStartDateAfter(LocalDate date);
    
    List<Event> findByEndDateBefore(LocalDate date);
    
    List<Event> findByStartDateBetween(LocalDate start, LocalDate end);
    
    @Query("""
    	    SELECT new com.example.smartevent.dto.EventVisitorsDTO(
    	        e.title,
    	        COUNT(q)
    	    )
    	    FROM Event e
    	    LEFT JOIN QRScan q ON q.stallId = e.id
    	    GROUP BY e.id, e.title
    	    ORDER BY COUNT(q) DESC
    	""")
    	List<EventVisitorsDTO> findVisitorCountsPerEvent();



}
