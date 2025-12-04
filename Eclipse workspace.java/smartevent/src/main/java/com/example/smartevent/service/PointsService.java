package com.example.smartevent.service;

import com.example.smartevent.models.QRScan;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.QRScanRepository;
import com.example.smartevent.repository.StallRepository;
import com.example.smartevent.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PointsService {

    private final QRScanRepository qrScanRepository;
    private final StallRepository stallRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;
    

    public PointsService(QRScanRepository qrScanRepository, StallRepository stallRepository,
			UserRepository userRepository, EmailService emailService) {
		super();
		this.qrScanRepository = qrScanRepository;
		this.stallRepository = stallRepository;
		this.userRepository = userRepository;
		this.emailService = emailService;
	}


	public String processScan(Long visitorId, Long stallId) throws Exception {

        // Fetch visitor
        User visitor = userRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        // Fetch stall
        Stall stall = stallRepository.findById(stallId)
                .orElseThrow(() -> new RuntimeException("Stall not found"));

        // Prevent duplicate scans
        boolean exists = qrScanRepository.existsByVisitorIdAndStallId(visitorId, stallId);
        if (exists) {
            return "ALREADY_SCANNED";
        }

        // Create a new QR scan record
        QRScan scan = new QRScan();
        scan.setVisitorId(visitorId);
        scan.setStallId(stallId);
//        scan.setScannedAt(LocalDateTime.now());

        qrScanRepository.save(scan);

        // Determine how many points to give
        int points = 10; // Default points

        try {
            points = stall.getCapacity() != null ? stall.getCapacity() : 10;
        } catch (Exception ignored) {}

        // Update visitor totalRewards / points
        int currentTotal = visitor.getTotalPoints() == null ? 0 : visitor.getTotalPoints();
        visitor.setTotalPoints(currentTotal + points);
        userRepository.save(visitor);

        // Send email
        emailService.sendEmail(
                visitor.getEmail(),
                "You Earned Points 🎉",
                "points-earned.html",
                new String[][]{
                        {"{{name}}", visitor.getFullName()},
                        {"{{points}}", String.valueOf(points)},
                        {"{{stallName}}", stall.getName()}
                }
        );

        return "SUCCESS";
    }
}
