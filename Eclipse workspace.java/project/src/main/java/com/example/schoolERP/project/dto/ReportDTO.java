package com.example.schoolERP.project.dto;

public class ReportDTO {
    private Long id;
    private String studentName;
    private String grade;
    private String remarks;

    // Constructors
    public ReportDTO() {
    }

    public ReportDTO(Long id, String studentName, String grade, String remarks) {
        this.id = id;
        this.studentName = studentName;
        this.grade = grade;
        this.remarks = remarks;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
