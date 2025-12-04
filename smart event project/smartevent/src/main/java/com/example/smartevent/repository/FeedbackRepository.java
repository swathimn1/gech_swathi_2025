package com.example.smartevent.repository;

import com.example.smartevent.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByUser_Id(Long userId);
    long countByStallId(Long stallId);
    List<Feedback> findByStallId(Long stallId);

    @Query("SELECT COALESCE(AVG(f.rating), 0) FROM Feedback f WHERE f.stallId = :stallId")
    double averageRatingByStallId(Long stallId);
	Double getAverageRatingByStallId(Long id);
	Double getAverageRatingByStallIdIn(List<Long> stallIds);
}
