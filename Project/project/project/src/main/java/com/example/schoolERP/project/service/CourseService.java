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

    // ✅ Fetch all courses (DTO)
    public List<CourseDTO> getAllCourseDTOs() {
        return courseRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ✅ Fetch all courses (Entity)
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // ✅ Fetch course by ID (DTO)
    public CourseDTO getCourseDTOById(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        return course != null ? convertToDTO(course) : null;
    }

    // ✅ Fetch course by ID (Entity)
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // ✅ Save new course from DTO
    public Course saveCourseFromDTO(CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setCode(courseDTO.getCode());

        if (courseDTO.getFacultyName() != null) {
            Faculty faculty = facultyRepository.findByName(courseDTO.getFacultyName());
            if (faculty != null) {
                course.setFaculty(faculty);
            }
        }

        return courseRepository.save(course);
    }

    // ✅ Update course by ID using DTO
    public Course updateCourse(Long id, CourseDTO courseDTO) {
        Course existing = getCourseById(id);
        if (existing != null) {
            existing.setName(courseDTO.getName());
            existing.setCode(courseDTO.getCode());

            if (courseDTO.getFacultyName() != null) {
                Faculty faculty = facultyRepository.findByName(courseDTO.getFacultyName());
                if (faculty != null) {
                    existing.setFaculty(faculty);
                }
            }

            return courseRepository.save(existing);
        }
        return null;
    }

    // ✅ Delete course by ID
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // ✅ Convert Course to CourseDTO
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

    // ✅ Get all courses for a specific faculty by name
    public List<CourseDTO> getCoursesByFacultyName(String facultyName) {
        Faculty faculty = facultyRepository.findByName(facultyName);
        if (faculty == null) return List.of();

        return courseRepository.findByFaculty(faculty)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
