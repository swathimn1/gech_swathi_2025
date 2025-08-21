package com.example.schoolERP.project.controller;

import java.security.Principal;
import java.util.List;

import com.example.schoolERP.project.dto.CourseDTO;
import com.example.schoolERP.project.dto.FacultyDTO;
import com.example.schoolERP.project.service.CourseService;
import com.example.schoolERP.project.service.FacultyService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/faculty/courses")
public class Coursecontroller {

    private final CourseService courseService;

    public Coursecontroller(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String listCourses(Model model) {
        List<CourseDTO> courses = courseService.getAllCourseDTOs();
        model.addAttribute("courses", courses);
        return "faculty/courses/view_courses";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("course", new CourseDTO());
        return "faculty/courses/add_courses";
    }

    @PostMapping("/add")
    public String saveCourse(@ModelAttribute("course") CourseDTO courseDTO) {
        courseService.saveCourseFromDTO(courseDTO);
        return "redirect:/faculty/courses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        CourseDTO courseDTO = courseService.getCourseDTOById(id);
        model.addAttribute("course", courseDTO);
        return "faculty/courses/edit_courses";
    }

    @PostMapping("/update/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute("course") CourseDTO courseDTO) {
        courseService.updateCourse(id, courseDTO);
        return "redirect:/faculty/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/faculty/courses";
    }
}
