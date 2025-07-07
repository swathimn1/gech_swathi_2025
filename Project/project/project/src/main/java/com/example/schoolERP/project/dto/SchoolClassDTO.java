package com.example.schoolERP.project.dto;

import jakarta.persistence.Column;

public class SchoolClassDTO {

    private Long id;
    private String name;
    private String section;
    @Column(name = "total_students")
    private Integer totalStudents;
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
	public Integer getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(Integer totalStudents2) {
		this.totalStudents = totalStudents;
	}


}