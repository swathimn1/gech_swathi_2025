package com.example.smartevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartevent.models.Event;

public interface EventRepository extends JpaRepository<Event,Long>{
	

}
