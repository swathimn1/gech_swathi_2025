package com.example.schoolERP.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.schoolERP.project.model.Course;
import com.example.schoolERP.project.repository.CourseRepository;

@Service
public class CourseService {
	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	 public List<Course> getAllCourses() {
	        return courseRepository.findAll();
	    }
}
