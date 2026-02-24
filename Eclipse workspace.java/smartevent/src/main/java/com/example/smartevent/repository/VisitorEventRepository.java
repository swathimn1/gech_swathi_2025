package com.example.smartevent.repository;

import com.example.smartevent.models.VisitorEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitorEventRepository extends JpaRepository<VisitorEvent, Long> {
    
    // Check if a visitor has already bookmarked an event
    boolean existsByVisitorIdAndEventId(Long visitorId, Long eventId);
    
    // Find all bookmarks for a specific visitor
    List<VisitorEvent> findByVisitorId(Long visitorId);
    
    // Find specific bookmark by visitor and event
    Optional<VisitorEvent> findByVisitorIdAndEventId(Long visitorId, Long eventId);
    
    // Find bookmarks for a specific event
    List<VisitorEvent> findByEventId(Long eventId);
    
    // Count bookmarks for a specific event
    Long countByEventId(Long eventId);
    
    // Count bookmarks by visitor
    Long countByVisitorId(Long visitorId);
    
    // Delete bookmark by visitor and event
    void deleteByVisitorIdAndEventId(Long visitorId, Long eventId);
}