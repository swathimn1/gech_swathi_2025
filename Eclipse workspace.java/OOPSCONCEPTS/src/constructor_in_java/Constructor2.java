package constructor_in_java;
class Employee{
	public String name;
	public int age;
	public int employeeId;
	
	public void  isWorking() {
		System.out.println("the employee is working");
	}
	public  Employee(String name,int age,int employeeId) {
		this.name=name;
	    this.age=age;
	    this.employeeId=employeeId;
	}

}

public class Constructor2 {

	public static void main(String[] args) {
		Employee employee=new Employee("Swathi",21,54);
		System.out.println("Name:"+employee.name);
		System.out.println("Age:"+employee.age);
		System.out.println("Employee Id:"+employee.employeeId);
		employee.isWorking();

	}

}
