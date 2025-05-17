package com.example.schoolERP.project.service;

import com.example.schoolERP.project.model.TimeTable;
import com.example.schoolERP.project.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableService {

    @Autowired
    private TimeTableRepository timeTableRepository;

    public List<TimeTable> getAllTimeTables() {
        return timeTableRepository.findAll();
    }

    public List<TimeTable> getTimeTableByFaculty(Long facultyId) {
        return timeTableRepository.findByFaculty_Id(facultyId);
    }

    public List<TimeTable> getTimeTableByClass(Long classId) {
        return timeTableRepository.findBySchoolClass_Id(classId);
    }

    public List<TimeTable> getTimeTableBySubject(Long subjectId) {
        return timeTableRepository.findBySubject_Id(subjectId);
    }

    public TimeTable saveTimeTable(TimeTable timeTable) {
        return timeTableRepository.save(timeTable);
    }

    public void deleteTimeTable(Long id) {
        timeTableRepository.deleteById(id);
    }
}
