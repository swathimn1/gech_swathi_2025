package com.geccrud.SpringBootCRUD.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geccrud.SpringBootCRUD.dto.StudentDTO;
import com.geccrud.SpringBootCRUD.models.Student;
import com.geccrud.SpringBootCRUD.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get list of students
//    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//    }
    public List<Student> getAllStudents(){
    	return studentRepository.findAll();
    }

    // Save student
//    public void saveStudent(StudentDTO studentDTO) {
//        if (studentDTO.getFirstName() == null || studentDTO.getLastName() == null) {
//            throw new RuntimeException("First name and last name cannot be null");
//        }
//        Student student = new Student();
//        student.setfName(studentDTO.getFirstName());
//        student.setlName(studentDTO.getLastName());
//        student.setEmail(studentDTO.getEmail());
//        student.setPhone(studentDTO.getPhone());
//        student.setAddress(studentDTO.getAddress());
//        studentRepository.save(student);
//    }
    public void saveStudent(StudentDTO studentDTO) {
    	Student student=new Student();
    	 student.setfName(studentDTO.getFirstName());
         student.setlName(studentDTO.getLastName());
         student.setEmail(studentDTO.getEmail());
         student.setPhone(studentDTO.getPhone());
         student.setAddress(studentDTO.getAddress());
         studentRepository.save(student);
    }

    // Get student by ID
//    public Student getStudent(Long id) {
//        return studentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
//    }
    public Student getStudent(Long id) {
    	return studentRepository.findById(id)
    			.orElseThrow(()->new RuntimeException("Student not found with id:"+id));
    }

    // Update student
//    public void updateStudent(StudentDTO studentDTO, Long id) {
//        Student student = studentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
//        student.setfName(studentDTO.getFirstName());
//        student.setlName(studentDTO.getLastName());
//        student.setEmail(studentDTO.getEmail());
//        student.setPhone(studentDTO.getPhone());
//        student.setAddress(studentDTO.getAddress());
//        studentRepository.save(student);
//    }
    public void updateStudent(StudentDTO studentDTO ,Long id) {
    	Student student=studentRepository.findById(id)
    			.orElseThrow(()->new RuntimeException("Student not found with id:"+id));
    	student.setfName(studentDTO.getFirstName());
      student.setlName(studentDTO.getLastName());
      student.setEmail(studentDTO.getEmail());
      student.setPhone(studentDTO.getPhone());
      student.setAddress(studentDTO.getAddress());
      studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
}

