package com.example.schoolERP.project.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.schoolERP.project.dto.CourseDTO;
import com.example.schoolERP.project.model.Course;
import com.example.schoolERP.project.model.Faculty;
import com.example.schoolERP.project.repository.FacultyRepository;
import com.example.schoolERP.project.service.CourseService;

@Controller
@RequestMapping("/student")
public class StudentController {
	private  FacultyRepository facultyRepository;
	private CourseService courseService;

   
	public StudentController(FacultyRepository facultyRepository, CourseService courseService) {
		super();
		this.facultyRepository = facultyRepository;
		this.courseService = courseService;
	}
	@GetMapping("/dashboard")
    public String studentDashboard() {
        return "student_dashboard";
    }
    @GetMapping("/viewFaculty")
    public String viewFaculty(Model model) {
        List<Faculty> facultyList = facultyRepository.findAll();
        model.addAttribute("facultyList", facultyList);
        return "student/view_faculty";
    }
    @GetMapping("/viewCourses")
    public String viewCourses(Model model) {
        List<Course> courseList = courseService.getAllCourses(); // fetch from DB/service
        model.addAttribute("courseList", courseList);
        return "student/view_courses";
    }


    
}

