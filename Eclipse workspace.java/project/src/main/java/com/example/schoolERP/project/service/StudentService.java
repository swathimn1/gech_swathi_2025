package com.example.schoolERP.project.service;


import com.example.schoolERP.project.dto.StudentDTO;
import com.example.schoolERP.project.model.Student;
import com.example.schoolERP.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private StudentDTO convertToDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setStudentClass(student.getStudentClass());
        dto.setSection(student.getSection());
        dto.setEmail(student.getEmail());
        return dto;
    }

    private Student convertToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setStudentClass(dto.getStudentClass());
        student.setSection(dto.getSection());
        student.setEmail(dto.getEmail());
        return student;
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public StudentDTO saveStudent(StudentDTO dto) {
        Student student = convertToEntity(dto);
        Student saved = studentRepository.save(student);
        return convertToDto(saved);
    }

    public StudentDTO updateStudent(Long id, StudentDTO dto) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(dto.getName());
            student.setStudentClass(dto.getStudentClass());
            student.setSection(dto.getSection());
            student.setEmail(dto.getEmail());
            Student updated = studentRepository.save(student);
            return convertToDto(updated);
        }
        return null; // or throw exception
    }

    public boolean deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.delete(optionalStudent.get());
            return true;
        }
        return false; // or throw exception
    }

    public StudentDTO getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(this::convertToDto).orElse(null); // or throw exception
    }
}

