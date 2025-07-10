package com.example.schoolERP.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UploadResults {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private double Grade;
    private int Marks;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGrade() {
		return Grade;
	}
	public void setGrade(double grade) {
		Grade = grade;
	}
	public int getMarks() {
		return Marks;
	}
	public void setMarks(int marks) {
		Marks = marks;
	}
}
