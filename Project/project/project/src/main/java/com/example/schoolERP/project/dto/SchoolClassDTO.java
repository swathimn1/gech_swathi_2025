package com.example.schoolERP.project.dto;

public class SchoolClassDTO {
    private Long id;
    private String name;
    private String section;
    private String classTeacher;

    // Constructors
    public SchoolClassDTO() {
    }

    public SchoolClassDTO(Long id, String name, String section, String classTeacher) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.classTeacher = classTeacher;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }
}
