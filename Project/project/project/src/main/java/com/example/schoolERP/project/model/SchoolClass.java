package com.example.schoolERP.project.model;

import jakarta.persistence.*;

@Entity
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public void setTotalStudents(Integer totalStudents) {
	    this.totalStudents = totalStudents;
	}


}
