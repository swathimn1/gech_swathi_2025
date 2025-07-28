package com.example.schoolERP.project.service;

import com.example.schoolERP.project.dto.UploadResultsDTO;
import com.example.schoolERP.project.model.UploadResults;
import com.example.schoolERP.project.repository.UploadResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UploadResultsService {

    @Autowired
    private UploadResultsRepository uploadResultsRepository;

    // Convert Entity to DTO
    private UploadResultsDTO convertToDTO(UploadResults result) {
        UploadResultsDTO dto = new UploadResultsDTO();
        dto.setId(result.getId());
        dto.setName(result.getName());
        dto.setMarks(result.getMarks());
        dto.setGrade(result.getGrade());
        return dto;
    }

    // Convert DTO to Entity
    private UploadResults convertToEntity(UploadResultsDTO dto) {
        UploadResults result = new UploadResults();
        result.setId(dto.getId());
        result.setName(dto.getName());
        result.setMarks(dto.getMarks());
        result.setGrade(dto.getGrade());
        return result;
    }

    public List<UploadResultsDTO> getAllResults() {
        return uploadResultsRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UploadResultsDTO getResultById(Long id) {
        UploadResults result = uploadResultsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid result ID: " + id));
        return convertToDTO(result);
    }

    public void saveResult(UploadResultsDTO dto) {
        uploadResultsRepository.save(convertToEntity(dto));
    }

    public void deleteResult(Long id) {
        uploadResultsRepository.deleteById(id);
    }
}
