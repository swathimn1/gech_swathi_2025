
package com.example.springsecurity.demo7.service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsecurity.demo7.dto.StudentDTO;
import com.example.springsecurity.demo7.model.Student;
import com.example.springsecurity.demo7.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	private PasswordEncoder passwordEncoder;
	


	public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
		super();
		this.studentRepository = studentRepository;
		this.passwordEncoder = passwordEncoder;
	}





	public void saveStudent(StudentDTO studentDTO) {
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setPassword(passwordEncoder.encode(studentDTO.getPassword()));
		studentRepository.save(student);
	}
}
