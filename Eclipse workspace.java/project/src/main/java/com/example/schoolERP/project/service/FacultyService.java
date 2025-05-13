package com.example.schoolERP.project.service;


import com.example.schoolERP.project.dto.FacultyDTO;
import com.example.schoolERP.project.model.Faculty;
import com.example.schoolERP.project.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    private FacultyDTO convertToDto(Faculty faculty) {
    	FacultyDTO dto = new FacultyDTO();
        dto.setId(faculty.getId());
        dto.setName(faculty.getName());
        dto.setSubject(faculty.getSubject());
        dto.setDepartment(faculty.getDepartment());
        dto.setEmail(faculty.getEmail());
        return dto;
    }

    private Faculty convertToEntity(FacultyDTO dto) {
        Faculty faculty = new Faculty();
        faculty.setId(dto.getId());
        faculty.setName(dto.getName());
        faculty.setSubject(dto.getSubject());
        faculty.setDepartment(dto.getDepartment());
        faculty.setEmail(dto.getEmail());
        return faculty;
    }

    public List<FacultyDTO> getAllFaculty() {
        return facultyRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public FacultyDTO saveFaculty(FacultyDTO dto) {
        Faculty faculty = convertToEntity(dto);
        Faculty saved = facultyRepository.save(faculty);
        return convertToDto(saved);
    }

    public FacultyDTO updateFaculty(Long id, FacultyDTO dto) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isPresent()) {
            Faculty faculty = optionalFaculty.get();
            faculty.setName(dto.getName());
            faculty.setSubject(dto.getSubject());
            faculty.setDepartment(dto.getDepartment());
            faculty.setEmail(dto.getEmail());
            Faculty updated = facultyRepository.save(faculty);
            return convertToDto(updated);
        }
        return null; // or throw exception
    }

    public boolean deleteFaculty(Long id) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isPresent()) {
            facultyRepository.delete(optionalFaculty.get());
            return true;
        }
        return false; // or throw exception
    }

    public FacultyDTO getFacultyById(Long id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        return faculty.map(this::convertToDto).orElse(null); // or throw exception
    }
}
