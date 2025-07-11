package com.springsecurity.assignment1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.assignment1.model.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long>{

}
