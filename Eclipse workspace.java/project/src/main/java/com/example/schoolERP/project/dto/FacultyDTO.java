package com.example.schoolERP.project.dto;

public class FacultyDTO {
    private Long id;
    private String name;
    private String subject;
    private String department;
    private String email;

    // Constructors
    public FacultyDTO() {
    }

    public FacultyDTO(Long id, String name, String subject, String department, String email) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.department = department;
        this.email = email;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
