package com.SpringBootCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootCRUD.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
