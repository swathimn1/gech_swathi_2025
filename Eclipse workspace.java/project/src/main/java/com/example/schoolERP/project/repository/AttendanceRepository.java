package com.example.schoolERP.project.repository;

import com.example.schoolERP.project.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByStudentIdAndDate(Long studentId, LocalDate date);  // Find attendance for a student on a specific date

    List<Attendance> findByTimetableIdAndDate(Long timetableId, LocalDate date);  // Find attendance for a timetable on a specific date
}


