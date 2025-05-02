package com.example.schoolERP.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schoolERP.project.model.Report;



public interface ReportRepository extends JpaRepository<Report, Long> {}