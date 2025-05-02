package com.example.schoolERP.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schoolERP.project.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}