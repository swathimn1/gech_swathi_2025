package com.example.smartevent.repository;

import com.example.smartevent.models.VisitorEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorEventRepository extends JpaRepository<VisitorEvent, Long> {
	long countByEventId(Long eventId);

    long countByVisitorId(Long visitorId);
}
