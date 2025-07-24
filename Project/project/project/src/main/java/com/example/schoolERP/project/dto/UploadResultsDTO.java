package com.example.schoolERP.project.dto;

public class UploadResultsDTO {
   private long id;
   private String name;
   private int Marks;
   private double Grade;
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
public int getMarks() {
	return Marks;
}
public void setMarks(int marks) {
	Marks = marks;
}
public double getGrade() {
	return Grade;
}
public void setGrade(double grade) {
	Grade = grade;
}
   
}
