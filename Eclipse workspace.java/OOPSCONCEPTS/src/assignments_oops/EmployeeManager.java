package assignments_oops;

class Employee {
	public String name;
	public double salary;
	public String department;

	public Employee(String name, double salary, String department) {
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public void displayDetails() {
		System.out.println("this is a method to display the employee details");
	}
}

class Manager extends Employee {
	public int teamSize;

	public Manager(String name, double salary, String department, int teamSize) {
		super(name, salary, department);
		this.teamSize = teamSize;
	}

	public void displayTeamSize() {
		System.out.println("this is a method to display the teamsize");
	}

	@Override
	public void displayDetails() {
		super.displayDetails();
		displayTeamSize();
	}
}

public class EmployeeManager {

	public static void main(String[] args) {
		Employee emp = new Employee("Swathi", 5000, "IT");
		emp.displayDetails();

		Manager manager = new Manager("Varshi", 8000, "IT", 10);

		manager.displayDetails();
	}

}
