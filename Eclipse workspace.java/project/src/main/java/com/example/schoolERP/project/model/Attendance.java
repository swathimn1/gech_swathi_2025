package com.example.schoolERP.project.model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;  // Link to the Student entity

    @ManyToOne
    @JoinColumn(name = "timetable_id", nullable = false)
    private TimeTable timetable;  // Link to the Timetable entity

    @Column(nullable = false)
    private boolean present;  // Whether the student was present or not

    private LocalDate date;  // The date for which the attendance is recorded
}
    

