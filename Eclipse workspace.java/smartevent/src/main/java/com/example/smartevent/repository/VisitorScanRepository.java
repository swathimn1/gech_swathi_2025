package com.example.smartevent.repository;

import com.example.smartevent.models.VisitorScan;
import com.example.smartevent.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface VisitorScanRepository extends JpaRepository<VisitorScan, Long> {
    List<VisitorScan> findByVisitor(User visitor);
    void deleteByVisitor(User visitor);
  
}
