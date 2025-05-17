package com.example.schoolERP.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.schoolERP.project.dto.StudentDTO;
import com.example.schoolERP.project.model.Student;
import com.example.schoolERP.project.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}
	
	public Student saveStudent(StudentDTO studentDTO) {
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setGrade(studentDTO.getGrade());
		student.setRollNumber(studentDTO.getRollNumber());
		return studentRepository.save(student);
	}
}
