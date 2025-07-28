package com.example.schoolERP.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "upload_results")
public class UploadResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Marks are required")
    @Min(value = 0, message = "Marks must be at least 0")
    @Max(value = 100, message = "Marks cannot exceed 100")
    private Integer marks;

    @NotBlank(message = "Grade is required")
    @Pattern(regexp = "^[A-F][+-]?$", message = "Grade must be in format A-F (e.g., A, B+, C-)")
    private String grade;

    // Constructors
    public UploadResults() {}

    public UploadResults(String name, Integer marks, String grade) {
        this.name = name;
        this.marks = marks;
        this.grade = grade;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
