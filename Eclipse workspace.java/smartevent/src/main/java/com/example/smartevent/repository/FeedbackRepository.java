package com.example.smartevent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartevent.models.Feedback;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	 List<Feedback> findByStallId(Long stallId);

	List<Feedback> findByVisitor(User visitor);

}
