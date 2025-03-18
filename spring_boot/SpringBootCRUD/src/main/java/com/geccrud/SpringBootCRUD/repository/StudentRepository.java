package com.geccrud.SpringBootCRUD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geccrud.SpringBootCRUD.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{



}
