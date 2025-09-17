package studentcrud.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import studentcrud.dto.StudentDTO;
import studentcrud.model.Student;
import studentcrud.repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	private PasswordEncoder passwordEncoder;
	private EmailService emailService;

	public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder,
			EmailService emailService) {
		super();
		this.studentRepository = studentRepository;
		this.passwordEncoder = passwordEncoder;
		this.emailService = emailService;
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void saveStudent(StudentDTO studentDTO) {
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setPhone(studentDTO.getPhone());
		student.setAddress(studentDTO.getAddress());
		student.setPassword(studentDTO.getPassword());
		student.setRole(studentDTO.getRole());
		studentRepository.save(student);

	}

	public StudentDTO editStudent(Long id) {
		Student student = studentRepository.findById(id).get();
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setName(student.getName());
		studentDTO.setEmail(student.getEmail());
		studentDTO.setPhone(student.getPhone());
		studentDTO.setAddress(student.getAddress());
		studentDTO.setRole(student.getRole());
		studentDTO.setPassword(student.getPassword());
		return studentDTO;
	}

	public void updateStudent(StudentDTO studentDTO, Long id) {
		Student student = studentRepository.findById(id).get();
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setPhone(studentDTO.getPhone());
		student.setAddress(studentDTO.getAddress());
		student.setRole(studentDTO.getRole());
		student.setPassword(student.getPassword());
		studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		Student student = studentRepository.findById(id).get();
		studentRepository.delete(student);
	}

	public void storeStudent(StudentDTO studentDTO) throws MessagingException {
		Student student = new Student();

		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setPhone(studentDTO.getPhone());
		student.setAddress(studentDTO.getAddress());
		student.setPassword(passwordEncoder.encode(studentDTO.getPassword()));
		student.setRole("ROLE_USER");
		studentRepository.save(student);

		emailService.sendEmail(studentDTO.getEmail(), studentDTO.getEmail(), studentDTO.getPassword(),
				studentDTO.getName());
	}
}
