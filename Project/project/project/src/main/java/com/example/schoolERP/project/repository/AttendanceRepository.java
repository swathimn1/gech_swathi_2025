package com.example.schoolERP.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.schoolERP.project.model.Attendance;
@Repository
public interface AttendanceRepository  extends JpaRepository<Attendance,Long>{
List<Attendance> findByfacultyId(Long facultyId);
}
