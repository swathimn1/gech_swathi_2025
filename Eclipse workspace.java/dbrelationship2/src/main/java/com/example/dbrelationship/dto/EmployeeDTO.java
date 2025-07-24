package com.example.dbrelationship.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeDTO {
	@NotBlank(message = "name is required")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@Column(unique = true, nullable = false)
	private String email;

	@NotBlank(message = "password is required")
	@Size(min = 6)
	private String password;

	// Change this from String to AddressDTO
	private AddressDTO address;

	private Set<Long> roles = new HashSet<>();
	private Long departmentId;
	private List<Long> taskIds;

	public List<Long> getTaskIds() {
	    return taskIds;
	}

	public void setTaskIds(List<Long> taskIds) {
	    this.taskIds = taskIds;
	}

	private List<String> taskTitles;
	private List<String> taskDescriptions;

	public Long getDepartmentId() {
		return departmentId;
	}

	public List<String> getTaskTitles() {
		return taskTitles;
	}

	public void setTaskTitles(List<String> taskTitles) {
		this.taskTitles = taskTitles;
	}

	public List<String> getTaskDescriptions() {
		return taskDescriptions;
	}

	public void setTaskDescriptions(List<String> taskDescriptions) {
		this.taskDescriptions = taskDescriptions;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	// Getters & Setters
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public Set<Long> getRoles() {
		return roles;
	}

	public void setRoles(Set<Long> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [name=" + name + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", roles=" + roles + ", departmentId=" + departmentId + "]";
	}

	// ✅ Make this static so it can be used without needing an instance of
	// EmployeeDTO
	public static class AddressDTO {
		private String street;
		private String city;
		private String state;

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}
	}

	
}
