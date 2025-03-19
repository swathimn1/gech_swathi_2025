package com.SpringBootCRUD.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBootCRUD.dto.Studentdto;
import com.SpringBootCRUD.models.Student;
import com.SpringBootCRUD.repository.StudentRepository;

@Service
public class StudentServices {
	
	private final StudentRepository studentRepository;

	public StudentServices(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	// to get list of student
	public List<Student> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		return students;
	}
	
	public void saveStudent(Studentdto studentdto) {
		Student student = new Student();
		student.setfName(studentdto.getfName());
		student.setlName(studentdto.getlName());
		student.setEmail(studentdto.getEmail());
		student.setPhone(studentdto.getPhone());
		student.setAddress(studentdto.getAddress());
		studentRepository.save(student);
	}
	
	public Student getStudent(Long id) {
		Student student = studentRepository.findById(id).get();
		return student;
	}
	public void updateStudent(Studentdto studentdto,Long id) {
		Student student = studentRepository.findById(id).get();
		student.setfName(studentdto.getfName());
		student.setlName(studentdto.getlName());
		student.setEmail(studentdto.getEmail());
		student.setPhone(studentdto.getPhone());
		student.setAddress(studentdto.getAddress());
		studentRepository.save(student);
	}
	public void deleteStudent(Long id) {
	    studentRepository.deleteById(id);
	}


}
