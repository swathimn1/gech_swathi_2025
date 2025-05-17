package com.example.schoolERP.project.service;
import com.example.schoolERP.project.model.Attendance;
import com.example.schoolERP.project.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAttendanceByStudent(Long studentId, LocalDate date) {
        return attendanceRepository.findByStudentIdAndDate(studentId, date);
    }

    public List<Attendance> getAttendanceByTimetable(Long timetableId, LocalDate date) {
        return attendanceRepository.findByTimetableIdAndDate(timetableId, date);
    }

    public void saveAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }
}

