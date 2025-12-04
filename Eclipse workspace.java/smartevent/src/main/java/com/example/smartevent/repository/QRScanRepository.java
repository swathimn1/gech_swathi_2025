package com.example.smartevent.repository;

import com.example.smartevent.models.QRScan;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QRScanRepository extends JpaRepository<QRScan, Long> {
    List<QRScan> findByUserId(Long userId);
    long countByStallId(Long stallId);

    Optional<QRScan> findByVisitorIdAndStallId(Long visitorId, Long stallId);

    List<QRScan> findByStallId(Long stallId);

    List<QRScan> findByVisitorId(Long visitorId);
    boolean existsByVisitorIdAndStallId(Long visitorId, Long stallId);
	Long countDistinctVisitorsByStallId(Long id);
	Long countByStallIdIn(List<Long> stallIds);
	Long countDistinctVisitorsByStallIdIn(List<Long> stallIds);
	

   
}