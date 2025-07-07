package com.example.schoolERP.project.controller;

import com.example.schoolERP.project.dto.FacultyDTO;
import com.example.schoolERP.project.dto.ReportDTO;
import com.example.schoolERP.project.dto.SchoolClassDTO;
import com.example.schoolERP.project.dto.StudentDTO;
import com.example.schoolERP.project.service.FacultyService;
import com.example.schoolERP.project.service.ReportService;
import com.example.schoolERP.project.service.SchoolClassService;
import com.example.schoolERP.project.service.StudentService;
import com.example.schoolERP.project.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private SchoolClassService schoolClassService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private FacultyService facultyService;
	@Autowired
	private ReportService reportService;

	public AdminController(UserService userService, SchoolClassService schoolClassService,
			StudentService studentService, FacultyService facultyService, ReportService reportService) {
		super();
		this.userService = userService;
		this.schoolClassService = schoolClassService;
		this.studentService = studentService;
		this.facultyService = facultyService;
		this.reportService = reportService;
	}

	@GetMapping("/admin_dashboard")
	public String dashboard(Model model) {
		model.addAttribute("totalStudents", 450);
		model.addAttribute("totalFaculty", 65);
		model.addAttribute("totalClasses", 30);
		model.addAttribute("pendingRequests", 12);
		return "admin/admin_dashboard";
	}

	@GetMapping("/manage_students")
	public String showStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		model.addAttribute("student", new StudentDTO());
		return "admin/manage_students";
	}

	@PostMapping("/students/save")
	public String saveStudent(@ModelAttribute StudentDTO student) {
		studentService.saveStudent(student);
		return "redirect:/manage_students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
	    StudentDTO student = studentService.getStudentById(id);
	    if (student == null) {
	        throw new RuntimeException("Student not found with ID: " + id);
	    }
	    model.addAttribute("student", student);
	    return "admin/edit_student";
	}


	@PostMapping("/students/update")
	public String updateStudent(@ModelAttribute("student") StudentDTO studentDTO) {
	    studentService.updateStudent(studentDTO.getId(), studentDTO); 
	    return "redirect:/manage_students";
	}
	 @GetMapping("/students")
	    public String viewStudents(Model model) {
	        List<StudentDTO> students = studentService.getAllStudents();
	        model.addAttribute("students", students);
	        return "admin/manage_students";  
	    }

	

	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/manage_students";
	}

	@GetMapping("/manage_faculty")
	public String showFacultyPage(Model model) {
		model.addAttribute("facultyList", facultyService.getAllFaculty());
		model.addAttribute("faculty", new FacultyDTO()); // For form binding
		return "admin/manage_faculty";
	}

	@PostMapping("/faculty/save")
	public String saveFaculty(@ModelAttribute("faculty") FacultyDTO dto) {
		facultyService.saveFaculty(dto);
		return "redirect:/manage_faculty";
	}

	@GetMapping("/faculty/edit/{id}")
	public String editFaculty(@PathVariable Long id, Model model) {
		model.addAttribute("facultyList", facultyService.getAllFaculty());
		model.addAttribute("faculty", facultyService.getFacultyById(id));
		return "admin/edit_faculty";
	}
	@PostMapping("/faculty/update")
	public String updateFaculty(@ModelAttribute("faculty") FacultyDTO facultyDTO) {
	    facultyService.updateFaculty(facultyDTO.getId(), facultyDTO); 
	    return "redirect:/manage_faculty";
	}

	@GetMapping("/faculty/delete/{id}")
	public String deleteFaculty(@PathVariable Long id) {
		facultyService.deleteFaculty(id);
		return "redirect:/manage_faculty";
	}

	@GetMapping("/classes")
	public String viewClasses(Model model) {
		model.addAttribute("classes", schoolClassService.getAllClasses());
		model.addAttribute("schoolClass", new SchoolClassDTO()); // For the form
		return "admin/classes";
	}

	@PostMapping("/classes/save")
	public String saveClass(@ModelAttribute("schoolClass") SchoolClassDTO dto) {
		schoolClassService.saveClass(dto);
		return "redirect:/classes";
	}

	@GetMapping("/classes/edit/{id}")
	public String editClass(@PathVariable Long id, Model model) {
		model.addAttribute("classes", schoolClassService.getAllClasses());
		model.addAttribute("schoolClass", schoolClassService.getClassById(id));
		return "admin/edit_class";
	}

	@GetMapping("/classes/delete/{id}")
	public String deleteClass(@PathVariable Long id) {
		schoolClassService.deleteClass(id);
		return "redirect:/classes";
	}
	@PostMapping("/classes/update/{id}")
	public String updateClass(@PathVariable Long id, @ModelAttribute("schoolClass") SchoolClassDTO dto) {
	    schoolClassService.updateClass(id, dto);
	    return "redirect:/classes";
	}


	@GetMapping("/reports")
	public String showReports(Model model) {
		model.addAttribute("reportList", reportService.getAllReports());
		model.addAttribute("report", new ReportDTO());
		return "admin/reports";
	}

	@PostMapping("/reports/save")
	public String saveReport(@ModelAttribute("report") ReportDTO dto) {
		reportService.saveReport(dto);
		return "redirect:/reports";
	}

	@GetMapping("/reports/edit/{id}")
	public String editReport(@PathVariable Long id, Model model) {
		model.addAttribute("reportList", reportService.getAllReports());
		model.addAttribute("report", reportService.getReportById(id));
		return "admin/reports";
	}

	@GetMapping("/reports/delete/{id}")
	public String deleteReport(@PathVariable Long id) {
		reportService.deleteReport(id);
		return "redirect:/reports";
	}

}
