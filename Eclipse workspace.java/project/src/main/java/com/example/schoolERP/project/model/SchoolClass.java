package com.example.schoolERP.project.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // Name of the class (e.g., "Class 1", "Class 2")

    @OneToMany(mappedBy = "schoolClass")
    private List<TimeTable> timetables;  // List of timetables for this class

}
