package com.springSecurityDemo.springSecurityDemo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springSecurityDemo.springSecurityDemo.models.StudentModels;

public class CustomUserDetails implements UserDetails {
private StudentModels student;

	public CustomUserDetails(StudentModels student) {
	super();
	this.student = student;
}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(student.getRole()));
	}

	@Override
	public String getPassword() {
		return student.getPassword();
	}

	@Override
	public String getUsername() {
		return student.getEmail();
	}

}
