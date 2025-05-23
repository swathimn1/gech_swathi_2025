package com.geccrud.SpringBootCRUD.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String department;

    // Getters and Setters
    public Long getId() { 
    	return id; 
    	}
    public void setId(Long id) { 
    	this.id = id; 
    	}

    public String getFirstName() { 
    	return firstName; 
    	}
    public void setFirstName(String firstName) {
    	this.firstName = firstName; 
    	}

    public String getLastName() { 
    	return lastName; 
    	}
    public void setLastName(String lastName) { 
    	this.lastName = lastName;
    	}

    public String getEmail() { 
    	return email; 
    	}
    public void setEmail(String email) { 
    	this.email = email; 
    	}

    public String getPhone() { 
    	return phone; 
    	}
    public void setPhone(String phone) {
    	this.phone = phone; 
    	}

    public String getDepartment() { 
    	return department; 
    	}
    public void setDepartment(String department) {
    	this.department = department; 
    	}
	
}

