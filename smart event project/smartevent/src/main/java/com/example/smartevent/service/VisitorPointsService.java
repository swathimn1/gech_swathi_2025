package com.example.smartevent.service;

import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;
import com.example.smartevent.models.VisitorPoints;
import com.example.smartevent.repository.StallRepository;
import com.example.smartevent.repository.UserRepository;
import com.example.smartevent.repository.VisitorPointsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorPointsService {

    private final VisitorPointsRepository visitorPointsRepository;
    private final UserRepository userRepository;
    private final StallRepository stallRepository;
    

    public VisitorPointsService(VisitorPointsRepository visitorPointsRepository, UserRepository userRepository,
			StallRepository stallRepository) {
		super();
		this.visitorPointsRepository = visitorPointsRepository;
		this.userRepository = userRepository;
		this.stallRepository = stallRepository;
	}

	// ✅ Award points to a visitor for scanning a stall
    public VisitorPoints awardPoints(Long visitorId, Long stallId, int points) {
        User visitor = userRepository.findById(visitorId)
            .orElseThrow(() -> new RuntimeException("Visitor not found"));

        Stall stall = stallRepository.findById(stallId)
            .orElseThrow(() -> new RuntimeException("Stall not found"));

        VisitorPoints visitorPoints = visitorPointsRepository.findByVisitorAndStall(visitor, stall)
            .orElse(new VisitorPoints(visitor, stall, 0));

        visitorPoints.setPointsEarned(visitorPoints.getPointsEarned() + points);
        return visitorPointsRepository.save(visitorPoints);
    }

    // ✅ Get all points earned by a visitor
    public List<VisitorPoints> getPointsByVisitor(Long visitorId) {
        User visitor = userRepository.findById(visitorId)
            .orElseThrow(() -> new RuntimeException("Visitor not found"));

        return visitorPointsRepository.findByVisitor(visitor);
    }
}