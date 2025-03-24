package encapsulation;

class Student {
	private String name;
	private int age;
	private double marks;

	public Student(String name, int age, double marks) {
		System.out.println("Full args constructor");
		this.name = name;
		this.age = age;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public void display() {
		System.out.println("Name:" + this.name);
		System.out.println("Age:" + this.age);
		System.out.println("Marks:" + this.marks);
	}

}

public class EncapsulationInjava {

	public static void main(String[] args) {
		/*
		 * encapsulation =========== Encapsulation is a mechanism that binding the data
		 * into a single unit. i.e., making fields(state) as private and methods as
		 * public using getters and setters.
		 */

		Student std1 = new Student("varshini", 23, 91);
		Student std2 = new Student("praju", 18, 92);
		std1.setName("Swathi");
		std1.getName();
		std1.setAge(21);
		std1.getAge();
		std1.setMarks(90);
		std1.getMarks();
		std1.display();
		std2.display();
		
		
		
		// Encapsulation:
				/*
				 * Encapsulation is a mechanism that binds the data (variables) and methods that
				 * manipulate the data into a single unit (class).
				 *
				 * - All fields (variables) should be private to restrict direct access. - We
				 * provide public getter and setter methods to control access. - This helps in
				 * data hiding and protects the integrity of the data. 
				 * (or) 
				 * -Every feilds must be private when we wnat to protect data ,so we use encapsulation and create
				 * getters and setters to make it public so that we can set and get the data
				 * ourselves when we create object
				 *
				 * => Even if we don't define a constructor, Java provides a default no-argument
				 * constructor when an object is created.
				 */
	}
	

}
