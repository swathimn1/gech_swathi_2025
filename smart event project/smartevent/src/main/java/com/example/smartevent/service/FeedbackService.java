package com.example.smartevent.service;

import com.example.smartevent.dto.FeedbackDTO;
import com.example.smartevent.models.Feedback;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.FeedbackRepository;
import com.example.smartevent.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;

    public FeedbackService(FeedbackRepository feedbackRepository,
                           UserRepository userRepository) {
        this.feedbackRepository = feedbackRepository;
        this.userRepository = userRepository;
    }

    // -------------------------------------------
    // Convert Entity → DTO
    // -------------------------------------------
    private FeedbackDTO toDTO(Feedback f) {
        FeedbackDTO dto = new FeedbackDTO();
        dto.setId(f.getId());
        dto.setRating(f.getRating());
        dto.setComments(f.getComments());
        dto.setCategory(f.getCategory());
        dto.setStallName(f.getStallName());
        dto.setVisitDate(f.getVisitDate());
        dto.setUserId(f.getUser().getId());
        return dto;
    }

    // -------------------------------------------
    // Convert DTO → Entity
    // -------------------------------------------
    private Feedback toEntity(FeedbackDTO dto) {
        Feedback feedback = new Feedback();

        if (dto.getId() != null) {
            feedback.setId(dto.getId());
        }

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        feedback.setUser(user);
        feedback.setRating(dto.getRating());
        feedback.setComments(dto.getComments());
        feedback.setCategory(dto.getCategory());
        feedback.setStallName(dto.getStallName());
        feedback.setVisitDate(dto.getVisitDate());

        return feedback;
    }

    // -------------------------------------------
    // Get all
    // -------------------------------------------
    public List<FeedbackDTO> getAllFeedbacks() {
        return feedbackRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // -------------------------------------------
    // Save new feedback
    // -------------------------------------------
    @Transactional
    public Feedback saveFeedback(FeedbackDTO dto) {
        Feedback feedback = toEntity(dto);
        return feedbackRepository.save(feedback);
    }

    // -------------------------------------------
    // Update feedback
    // -------------------------------------------
    public Feedback updateFeedback(Long id, FeedbackDTO dto) {

        Feedback existing = feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setUser(user);
        existing.setRating(dto.getRating());
        existing.setComments(dto.getComments());
        existing.setCategory(dto.getCategory());
        existing.setStallName(dto.getStallName());
        existing.setVisitDate(dto.getVisitDate());

        return feedbackRepository.save(existing);
    }

    // -------------------------------------------
    // Delete feedback
    // -------------------------------------------
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    // -------------------------------------------
    // Get feedbacks by user
    // -------------------------------------------
    public List<Feedback> getFeedbacksByUser(Long userId) {
        return feedbackRepository.findByUser_Id(userId);
    }
}
