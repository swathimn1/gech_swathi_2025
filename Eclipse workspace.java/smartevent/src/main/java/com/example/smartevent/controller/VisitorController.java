package com.example.smartevent.controller;

import com.example.smartevent.models.Feedback;
import com.example.smartevent.models.Query;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.VisitorPoints;
import com.example.smartevent.service.VisitorPointsService;
import com.example.smartevent.repository.FeedbackRepository;
import com.example.smartevent.repository.QueryRepository;
import com.example.smartevent.repository.StallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitor")
@CrossOrigin(origins = "*")
public class VisitorController {

	@Autowired
	private VisitorPointsService visitorPointsService;

	@Autowired
	private StallRepository stallRepository;

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private QueryRepository queryRepository;

	// ✅ Scan stall QR (award points)
	@PostMapping("/scan/{visitorId}/{stallId}")
	public ResponseEntity<VisitorPoints> scanAndAwardPoints(@PathVariable Long visitorId, @PathVariable Long stallId,
			@RequestParam(defaultValue = "10") int points // Default: 10 points per scan
	) {
		VisitorPoints awarded = visitorPointsService.awardPoints(visitorId, stallId, points);
		return ResponseEntity.ok(awarded);
	}

	// ✅ Get total points earned by a visitor
	@GetMapping("/points/{visitorId}")
	public ResponseEntity<List<VisitorPoints>> getPointsByVisitor(@PathVariable Long visitorId) {
		List<VisitorPoints> points = visitorPointsService.getPointsByVisitor(visitorId);
		return ResponseEntity.ok(points);
	}

	// ✅ Get all stalls (for browsing)
	@GetMapping("/stalls")
	public ResponseEntity<List<Stall>> getAllStalls() {
		List<Stall> stalls = stallRepository.findAll();
		return ResponseEntity.ok(stalls);
	}

	// ✅ Submit feedback for a stall
	@PostMapping("/feedback/{stallId}")
	public ResponseEntity<Feedback> submitFeedback(@PathVariable Long stallId, @RequestBody Feedback feedback) {
		Stall stall = stallRepository.findById(stallId).orElseThrow(() -> new RuntimeException("Stall not found"));
		feedback.setStall(stall);
		Feedback savedFeedback = feedbackRepository.save(feedback);
		return ResponseEntity.ok(savedFeedback);
	}

	// ✅ Submit a query to a stall
	@PostMapping("/query/{stallId}")
	public ResponseEntity<Query> submitQuery(@PathVariable Long stallId, @RequestBody Query query) {
		Stall stall = stallRepository.findById(stallId).orElseThrow(() -> new RuntimeException("Stall not found"));
		query.setStall(stall);
		query.setResponse(false);
		Query savedQuery = queryRepository.save(query);
		return ResponseEntity.ok(savedQuery);
	}

	// ✅ View all queries submitted by a visitor (optional)
	@GetMapping("/queries/{visitorId}")
	public ResponseEntity<List<Query>> getQueriesByVisitor(@PathVariable Long visitorId) {
		List<Query> queries = queryRepository.findByVisitorId(visitorId);
		return ResponseEntity.ok(queries);
	}
}
