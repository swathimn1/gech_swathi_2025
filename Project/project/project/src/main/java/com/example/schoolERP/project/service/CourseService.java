package com.example.schoolERP.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.schoolERP.project.dto.CourseDTO;
import com.example.schoolERP.project.model.Course;
import com.example.schoolERP.project.model.Faculty;
import com.example.schoolERP.project.repository.CourseRepository;
import com.example.schoolERP.project.repository.FacultyRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final FacultyRepository facultyRepository;

    public CourseService(CourseRepository courseRepository, FacultyRepository facultyRepository) {
        this.courseRepository = courseRepository;
        this.facultyRepository = facultyRepository;
    }

    // Fetch all Course entities
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Fetch all CourseDTOs
    public List<CourseDTO> getAllCourseDTOs() {
        return courseRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Save course using entity
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // Save course using DTO
    public Course saveCourseFromDTO(CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setCode(courseDTO.getCode());

        // Map faculty by name (or use ID if available)
        if (courseDTO.getFacultyName() != null) {
            Faculty faculty = facultyRepository.findByName(courseDTO.getFacultyName());
            if (faculty != null) {
                course.setFaculty(faculty);
            }
        }
        

        return courseRepository.save(course);
    }

    // Get course by ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // Update course
    public Course updateCourse(Long id, CourseDTO courseDTO) {
        Course existingCourse = getCourseById(id);
        if (existingCourse != null) {
            existingCourse.setName(courseDTO.getName());
            existingCourse.setCode(courseDTO.getCode());

            if (courseDTO.getFacultyName() != null) {
                Faculty faculty = facultyRepository.findByName(courseDTO.getFacultyName());
                if (faculty != null) {
                    existingCourse.setFaculty(faculty);
                }
            }

            return courseRepository.save(existingCourse);
        }
        return null;
    }

    // Delete course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // Convert Course entity to CourseDTO
    private CourseDTO convertToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setCode(course.getCode());

        if (course.getFaculty() != null) {
            dto.setFacultyName(course.getFaculty().getName());
            dto.setDepartment(course.getFaculty().getDepartment());
        }

        return dto;
    }
 // Fetch courses by faculty name
    public List<CourseDTO> getCoursesByFacultyName(String facultyName) {
        Faculty faculty = facultyRepository.findByName(facultyName);
        if (faculty == null) return List.of();

        return courseRepository.findByFaculty(faculty)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

}
