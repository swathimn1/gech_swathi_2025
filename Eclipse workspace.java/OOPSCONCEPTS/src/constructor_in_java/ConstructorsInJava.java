package constructor_in_java;

class Student {
	public String name;
	public int roll;

	public Student(String name, int roll) {
		// this keyword is a keyword used to refer a current class object or instance
	   // variables.
		this.name = name;
		this.roll = roll;
	}
}

public class ConstructorsInJava {
	// constructor is a special type of method ,it is used to initialize a instance
	// variables.
	/*
	 * In java, a constructor is a special type of method used to initialize a newly
	 * created object or values to instance variables.
	 * 
	 * *constructor name should be same as the class name *constructor does not have
	 * return type.
	 * 
	 * syntax: ====== access_modifier constructor_name(parameters){ //code } public
	 * ConstructorsInJava(int age){ this.age=age; * java or jvm will provide a
	 * default constructor when you don't create any constructor.
	 */

	public static void main(String[] args) {
		Student std1 = new Student("Swathi", 54);
		System.out.println("Name:" + std1.name);
		System.out.println("Roll:" + std1.roll);

	}

}
