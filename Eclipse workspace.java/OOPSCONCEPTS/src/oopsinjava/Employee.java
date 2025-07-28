package oopsinjava;

class Employees {
	public int age;
	public String name;
	public int employeeId;   //instance-object ,instance variables are belongs to object.

	public void isDoingWork() {
		System.out.println("employee is doing work");
	}

	public void isReporting() {
		System.out.println("employee is reporting his work");
	}
}

public class Employee {

	public static void main(String[] args) {
		Employees employee1 = new Employees();
		employee1.name = "Swathi";
		employee1.age = 21;
		employee1.employeeId = 54;

		System.out.println("name:" + employee1.name);
		System.out.println("age:" + employee1.age);
		System.out.println("employeeId:" + employee1.employeeId);
		employee1.isDoingWork();

		Employees employee2 = new Employees();
		employee2.name = "Varshini";
		employee2.age = 23;
		employee2.employeeId = 65;
		System.out.println();
		System.out.println("name:" + employee2.name);
		System.out.println("age:" + employee2.age);
		System.out.println("employeeId:" + employee2.employeeId);

		employee2.isReporting();
	}

}
