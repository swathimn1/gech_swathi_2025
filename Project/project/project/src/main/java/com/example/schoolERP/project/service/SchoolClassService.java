package com.example.schoolERP.project.service;

import com.example.schoolERP.project.dto.SchoolClassDTO;
import com.example.schoolERP.project.model.SchoolClass;
import com.example.schoolERP.project.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolClassService {

    @Autowired
    private ClassRepository classRepository;

    private SchoolClassDTO convertToDto(SchoolClass sc) {
    	SchoolClassDTO dto = new SchoolClassDTO();
        dto.setId(sc.getId());
        dto.setName(sc.getName());
        dto.setSection(sc.getSection());
        dto.setClassTeacher(sc.getClassTeacher());
        return dto;
    }

    private SchoolClass convertToEntity(SchoolClassDTO dto) {
        SchoolClass sc = new SchoolClass();
        sc.setId(dto.getId());
        sc.setName(dto.getName());
        sc.setSection(dto.getSection());
        sc.setClassTeacher(dto.getClassTeacher());
        return sc;
    }

    public List<SchoolClassDTO> getAllClasses() {
        return classRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public SchoolClassDTO saveClass(SchoolClassDTO dto) {
        SchoolClass sc = convertToEntity(dto);
        SchoolClass saved = classRepository.save(sc);
        return convertToDto(saved);
    }

    public SchoolClassDTO updateClass(Long id, SchoolClassDTO dto) {
        Optional<SchoolClass> optionalClass = classRepository.findById(id);
        if (optionalClass.isPresent()) {
            SchoolClass sc = optionalClass.get();
            sc.setName(dto.getName());
            sc.setSection(dto.getSection());
            sc.setClassTeacher(dto.getClassTeacher());
            SchoolClass updated = classRepository.save(sc);
            return convertToDto(updated);
        }
        return null; // or throw exception
    }

    public boolean deleteClass(Long id) {
        Optional<SchoolClass> optionalClass = classRepository.findById(id);
        if (optionalClass.isPresent()) {
            classRepository.delete(optionalClass.get());
            return true;
        }
        return false; // or throw exception
    }

    public SchoolClassDTO getClassById(Long id) {
        Optional<SchoolClass> schoolClass = classRepository.findById(id);
        return schoolClass.map(this::convertToDto).orElse(null); // or throw exception
    }
}
