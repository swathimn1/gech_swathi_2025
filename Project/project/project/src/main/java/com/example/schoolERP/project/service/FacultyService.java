package com.example.schoolERP.project.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.schoolERP.project.model.Faculty;
import com.example.schoolERP.project.repository.FacultyRepository;

@Service
public class FacultyService implements UserDetailsService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Faculty faculty = facultyRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Faculty not found"));

        return new org.springframework.security.core.userdetails.User(
                faculty.getUsername(),
                faculty.getPassword(),
                List.of(new SimpleGrantedAuthority(faculty.getRole()))
        );
    }
}
