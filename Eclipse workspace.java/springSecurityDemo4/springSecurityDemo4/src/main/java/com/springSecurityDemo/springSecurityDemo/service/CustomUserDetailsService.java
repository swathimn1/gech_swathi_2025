package com.springSecurityDemo.springSecurityDemo.service;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springSecurityDemo.springSecurityDemo.models.StudentModels;
import com.springSecurityDemo.springSecurityDemo.repository.StudentRepository;

public class CustomUserDetailsService implements UserDetailsService {
	private StudentRepository studentRepository;

	public CustomUserDetailsService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		StudentModels student = studentRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("username not found:" + username));
		return new CustomUserDetails(student);
	}

}
