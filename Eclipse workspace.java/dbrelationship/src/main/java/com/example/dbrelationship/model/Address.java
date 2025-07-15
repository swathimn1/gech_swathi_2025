package com.example.dbrelationship.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private long id;
 private String address;
 @OneToOne
 @JoinColumn(name="user_id")
 private User user;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
}
