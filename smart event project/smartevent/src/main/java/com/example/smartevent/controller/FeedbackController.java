package com.example.smartevent.controller;
//
//import com.example.smartevent.models.Feedback;
//import com.example.smartevent.service.FeedbackService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartevent.dto.FeedbackDTO;
import com.example.smartevent.dto.FeedbackStatsDTO;
//
@RestController
//@RequestMapping( 
////"/api/feedback") 
public class FeedbackController {
//
//    private final FeedbackService feedbackService;
//
//    public FeedbackController(FeedbackService feedbackService) {
//        this.feedbackService = feedbackService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
//        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
//    }
//
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Feedback>> getFeedbackByUser(@PathVariable Long userId) {
//        return ResponseEntity.ok(feedbackService.getFeedbacksByUser(userId));
//    }
//
//    @PostMapping
//    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
//        Feedback saved = feedbackService.saveFeedback(feedback);
//        return ResponseEntity.ok(saved);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback updated) {
//        return ResponseEntity.ok(feedbackService.updateFeedback(id, updated));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
//        feedbackService.deleteFeedback(id);
//        return ResponseEntity.noContent().build();
//    }



//@GetMapping("/feedback/stall/{stallId}")
//    public ResponseEntity<List<FeedbackDTO>> getFeedbackByStall(
//            @PathVariable Long stallId,
//            Authentication authentication) {
//        String username = authentication.getName();
//        List<FeedbackDTO> feedback = feedbackService.getFeedbackByStallAndOwner(stallId, username);
//        return ResponseEntity.ok(feedback);
//    }
//@GetMapping("/feedback/stall/{stallId}/stats")
//public ResponseEntity<FeedbackStatsDTO> getFeedbackStats(
//        @PathVariable Long stallId,
//        Authentication authentication) {
//    String username = authentication.getName();
//    FeedbackStatsDTO stats = feedbackService.getFeedbackStats(stallId, username);
//    return ResponseEntity.ok(stats);
//}
}
