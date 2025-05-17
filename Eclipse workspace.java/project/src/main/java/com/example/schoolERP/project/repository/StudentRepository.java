package com.example.schoolERP.project.repository;
import com.example.schoolERP.project.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
