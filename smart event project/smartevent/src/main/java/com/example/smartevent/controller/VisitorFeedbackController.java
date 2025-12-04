package com.example.smartevent.controller;

import com.example.smartevent.dto.FeedbackDTO;
import com.example.smartevent.models.Feedback;
import com.example.smartevent.service.FeedbackService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/visitor/feedback","/feedback"})
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class VisitorFeedbackController {

    private final FeedbackService feedbackService;

    public VisitorFeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<FeedbackDTO> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody FeedbackDTO dto) {
        Feedback saved = feedbackService.saveFeedback(dto);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> update(@PathVariable Long id, @RequestBody FeedbackDTO dto) {
        Feedback updated = feedbackService.updateFeedback(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public List<Feedback> getFeedbacksByUser(@PathVariable Long userId) {
        return feedbackService.getFeedbacksByUser(userId);
    }
    
}
