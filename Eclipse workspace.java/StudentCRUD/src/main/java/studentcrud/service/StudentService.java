package studentcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import studentcrud.dto.StudentDTO;
import studentcrud.model.Student;
import studentcrud.repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
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
		studentRepository.save(student);

	}

	public StudentDTO editStudent(Long id) {
		Student student = studentRepository.findById(id).get();
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setName(student.getName());
		studentDTO.setEmail(student.getEmail());
		studentDTO.setPhone(student.getPhone());
		studentDTO.setAddress(student.getAddress());
		return studentDTO;
	}

	public void updateStudent(StudentDTO studentDTO, Long id) {
		Student student = studentRepository.findById(id).get();
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setPhone(studentDTO.getPhone());
		student.setAddress(studentDTO.getAddress());
		studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		Student student = studentRepository.findById(id).get();
		studentRepository.delete(student);
	}
}
