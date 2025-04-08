package com.registration.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class DTO {

    @NotBlank(message = "Student name is required")
    private String name;

    @NotBlank(message = "Student email is required")
    @Email(message = "Enter a valid email")
    private String email;

    @NotBlank(message = "Student phone is required")
    private String phone;

    @Min(value = 10, message = "Age must be at least 10")
    private int age;

    @NotBlank(message = "Student dob is required")
    private String dob;

    @NotBlank(message = "Student city is required")
    private String city;

    @NotBlank(message = "Student gender is required")
    private String gender;

    @NotEmpty(message = "Student skill is required")
    private List<String> skill;

    @NotBlank(message = "Student address is required")
    private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getSkill() {
		return skill;
	}

	public void setSkill(List<String> skill) {
		this.skill = skill;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



    
}
