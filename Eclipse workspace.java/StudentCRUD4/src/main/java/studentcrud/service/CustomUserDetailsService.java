package studentcrud.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import studentcrud.model.Student;
import studentcrud.repository.StudentRepository;

public class CustomUserDetailsService implements UserDetailsService {
	private StudentRepository studentRepository;

	public CustomUserDetailsService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = studentRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("username not found:" + username));
		return new CustomUserDetails(student);
	}

}
