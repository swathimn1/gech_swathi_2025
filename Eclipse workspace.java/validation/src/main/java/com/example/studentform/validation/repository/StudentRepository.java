package com.example.studentform.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentform.validation.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
