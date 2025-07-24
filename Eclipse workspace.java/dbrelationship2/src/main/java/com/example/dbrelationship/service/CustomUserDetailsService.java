package com.example.dbrelationship.service;


import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.dbrelationship.model.Employee;
import com.example.dbrelationship.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public CustomUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Trying to load employee with email: " + email);

        Employee employee = employeeRepository.findByEmail(email)
        	    .orElseThrow(() -> new UsernameNotFoundException("Employee not found with email: " + email));


        System.out.println("Employee found: " + employee);

        // Force load roles (to prevent LazyInitializationException)
        employee.getRoles().size();

        return new CustomUserDetails(employee);
    }
}

