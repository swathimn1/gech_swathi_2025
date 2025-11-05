package com.example.smartevent.service;

import com.example.smartevent.models.Feedback;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.FeedbackRepository;
import com.example.smartevent.repository.StallRepository;
import com.example.smartevent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

	private final FeedbackRepository feedbackRepository;
	private final StallRepository stallRepository;
	private final UserRepository userRepository;

	public FeedbackService(FeedbackRepository feedbackRepository, StallRepository stallRepository,
			UserRepository userRepository) {
		super();
		this.feedbackRepository = feedbackRepository;
		this.stallRepository = stallRepository;
		this.userRepository = userRepository;
	}

	public Feedback saveFeedback(Long stallId, Long visitorId, Feedback feedback) {
		Stall stall = stallRepository.findById(stallId).orElseThrow(() -> new RuntimeException("Stall not found"));
		User visitor = userRepository.findById(visitorId).orElseThrow(() -> new RuntimeException("Visitor not found"));

		feedback.setStall(stall);
		feedback.setVisitor(visitor);

		return feedbackRepository.save(feedback);
	}

	public List<Feedback> getFeedbackByStall(Long stallId) {
		Stall stall = stallRepository.findById(stallId).orElseThrow(() -> new RuntimeException("Stall not found"));
		return feedbackRepository.findByStall(stall);
	}
}
