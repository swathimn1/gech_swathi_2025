

package com.geccrud.SpringBootCRUD.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String department;

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
	public void setAddress(Object address) {
		// TODO Auto-generated method stub
		
	}
}

