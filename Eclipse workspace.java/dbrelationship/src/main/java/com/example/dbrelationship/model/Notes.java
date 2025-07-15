package com.example.dbrelationship.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="notes")
public class Notes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private long id;
 private String title;
 private String description;
 @ManyToOne
 @JoinColumn(name="user_id")
 private User user;
 
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
 
 
}
