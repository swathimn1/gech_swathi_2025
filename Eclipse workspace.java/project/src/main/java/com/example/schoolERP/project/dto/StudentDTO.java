package com.example.schoolERP.project.dto;
public class StudentDTO {
    private Long id;
    private String name;
    private String studentClass;
    private String section;
    private String email;

    // Constructors
    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String studentClass, String section, String email) {
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
        this.section = section;
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

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

