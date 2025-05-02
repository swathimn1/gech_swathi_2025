package com.example.schoolERP.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schoolERP.project.model.SchoolClass;


public interface ClassRepository extends JpaRepository<SchoolClass, Long> {}
