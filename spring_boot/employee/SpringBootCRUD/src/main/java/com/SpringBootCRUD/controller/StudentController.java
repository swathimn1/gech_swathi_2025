package com.SpringBootCRUD.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import com.SpringBootCRUD.dto.Studentdto;
import com.SpringBootCRUD.models.Student;
import com.SpringBootCRUD.services.StudentServices;

@Controller
public class StudentController {
	
	private final StudentServices studentServices;
	
	
	public StudentController(StudentServices studentServices) {
		super();
		this.studentServices = studentServices;
	}


	@GetMapping({"/students"})
	public String getAllStudents(Model model) {
		List<Student> students = studentServices.getAllStudents();
		model.addAttribute("students", students);
		return "student";
	}
	
//    @GetMapping({"/add-student"})
//	public String getAllStudents() {
//		return "add_student";
//	}
    
    @GetMapping("/add-student")
    public String addStudent(Model model) {
    	Studentdto studentdto = new Studentdto();
        model.addAttribute("studentdto", studentdto); 
        return "add_student"; 
    }
    
    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute Studentdto studentdto) {
       studentServices.saveStudent(studentdto);
    	return "redirect:/students";
    }
    
    @GetMapping("/edit-student")
    public String getStudent(@RequestParam Long id, Model model) {
    	Student student = studentServices.getStudent(id);
    	Studentdto studentdto = new Studentdto();
    	studentdto.setfName(student.getfName());
    	studentdto.setlName(student.getlName());
    	studentdto.setEmail(student.getEmail());
    	studentdto.setPhone(student.getPhone());
    	studentdto.setAddress(student.getAddress());
    	model.addAttribute("studentdto", studentdto); // for feild
    	model.addAttribute("student", student); //for id
    	return "edit_student";
    }
    
    @PostMapping("/edit-student")
    public String updateStudent(@ModelAttribute Studentdto studentdto, @RequestParam Long id ) {
    	studentServices.updateStudent(studentdto,id);
    	return "redirect:/students";
    }
    @GetMapping("/delete-student")
    public String deleteStudent(@RequestParam Long id) {
        studentServices.deleteStudent(id);
        return "redirect:/students"; 
    }


}
