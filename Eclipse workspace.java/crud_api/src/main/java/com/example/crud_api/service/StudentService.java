package com.example.crud_api.service;

import com.example.crud_api.dto.StudentDTO;
import com.example.crud_api.model.Student;
import com.example.crud_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Save or update a student
    public void saveStudent(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
        studentRepository.save(student);
    }

    // Delete a student with safe Optional check
    public void deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        optionalStudent.ifPresent(studentRepository::delete);
    }

    // Get a student by ID
    public StudentDTO getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return mapToDTO(optionalStudent.get());
        }
        return null; 
    }

    // Mapping Entity to DTO
    private StudentDTO mapToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setCourse(student.getCourse());
        return dto;
    }
}
