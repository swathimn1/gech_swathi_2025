package com.example.schoolERP.project.service;

import com.example.schoolERP.project.dto.ReportDTO;
import com.example.schoolERP.project.model.Report;
import com.example.schoolERP.project.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    private ReportDTO convertToDto(Report report) {
        ReportDTO dto = new ReportDTO();
        dto.setId(report.getId());
        dto.setStudentName(report.getStudentName());
        dto.setGrade(report.getGrade());
        dto.setRemarks(report.getRemarks());
        return dto;
    }

    private Report convertToEntity(ReportDTO dto) {
        Report report = new Report();
        report.setId(dto.getId());
        report.setStudentName(dto.getStudentName());
        report.setGrade(dto.getGrade());
        report.setRemarks(dto.getRemarks());
        return report;
    }

    // Create
    public ReportDTO saveReport(ReportDTO dto) {
        Report report = convertToEntity(dto);
        Report saved = reportRepository.save(report);
        return convertToDto(saved);
    }

    // Get All
    public List<ReportDTO> getAllReports() {
        return reportRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Get by ID
    public ReportDTO getReportById(Long id) {
        Optional<Report> reportOpt = reportRepository.findById(id);
        return reportOpt.map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("Report not found with id " + id));
    }

    // Update
    public ReportDTO updateReport(Long id, ReportDTO dto) {
        Report existing = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found with id " + id));
        existing.setStudentName(dto.getStudentName());
        existing.setGrade(dto.getGrade());
        existing.setRemarks(dto.getRemarks());
        Report updated = reportRepository.save(existing);
        return convertToDto(updated);
    }

    // Delete
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
