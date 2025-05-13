package com.springSecurityDemo.springSecurityDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springSecurityDemo.springSecurityDemo.dto.StudentDTO;
import com.springSecurityDemo.springSecurityDemo.models.StudentModels;
import com.springSecurityDemo.springSecurityDemo.repository.StudentRepository;

import jakarta.mail.MessagingException;

@Service
public class StudentService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	private StudentRepository studentRepository;
	private EmailService emailService;
	
	

	
	
	public StudentService(PasswordEncoder passwordEncoder, StudentRepository studentRepository,
			EmailService emailService) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.studentRepository = studentRepository;
		this.emailService = emailService;
	}





	public void storeStudent(StudentDTO studentDTO) throws MessagingException {
		StudentModels student = new StudentModels();
		
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setPassword(passwordEncoder.encode(studentDTO.getPassword()));
		student.setRole("ROLE_USER");
		studentRepository.save(student);
		
		emailService.sendEmail(studentDTO.getEmail(),studentDTO.getEmail(),studentDTO.getPassword(), studentDTO.getName());
	}
}
