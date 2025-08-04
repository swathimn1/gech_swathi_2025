package com.example.schoolERP.project.repository;

import com.example.schoolERP.project.model.Course;
import com.example.schoolERP.project.model.Faculty;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findByFaculty(Faculty faculty);

}
