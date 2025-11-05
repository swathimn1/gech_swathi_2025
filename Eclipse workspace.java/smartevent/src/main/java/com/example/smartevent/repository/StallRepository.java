package com.example.smartevent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartevent.models.Event;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;

public interface StallRepository extends JpaRepository<Stall, Long> {
	List<Stall> findByEvent(Event event);

	List<Stall> findByOwner(User owner);

}
