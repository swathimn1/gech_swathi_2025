package com.example.studentform.validation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studentform.validation.dto.StudentDTO;
import com.example.studentform.validation.models.Student;
import com.example.studentform.validation.repository.StudentRepository;

@Service

public class StudentService {
	private StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
		
		public List<Student> getAllStudents(){
			return studentRepository.findAll();
			
		}
	

	public void saveStudent(StudentDTO studentDTO) {
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setAge(studentDTO.getAge());
		student.setEmail(studentDTO.getEmail());
		student.setPassword(studentDTO.getPassword());
		studentRepository.save(student);

	}

}
