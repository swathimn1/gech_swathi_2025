package com.example.studentform.validation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studentform.validation.dto.StudentDTO;
import com.example.studentform.validation.models.Student;
import com.example.studentform.validation.repository.StudentRepository;

@Service

public class StudentService {
	private StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
		
		public List<Student> getAllStudents(){
			List<Student> students=studentRepository.findAll();
			return students;
			
		}
	

	public void saveStudent(StudentDTO studentDTO) {
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setAge(studentDTO.getAge());
		student.setEmail(studentDTO.getEmail());
		student.setPassword(studentDTO.getPassword());
		studentRepository.save(student);

	}

	public void deleteStudent(int id) {
		Student student=studentRepository.findById(id).get();
		studentRepository.delete(student);
	}

	public StudentDTO editStudent(int id) {
		Student student=studentRepository.findById(id).get();
		StudentDTO studentDTO=new StudentDTO();
		studentDTO.setName(student.getName());
		studentDTO.setAge(student.getAge());
		studentDTO.setEmail(student.getEmail());
		studentDTO.setPassword(student.getPassword());
		return studentDTO;
		
		
	}
	

	public void updateStudent(StudentDTO studentDTO, int id) {
		Student student=studentRepository.findById(id).get();
		student.setName(studentDTO.getName());
		student.setAge(studentDTO.getAge());
		student.setEmail(studentDTO.getEmail());
		student.setPassword(studentDTO.getPassword());
		studentRepository.save(student);
	}

}
