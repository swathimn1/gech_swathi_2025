package com.example.smartevent.repository;

import com.example.smartevent.models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    
    List<Result> findByStall(Stall stall);
    
    List<Result> findByStallId(Long stallId);
    
    List<Result> findByUploadedBy(User user);
    
    List<Result> findByDate(LocalDate date);
    
    List<Result> findByStallIdOrderByUploadedAtDesc(Long stallId);
}