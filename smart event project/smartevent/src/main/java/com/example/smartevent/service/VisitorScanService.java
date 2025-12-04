package com.example.smartevent.service;

import com.example.smartevent.dto.VisitorScanDTO;
import com.example.smartevent.models.User;
import com.example.smartevent.models.VisitorScan;
import com.example.smartevent.repository.UserRepository;
import com.example.smartevent.repository.VisitorScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitorScanService {

    @Autowired
    private VisitorScanRepository scanRepository;

    @Autowired
    private UserRepository userRepository;

    // Add new scan (10 points per scan)
    public VisitorScanDTO addScan(String email, String content) {
        User visitor = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        VisitorScan scan = new VisitorScan();
        scan.setContent(content);
        scan.setTimestamp(LocalDateTime.now());
        scan.setPoints(10);
        scan.setVisitor(visitor);

        scanRepository.save(scan);
        return toDTO(scan);
    }

    // Get all scans by visitor
    public List<VisitorScanDTO> getScans(String email) {
        User visitor = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        return scanRepository.findByVisitor(visitor)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Delete a scan by ID
    public void deleteScan(Long id) {
        scanRepository.deleteById(id);
    }

    // Delete all scans for a visitor
    public void deleteAllScans(String email) {
        User visitor = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
        scanRepository.deleteByVisitor(visitor);
    }

    // Get total points
    public int getTotalPoints(String email) {
        User visitor = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
        return scanRepository.findByVisitor(visitor)
                .stream()
                .mapToInt(VisitorScan::getPoints)
                .sum();
    }

    private VisitorScanDTO toDTO(VisitorScan scan) {
        VisitorScanDTO dto = new VisitorScanDTO();
        dto.setId(scan.getId());
        dto.setContent(scan.getContent());
        dto.setPoints(scan.getPoints());
        dto.setTimestamp(scan.getTimestamp());
        return dto;
    }
}
