package com.example.schoolERP.project.model;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.DayOfWeek;

import com.example.schoolERP.project.model.Subject;

@Data
@Entity
public class TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private SchoolClass schoolClass;  // Link to the Class entity

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;  // Link to the Teacher entity

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;  // Day of the week

    private String startTime;  // Start time of the class (e.g., "08:00 AM")
    private String endTime;  // End time of the class (e.g., "09:00 AM")

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;  // Link to the Subject entity

}
