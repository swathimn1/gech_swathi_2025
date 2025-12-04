package com.example.smartevent.repository;

import com.example.smartevent.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByOwnerId(Long ownerId);
}
