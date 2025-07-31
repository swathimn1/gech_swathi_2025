package encapsulation_in_java;

class Student {
	private String name;
	private int roll;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}
}

public class Encapsulation1 {

	public static void main(String[] args) {
		// Encapsulation:
		/*
		 * Encapsulation is a mechanism that binds the data (variables) and methods that
		 * manipulate the data into a single unit (class).
		 *
		 * - All fields (variables) should be private to restrict direct access. - We
		 * provide public getter and setter methods to control access. - This helps in
		 * data hiding and protects the integrity of the data. (or) -Every fields must
		 * be private when we want to protect data ,so we use encapsulation and create
		 * getters and setters to make it public so that we can set and get the data
		 * ourselves when we create object
		 *
		 * => Even if we don't define a constructor, Java provides a default no-argument
		 * constructor when an object is created. 
		 *it hides the data 
		 */
		Student std = new Student();
		std.setName("Swathi");
		System.out.println(std.getName());
		std.setRoll(54);
		System.out.println(std.getRoll());
	}

}
