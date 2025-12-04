package com.example.smartevent.repository;

import com.example.smartevent.dto.StallRatingDTO;
import com.example.smartevent.dto.StallScanDTO;
import com.example.smartevent.models.Event;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StallRepository extends JpaRepository<Stall, Long> {
    
    List<Stall> findByOwner(User owner);
    
    List<Stall> findByOwnerId(Long ownerId);
    
    List<Stall> findByStatus(Stall.Status status);
    
    List<Stall> findByCategory(String category);
    
    List<Stall> findByLocation(String location);
    // ✅ Fetch all stalls for a specific event
    List<Stall> findByEvent(Event event);

    // ✅ Fetch all stalls for a specific event by ID
    List<Stall> findByEventId(Long eventId);

    // ✅ Fetch stalls by event and owner
    List<Stall> findByEventAndOwner(Event event, User owner);
    List<Stall> findByNameContainingIgnoreCase(String name);
  

    @Query("""
    	    SELECT new com.example.smartevent.dto.StallScanDTO(
    	        s.name,
    	        COUNT(q)
    	    )
    	    FROM Stall s
    	    LEFT JOIN QRScan q ON q.stallId = s.id
    	    GROUP BY s.id, s.name
    	    ORDER BY COUNT(q) DESC
    	""")
    	List<StallScanDTO> findScanCountsPerStall();

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



	

	
