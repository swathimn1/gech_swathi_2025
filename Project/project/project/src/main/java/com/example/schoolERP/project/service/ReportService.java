package com.example.schoolERP.project.service;

import com.example.schoolERP.project.dto.ReportDTO;
import com.example.schoolERP.project.model.Report;
import com.example.schoolERP.project.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<ReportDTO> getAllReports() {
        return reportRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public ReportDTO getReportById(Long id) {
        return reportRepository.findById(id).map(this::toDto).orElse(null);
    }

    public ReportDTO saveReport(ReportDTO dto) {
        Report saved = reportRepository.save(toEntity(dto));
        return toDto(saved);
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }

    private ReportDTO toDto(Report r) {
        ReportDTO dto = new ReportDTO();
        dto.setId(r.getId());
        dto.setTitle(r.getTitle());
        dto.setDescription(r.getDescription());
        dto.setType(r.getType());
        dto.setCreatedBy(r.getCreatedBy());
        return dto;
    }

    private Report toEntity(ReportDTO dto) {
        Report r = new Report();
        r.setId(dto.getId());
        r.setTitle(dto.getTitle());
        r.setDescription(dto.getDescription());
        r.setType(dto.getType());
        r.setCreatedBy(dto.getCreatedBy());
        return r;
    }
}
