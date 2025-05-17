package com.example.schoolERP.project.controller;

import com.example.schoolERP.project.model.TimeTable;
import com.example.schoolERP.project.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetable")
public class TimeTableController {

    @Autowired
    private TimeTableService timeTableService;

    @GetMapping
    public List<TimeTable> getAllTimeTables() {
        return timeTableService.getAllTimeTables();
    }

    @GetMapping("/faculty/{facultyId}")
    public List<TimeTable> getTimeTableByFaculty(@PathVariable Long facultyId) {
        return timeTableService.getTimeTableByFaculty(facultyId);
    }

    @GetMapping("/class/{classId}")
    public List<TimeTable> getTimeTableByClass(@PathVariable Long classId) {
        return timeTableService.getTimeTableByClass(classId);
    }

    @GetMapping("/subject/{subjectId}")
    public List<TimeTable> getTimeTableBySubject(@PathVariable Long subjectId) {
        return timeTableService.getTimeTableBySubject(subjectId);
    }

    @PostMapping
    public TimeTable createTimeTable(@RequestBody TimeTable timeTable) {
        return timeTableService.saveTimeTable(timeTable);
    }

    @DeleteMapping("/{id}")
    public void deleteTimeTable(@PathVariable Long id) {
        timeTableService.deleteTimeTable(id);
    }
}
