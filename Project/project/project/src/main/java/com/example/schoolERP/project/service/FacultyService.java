package com.example.schoolERP.project.service;

import com.example.schoolERP.project.dto.ChangePasswordDTO;
import com.example.schoolERP.project.dto.FacultyDTO;
import com.example.schoolERP.project.model.Faculty;
import com.example.schoolERP.project.repository.FacultyRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyService implements UserDetailsService {

	private final FacultyRepository facultyRepository;
	private BCryptPasswordEncoder passwordEncoder;

	public FacultyService(FacultyRepository facultyRepository, BCryptPasswordEncoder passwordEncoder) {
		super();
		this.facultyRepository = facultyRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Faculty faculty = facultyRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Faculty not found with username: " + username));

		return new org.springframework.security.core.userdetails.User(faculty.getUsername(), faculty.getPassword(),
				List.of(new SimpleGrantedAuthority(faculty.getRole())));
	}

	public List<FacultyDTO> getAllFaculty() {
		return facultyRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
	}

	public FacultyDTO getFacultyById(Long id) {
		Optional<Faculty> facultyOpt = facultyRepository.findById(id);
		return facultyOpt.map(this::toDto).orElse(new FacultyDTO());
	}

	public FacultyDTO saveFaculty(FacultyDTO dto) {
	    Faculty faculty = toEntity(dto);

	    // Encode the password before saving
	    if (!dto.getPassword().startsWith("$2a$")) {
	        faculty.setPassword(passwordEncoder.encode(dto.getPassword()));
	    } else {
	        faculty.setPassword(dto.getPassword());
	    }


	    Faculty savedFaculty = facultyRepository.save(faculty);
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

	public Faculty save(Faculty faculty) {
		return facultyRepository.save(faculty);
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

	public FacultyDTO findByEmail(String email) {
		Faculty entity = facultyRepository.findByEmail(email);
		if (entity == null)
			return null;

		FacultyDTO dto = new FacultyDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDepartment(entity.getDepartment());
		dto.setSubject(entity.getSubject());
		dto.setEmail(entity.getEmail());
		dto.setUsername(entity.getUsername());
		dto.setRole(entity.getRole());

		return dto;
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

			// Encode password only if it's not already encoded
			String newPassword = dto.getPassword();
			if (!newPassword.startsWith("$2a$")) {  // BCrypt hashes start with "$2a$"
				newPassword = passwordEncoder.encode(newPassword);
			}
			faculty.setPassword(newPassword);

			faculty.setRole(dto.getRole());

			Faculty updatedFaculty = facultyRepository.save(faculty);
			return toDto(updatedFaculty);
		} else {
			throw new UsernameNotFoundException("Faculty with ID " + id + " not found.");
		}
	}


	public Faculty findEntityByEmail(String email) {
		Faculty faculty = facultyRepository.findByEmail(email);

		if (faculty == null) {
			throw new IllegalArgumentException("Faculty not found with email: " + email);
		}

		return faculty;
	}

	public boolean changePassword(String email, ChangePasswordDTO dto) {
		Faculty faculty = facultyRepository.findByEmail(email);
		if (faculty == null) {
			return false;
		}

		// Assuming passwords are encoded
		if (!passwordEncoder.matches(dto.getCurrentPassword(), faculty.getPassword())) {
			return false;
		}

		faculty.setPassword(passwordEncoder.encode(dto.getNewPassword()));
		facultyRepository.save(faculty);
		return true;
	}

}
