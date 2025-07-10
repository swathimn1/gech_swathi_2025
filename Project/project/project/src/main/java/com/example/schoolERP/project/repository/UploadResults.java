package com.example.schoolERP.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadResults extends JpaRepository<UploadResults,Long> {

}
