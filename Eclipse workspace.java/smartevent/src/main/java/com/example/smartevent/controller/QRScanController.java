package com.example.smartevent.controller;

import com.example.smartevent.dto.QRScanRequest;
import com.example.smartevent.dto.QRScanResponse;
import com.example.smartevent.dto.PointsResponse;
import com.example.smartevent.service.QRScanService;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class QRScanController {

    private final QRScanService qrScanService;

    public QRScanController(QRScanService qrScanService) {
        this.qrScanService = qrScanService;
    }

    // ========== VISITOR ENDPOINTS ==========
//
//    @GetMapping("/api/visitor/scan")
//    public List<QRScanResponse> getVisitorScans(@RequestHeader("Authorization") String token) {
//        Long userId = extractUserIdFromToken(token);
//        return qrScanService.getScansByUser(userId);
//    }
//
//    @PostMapping("/api/visitor/scan")
//    public QRScanResponse addVisitorScan(@RequestHeader("Authorization") String token,
//                                         @RequestBody QRScanRequest request) {
//        Long userId = extractUserIdFromToken(token);
//        return qrScanService.addScan(userId, request.getContent());
//    }
//
//    @GetMapping("/api/visitor/scan/points")
//    public PointsResponse getVisitorPoints(@RequestHeader("Authorization") String token) {
//        Long userId = extractUserIdFromToken(token);
//        return qrScanService.getTotalPoints(userId);
//    }
//
//    @DeleteMapping("/api/visitor/scan/{id}")
//    public String deleteVisitorScan(@PathVariable Long id,
//                                    @RequestHeader("Authorization") String token) {
//        Long userId = extractUserIdFromToken(token);
//        qrScanService.deleteScan(id, userId);
//        return "Scan deleted successfully";
//    }
//
//    @DeleteMapping("/api/visitor/scan/all")
//    public String deleteAllVisitorScans(@RequestHeader("Authorization") String token) {
//        Long userId = extractUserIdFromToken(token);
//        qrScanService.deleteAllScans(userId);
//        return "All scans deleted successfully";
//    }

    // ========== ADMIN ENDPOINTS ==========

    @GetMapping("/api/admin/qr")
    public List<QRScanResponse> getAllScans() {
        return qrScanService.getAllScans();
    }

    @GetMapping("/api/admin/qr/user/{userId}")
    public List<QRScanResponse> getAdminUserScans(@PathVariable Long userId) {
        return qrScanService.getScansByUser(userId);
    }

    @GetMapping("/api/admin/qr/user/{userId}/points")
    public PointsResponse getAdminUserPoints(@PathVariable Long userId) {
        return qrScanService.getTotalPoints(userId);
    }

    @DeleteMapping("/api/admin/qr/{id}")
    public String deleteAdminScan(@PathVariable Long id) {
        qrScanService.deleteScanAdmin(id);
        return "Scan deleted successfully";
    }

    @DeleteMapping("/api/admin/qr/user/{userId}/all")
    public String deleteAllUserScans(@PathVariable Long userId) {
        qrScanService.deleteAllScans(userId);
        return "All user scans deleted successfully";
    }

    // Helper method to extract userId from JWT token
    private Long extractUserIdFromToken(String token) {
        // TODO: Implement JWT token parsing logic
        // For now, returning a placeholder
        // You should decode the JWT and extract the userId claim
        return 1L; // Replace with actual token parsing
    }
    

@GetMapping("/api/visitor/scan")
public List<QRScanResponse> getVisitorScans(Authentication authentication) {
    Long userId = qrScanService.getUserIdFromEmail(authentication.getName());
    return qrScanService.getScansByUser(userId);
}

@PostMapping("/api/visitor/scan")
public QRScanResponse addVisitorScan(Authentication authentication,
                                     @RequestBody QRScanRequest request) {
    Long userId = qrScanService.getUserIdFromEmail(authentication.getName());
    return qrScanService.addScan(userId, request.getContent());
}

@GetMapping("/api/visitor/scan/points")
public PointsResponse getVisitorPoints(Authentication authentication) {
    Long userId = qrScanService.getUserIdFromEmail(authentication.getName());
    return qrScanService.getTotalPoints(userId);
}

@DeleteMapping("/api/visitor/scan/{id}")
public String deleteVisitorScan(@PathVariable Long id,
                                Authentication authentication) {
    Long userId = qrScanService.getUserIdFromEmail(authentication.getName());
    qrScanService.deleteScan(id, userId);
    return "Scan deleted successfully";
}

@DeleteMapping("/api/visitor/scan/all")
public String deleteAllVisitorScans(Authentication authentication) {
    Long userId = qrScanService.getUserIdFromEmail(authentication.getName());
    qrScanService.deleteAllScans(userId);
    return "All scans deleted successfully";
}
}