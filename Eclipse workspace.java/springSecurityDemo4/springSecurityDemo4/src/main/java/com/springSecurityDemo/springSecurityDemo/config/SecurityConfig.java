package com.springSecurityDemo.springSecurityDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springSecurityDemo.springSecurityDemo.repository.StudentRepository;
import com.springSecurityDemo.springSecurityDemo.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {
	private StudentRepository studentRepository;
	
 public SecurityConfig(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
@Bean
 public PasswordEncoder passwordEncoder() {
	 return new BCryptPasswordEncoder();
 }
 @Bean
 public UserDetailsService userDetailsservice() {
	 return new CustomUserDetailsService(studentRepository);
 }
 @Bean
 public DaoAuthenticationProvider daoAuthenticationProvider() {
	 DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
	 provider.setPasswordEncoder(passwordEncoder());
	 provider.setUserDetailsService(userDetailsservice());
	 return provider;
 }
}
