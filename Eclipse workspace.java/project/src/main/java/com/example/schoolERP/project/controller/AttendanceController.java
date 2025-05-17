package com.example.schoolERP.project.controller;
import com.example.schoolERP.project.model.Attendance;
import com.example.schoolERP.project.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/admin/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Record attendance for a student
    @PostMapping("/record")
    public String recordAttendance(@ModelAttribute Attendance attendance) {
        attendanceService.saveAttendance(attendance);
        return "redirect:/admin/attendance";
    }

    // View attendance records
    @GetMapping("/student/{studentId}/date/{date}")
    public String viewAttendanceByStudent(@PathVariable Long studentId, @PathVariable LocalDate date, Model model) {
        model.addAttribute("attendance", attendanceService.getAttendanceByStudent(studentId, date));
        return "attendance/view";
    }
}
