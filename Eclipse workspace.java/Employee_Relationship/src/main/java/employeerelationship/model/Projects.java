package employeerelationship.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Projects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employee = new ArrayList<>();

	public Projects(Long id, String name, List<Employee> employee) {
		super();
		this.id = id;
		this.name = name;
		this.employee = employee;
	}

	public Projects() {
		super();
	}

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

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	/**
	 * According to POJO(Plain Old Java Object) class-
	 * The fields in the entity class should be private
	 * have getters and setters
	 * have no-args constructor
	 * have full-args constructors
	 * */
}
