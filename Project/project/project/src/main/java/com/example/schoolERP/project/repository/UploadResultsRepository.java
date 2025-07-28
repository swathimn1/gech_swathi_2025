package com.example.schoolERP.project.repository;

import com.example.schoolERP.project.model.UploadResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadResultsRepository extends JpaRepository<UploadResults, Long> {
	
}
