package com.example.springsecurity.demo7.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.springsecurity.demo7.model.Student;
import com.example.springsecurity.demo7.repository.StudentRepository;

public class StudentDetailsService implements UserDetailsService {

	private StudentRepository studentRepository;

	public StudentDetailsService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = studentRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Student not found: " + username));
		return new StudentDetails(student);
	}

}
