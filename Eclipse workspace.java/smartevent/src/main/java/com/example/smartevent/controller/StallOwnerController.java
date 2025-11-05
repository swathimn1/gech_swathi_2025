package com.example.smartevent.controller;

import com.example.smartevent.models.Feedback;
import com.example.smartevent.models.Query;
import com.example.smartevent.models.Stall;
import com.example.smartevent.service.StallService;
import com.example.smartevent.repository.FeedbackRepository;
import com.example.smartevent.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stallowner")
@CrossOrigin(origins = "*")
public class StallOwnerController {

	@Autowired
	private StallService stallService;

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private QueryRepository queryRepository;

	// ✅ Create a new stall
	@PostMapping("/stalls")
	public ResponseEntity<Stall> createStall(@RequestBody Stall stall) {
		Stall saved = stallService.saveStall(stall);
		return ResponseEntity.ok(saved);
	}

	// ✅ Get all stalls for a specific owner
	@GetMapping("/stalls/{ownerId}")
	public ResponseEntity<List<Stall>> getStallsByOwner(@PathVariable Long ownerId) {
		List<Stall> stalls = stallService.getStallsByOwner(ownerId);
		return ResponseEntity.ok(stalls);
	}

	// ✅ Get feedback for a specific stall
	@GetMapping("/feedback/{stallId}")
	public ResponseEntity<List<Feedback>> getFeedbackByStall(@PathVariable Long stallId) {
		List<Feedback> feedbackList = feedbackRepository.findByStallId(stallId);
		return ResponseEntity.ok(feedbackList);
	}

	// ✅ Get all queries for a specific stall
	@GetMapping("/queries/{stallId}")
	public ResponseEntity<List<Query>> getQueriesByStall(@PathVariable Long stallId) {
		List<Query> queries = queryRepository.findByStallId(stallId);
		return ResponseEntity.ok(queries);
	}

	// ✅ Reply to a visitor query
	@PostMapping("/queries/{queryId}/reply")
	public ResponseEntity<Query> replyToQuery(@PathVariable Long queryId, @RequestBody Query reply) {
		Query existingQuery = queryRepository.findById(queryId)
				.orElseThrow(() -> new RuntimeException("Query not found"));

		existingQuery.setResponse(reply.getResponse());
		existingQuery.setResponse(true);

		Query updatedQuery = queryRepository.save(existingQuery);
		return ResponseEntity.ok(updatedQuery);
	}

	// ✅ Delete stall (optional for owner)
	@DeleteMapping("/stalls/{stallId}")
	public ResponseEntity<String> deleteStall(@PathVariable Long stallId) {
		stallService.deleteStall(stallId);
		return ResponseEntity.ok("Stall deleted successfully");
	}
}
