package com.example.schoolERP.project.service;

import com.example.schoolERP.project.model.Attendance;
import com.example.schoolERP.project.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    // ✅ Get all attendance records for a specific faculty
    public List<Attendance> getAttendanceByFaculty(Long facultyId) {
        return attendanceRepository.findByfacultyId(facultyId);
    }

    // ✅ Save attendance record
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // ✅ Get attendance by ID (optional: for edit/view/delete)
    public Optional<Attendance> getById(Long id) {
        return attendanceRepository.findById(id);
    }

    // ✅ Delete attendance record
    public void deleteById(Long id) {
        attendanceRepository.deleteById(id);
    }

    // ✅ Get all attendance (admin or future filtering)
    public List<Attendance> getAll() {
        return attendanceRepository.findAll();
    }

	
}
