package com.example.schoolERP.project.service;

import com.example.schoolERP.project.dto.SchoolClassDTO;
import com.example.schoolERP.project.model.SchoolClass;
import com.example.schoolERP.project.repository.SchoolClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolClassService {

    private final SchoolClassRepository classRepository;

    public SchoolClassService(SchoolClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<SchoolClassDTO> getAllClasses() {
        return classRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public SchoolClassDTO getClassById(Long id) {
        return classRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    public SchoolClassDTO saveClass(SchoolClassDTO dto) {
        SchoolClass saved = classRepository.save(toEntity(dto));
        return toDto(saved);
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }

    // Convert entity to DTO
    private SchoolClassDTO toDto(SchoolClass c) {
        SchoolClassDTO dto = new SchoolClassDTO();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setSection(c.getSection());
        dto.setTotalStudents(c.getTotalStudents());
        return dto;
    }

    // Convert DTO to entity
    private SchoolClass toEntity(SchoolClassDTO dto) {
        SchoolClass c = new SchoolClass();
        c.setId(dto.getId());
        c.setName(dto.getName());
        c.setSection(dto.getSection());
        c.setTotalStudents(dto.getTotalStudents());
        return c;
    }
    public SchoolClassDTO updateClass(Long id, SchoolClassDTO dto) {
        Optional<SchoolClass> optionalClass = classRepository.findById(id); 

        if (optionalClass.isPresent()) {
            SchoolClass existingClass = optionalClass.get();
            existingClass.setName(dto.getName());
            existingClass.setSection(dto.getSection());
            existingClass.setTotalStudents(dto.getTotalStudents());

            SchoolClass updated = classRepository.save(existingClass); 
            return toDto(updated); 
        }

        return null; 
    }



}
