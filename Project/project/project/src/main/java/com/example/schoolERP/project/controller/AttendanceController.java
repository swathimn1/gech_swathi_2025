package com.example.schoolERP.project.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.schoolERP.project.model.Attendance;
import com.example.schoolERP.project.model.Faculty;
import com.example.schoolERP.project.service.AttendanceService;
import com.example.schoolERP.project.service.FacultyService;


@Controller
@RequestMapping("/faculty/attendance")
public class AttendanceController {
	private final AttendanceService attendanceService;
	private final FacultyService facultyService;
	public AttendanceController(AttendanceService attendanceService, FacultyService facultyService) {
		super();
		this.attendanceService = attendanceService;
		this.facultyService = facultyService;
	}
	@GetMapping
	public String viewAttendance(Model model,Principal principal) {
		Faculty faculty=facultyService.findEntityByEmail(principal.getName());
		List<Attendance> attendanceList = attendanceService.getAttendanceByFaculty(faculty.getId());
        model.addAttribute("attendances", attendanceList);
        return "faculty/attendance/view_attendance";
	}
	@GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("attendance", new Attendance());
        return "faculty/attendance/add_attendance";
    }

    @PostMapping("/add")
    public String saveAttendance(@ModelAttribute Attendance attendance, Principal principal) {
        Faculty faculty = facultyService.findEntityByEmail(principal.getName());
        attendance.setFaculty(faculty);
        attendance.setDate(LocalDate.now());
        attendanceService.save(attendance);
        return "redirect:/faculty/attendance";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Attendance> attendance = attendanceService.getById(id);
        if (attendance.isPresent()) {
            model.addAttribute("attendance", attendance.get());
            return "faculty/attendance/edit_attendance";
        } else {
            throw new IllegalArgumentException("Invalid attendance ID: " + id);
        }
    }


    @PostMapping("/edit/{id}")
    public String updateAttendance(@PathVariable Long id, @ModelAttribute Attendance updatedAttendance) {
        Optional<Attendance> optionalAttendance = attendanceService.getById(id);

        if (optionalAttendance.isPresent()) {
            Attendance existing = optionalAttendance.get();
            existing.setStudentName(updatedAttendance.getStudentName());
            existing.setStatus(updatedAttendance.getStatus());
            // Optional: update date if needed
            attendanceService.save(existing);
        } else {
            throw new IllegalArgumentException("Invalid attendance ID: " + id);
        }

        return "redirect:/faculty/attendance";
    }
    @GetMapping("/delete/{id}")
    public String deleteAttendance(@PathVariable Long id) {
        Optional<Attendance> attendance = attendanceService.getById(id);
        if (attendance.isPresent()) {
            attendanceService.deleteById(id);
        } else {
            throw new IllegalArgumentException("Invalid attendance ID: " + id);
        }
        return "redirect:/faculty/attendance";
    }



	
	

}
