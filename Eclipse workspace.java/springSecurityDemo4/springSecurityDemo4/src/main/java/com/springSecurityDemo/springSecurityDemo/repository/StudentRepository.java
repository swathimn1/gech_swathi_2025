package com.springSecurityDemo.springSecurityDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springSecurityDemo.springSecurityDemo.models.StudentModels;

@Repository
public interface StudentRepository extends  JpaRepository<StudentModels, Long> {
	 Optional<StudentModels> findByEmail(String email);
}
;