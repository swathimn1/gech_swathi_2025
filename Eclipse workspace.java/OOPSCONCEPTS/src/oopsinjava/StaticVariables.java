package oopsinjava;

class Employe {
	public static int age;
	public String name;
	public int employeeId; // instance-object instance variables are belongs to object.

	public void isDoingWork() {
		System.out.println("employee is doing work");
	}

	public void isReporting() {
		System.out.println("employee is reporting his work");
	}
}

public class StaticVariables {

	public static void main(String[] args) {
  
  System.out.println(Employe.age);
	}

}
