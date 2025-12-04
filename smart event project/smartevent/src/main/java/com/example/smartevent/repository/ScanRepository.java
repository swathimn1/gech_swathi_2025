package com.example.smartevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.smartevent.models.Scan;
@Repository
public interface ScanRepository extends JpaRepository<Scan, Long> {}

