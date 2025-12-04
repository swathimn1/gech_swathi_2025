package com.example.smartevent.service;

import com.example.smartevent.dto.QRScanResponse;
import com.example.smartevent.dto.PointsResponse;
import com.example.smartevent.models.QRScan;
import com.example.smartevent.repository.QRScanRepository;
import com.example.smartevent.repository.UserRepository;
import com.example.smartevent.models.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QRScanService {

    private final QRScanRepository qrScanRepository;
    private final UserRepository userRepository;

    private static final int POINTS_PER_SCAN = 10;

    public QRScanService(QRScanRepository qrScanRepository,
                         UserRepository userRepository) {
        this.qrScanRepository = qrScanRepository;
        this.userRepository = userRepository;
    }

    // ✅ Used by JWT-based controller
    public Long getUserIdFromEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found: " + email))
                .getId();
    }

    public List<QRScanResponse> getAllScans() {
        return qrScanRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<QRScanResponse> getScansByUser(Long userId) {
        return qrScanRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public QRScanResponse addScan(Long userId, String content) {
        QRScan scan = new QRScan();
        scan.setUserId(userId);
        scan.setContent(content);
        scan.setTimestamp(LocalDateTime.now());
        scan.setPoints(POINTS_PER_SCAN);

        QRScan saved = qrScanRepository.save(scan);
        return mapToResponse(saved);
    }

    public PointsResponse getTotalPoints(Long userId) {
        List<QRScan> scans = qrScanRepository.findByUserId(userId);

        int totalPoints = scans.stream()
                .mapToInt(QRScan::getPoints)
                .sum();

        PointsResponse response = new PointsResponse();
        response.setTotalPoints(totalPoints);
        response.setUserId(userId);

        return response;
    }

    public void deleteScan(Long id, Long userId) {
        QRScan scan = qrScanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scan not found"));

        if (!scan.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized to delete this scan");
        }

        qrScanRepository.deleteById(id);
    }

    public void deleteScanAdmin(Long id) {
        qrScanRepository.deleteById(id);
    }

    public void deleteAllScans(Long userId) {
        List<QRScan> scans = qrScanRepository.findByUserId(userId);
        qrScanRepository.deleteAll(scans);
    }

    private QRScanResponse mapToResponse(QRScan scan) {
        QRScanResponse response = new QRScanResponse();
        response.setId(scan.getId());
        response.setContent(scan.getContent());
        response.setTimestamp(scan.getTimestamp());
        response.setPoints(scan.getPoints());
        response.setUserId(scan.getUserId());
        return response;
    }
}
