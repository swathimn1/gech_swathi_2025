package com.example.schoolERP.project.service;

import com.example.schoolERP.project.dto.FacultyDTO;
import com.example.schoolERP.project.model.Faculty;
import com.example.schoolERP.project.repository.FacultyRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyService implements UserDetailsService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Faculty faculty = facultyRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Faculty not found with username: " + username));

        return new org.springframework.security.core.userdetails.User(
                faculty.getUsername(),
                faculty.getPassword(),
                List.of(new SimpleGrantedAuthority(faculty.getRole()))
        );
    }

    public List<FacultyDTO> getAllFaculty() {
        return facultyRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public FacultyDTO getFacultyById(Long id) {
        Optional<Faculty> facultyOpt = facultyRepository.findById(id);
        return facultyOpt.map(this::toDto).orElse(new FacultyDTO());
    }

    public FacultyDTO saveFaculty(FacultyDTO dto) {
        Faculty savedFaculty = facultyRepository.save(toEntity(dto));
        return toDto(savedFaculty);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    private FacultyDTO toDto(Faculty f) {
        FacultyDTO d = new FacultyDTO();
        d.setId(f.getId());
        d.setName(f.getName());
        d.setSubject(f.getSubject());
        d.setDepartment(f.getDepartment());
        d.setEmail(f.getEmail());
        d.setUsername(f.getUsername());
        d.setPassword(f.getPassword()); 
        d.setRole(f.getRole());
        return d;
    }

    private Faculty toEntity(FacultyDTO d) {
        Faculty f = new Faculty();
        f.setId(d.getId());
        f.setName(d.getName());
        f.setSubject(d.getSubject());
        f.setDepartment(d.getDepartment());
        f.setEmail(d.getEmail());
        f.setUsername(d.getUsername());
        f.setPassword(d.getPassword()); 
        f.setRole(d.getRole());
        return f;
    }
    public FacultyDTO updateFaculty(Long id, FacultyDTO dto) {
        Optional<Faculty> facultyOpt = facultyRepository.findById(id);
        if (facultyOpt.isPresent()) {
            Faculty faculty = facultyOpt.get();
            faculty.setName(dto.getName());
            faculty.setSubject(dto.getSubject());
            faculty.setDepartment(dto.getDepartment());
            faculty.setEmail(dto.getEmail());
            faculty.setUsername(dto.getUsername());
            faculty.setPassword(dto.getPassword()); // or hash again if encrypted
            faculty.setRole(dto.getRole());

            Faculty updatedFaculty = facultyRepository.save(faculty);
            return toDto(updatedFaculty);
        } else {
            throw new UsernameNotFoundException("Faculty with ID " + id + " not found.");
        }
    }
}
