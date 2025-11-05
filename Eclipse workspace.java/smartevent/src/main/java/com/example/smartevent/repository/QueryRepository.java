package com.example.smartevent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartevent.models.Query;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;

public interface QueryRepository extends JpaRepository<Query, Long> {
	 List<Query> findByStallId(Stall stall);

	 List<Query> findByVisitorId(Long visitorId);

	List<Query> findByStallId(Long stall);

}
