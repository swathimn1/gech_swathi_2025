package com.example.schoolERP.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.schoolERP.project.model.UploadResults;

@Repository
public interface UploadResultsRepository extends JpaRepository<UploadResults,Long> {

}
