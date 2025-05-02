package com.example.schoolERP.project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schoolERP.project.model.Faculty;
import com.example.schoolERP.project.model.Report;
import com.example.schoolERP.project.model.SchoolClass;
import com.example.schoolERP.project.model.Student;
import com.example.schoolERP.project.repository.ClassRepository;
import com.example.schoolERP.project.repository.FacultyRepository;
import com.example.schoolERP.project.repository.ReportRepository;
import com.example.schoolERP.project.repository.StudentRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SchoolERPController {

    @Autowired private StudentRepository studentRepo;
    @Autowired private FacultyRepository facultyRepo;
    @Autowired private ClassRepository classRepo;
    @Autowired private ReportRepository reportRepo;
    @GetMapping({" ","/"})
    public String home() {
    	return "home";
    }

    // Students
    @PostMapping("/students/add")
    public Student addStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // Faculty
    @PostMapping("/faculty/add")
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyRepo.save(faculty);
    }

    @GetMapping("/faculty")
    public List<Faculty> getAllFaculty() {
        return facultyRepo.findAll();
    }

    // Classes
    @PostMapping("/classes/add")
    public SchoolClass addClass(@RequestBody SchoolClass schoolClass) {
        return classRepo.save(schoolClass);
    }

    @GetMapping("/classes")
    public List<SchoolClass> getAllClasses() {
        return classRepo.findAll();
    }

    // Reports
    @PostMapping("/reports/add")
    public Report addReport(@RequestBody Report report) {
        return reportRepo.save(report);
    }

    @GetMapping("/reports")
    public List<Report> getAllReports() {
        return reportRepo.findAll();
    }
}