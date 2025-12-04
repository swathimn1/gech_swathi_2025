package com.example.smartevent.repository;

import com.example.smartevent.models.UploadResults;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UploadResultRepository extends JpaRepository<UploadResults, Long> {
    List<UploadResults> findByOwnerId(Long ownerId);
}
