package com.example.studentform.validation.service;

import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		MultipartFile image= studentDTO.getImage();
		Date createdAt=new Date();
		String storeImageName=createdAt.getTime()+"_"+image.getOriginalFilename();
		System.out.println(storeImageName);
		try {
			String uploadDir="public/images/";
			Path uploadPath=Paths.get(uploadDir);
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			try {
				InputStream inputstream=image.getInputStream();
				Files.copy(inputstream, Paths.get(uploadDir+storeImageName),StandardCopyOption.REPLACE_EXISTING );
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		MultipartFile document= studentDTO.getDocument();
		Date createdAt1=new Date();
		String storeDocumentName=createdAt1.getTime()+"_"+document.getOriginalFilename();
		System.out.println(storeDocumentName);
		try {
			String uploadDir1="public/documents/";
			Path uploadPath1=Paths.get(uploadDir1);
			if(!Files.exists(uploadPath1)) {
				Files.createDirectories(uploadPath1);
			}
			try {
				InputStream inputstream=document.getInputStream();
				Files.copy(inputstream, Paths.get(uploadDir1+storeDocumentName),StandardCopyOption.REPLACE_EXISTING );
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setAge(studentDTO.getAge());
		student.setEmail(studentDTO.getEmail());
		student.setPassword(studentDTO.getPassword());
		student.setImagePath(storeImageName);
		student.setDocumentPath(storeDocumentName);
		studentRepository.save(student);

	}

	public void deleteStudent(int id) {
		Student student=studentRepository.findById(id).get();
		String uploadDir="public/images/";
		Path imagePath=Paths.get(uploadDir+student.getImagePath());
		try {
			Files.delete(imagePath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		String uploadDir1="public/documents/";
		Path documentPath=Paths.get(uploadDir1+student.getDocumentPath());
		try {
			Files.delete(documentPath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
		if(!studentDTO.getImage().isEmpty()) {
			Path oldImagePath = Paths.get("public/images/"+student.getImagePath());
			try {
				Files.delete(oldImagePath);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			MultipartFile image = studentDTO.getImage();
			Date createdAt = new Date();
			String storeImageName = createdAt.getTime()+"_"+image.getOriginalFilename();
			String uploadDir = "public/images/";
			try {
				InputStream inputStream = image.getInputStream();
				Files.copy(inputStream, Paths.get(uploadDir+storeImageName),StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			student.setImagePath(storeImageName);
			}
		
		if(!studentDTO.getDocument().isEmpty()) {
			Path oldDocumentPath = Paths.get("public/documents/"+student.getDocumentPath());
			try {
				Files.delete(oldDocumentPath);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			MultipartFile document = studentDTO.getDocument();
			Date createdAt = new Date();
			String storeDocumentName = createdAt.getTime()+"_"+document.getOriginalFilename();
			String uploadDir1 = "public/documents/";
			try {
				InputStream inputStream = document.getInputStream();
				Files.copy(inputStream, Paths.get(uploadDir1+storeDocumentName),StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			student.setDocumentPath(storeDocumentName);
			}
		student.setName(studentDTO.getName());
		student.setAge(studentDTO.getAge());
		student.setEmail(studentDTO.getEmail());
		student.setPassword(studentDTO.getPassword());
		studentRepository.save(student);
	}

}
