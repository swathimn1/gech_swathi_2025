package com.example.schoolERP.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.schoolERP.project.model.TimeTable;

public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {
    
    // Find timetable by Faculty ID (since TimeTable has 'faculty' object)
    List<TimeTable> findByFaculty_Id(Long facultyId);

    // Find timetable by Class ID
    List<TimeTable> findBySchoolClass_Id(Long classId);

    // Find timetable by Subject ID
    List<TimeTable> findBySubject_Id(Long subjectId);
}
