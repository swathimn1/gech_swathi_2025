package inheritance;

class Student1 {
	// states
	public int age;
	public String name;
	public double marks;

//	full arguments constructor
	public Student1(int age, String name, double marks) {
		System.out.println("Full arguments constructor");
		this.age = age;
		this.name = name;
		this.marks = marks;
	}

	public Student1() {
		System.out.println("no arguments constructor");
	}

	// actions
	public void isPlaying() {
		System.out.println(this.name + " is playing");
	}

	public void isSleeping() {
		System.out.println(this.name + "is sleeping");
	}

	public void display() {
		System.out.println("Name:" + this.name);
		System.out.println("Age:" + this.age);
		System.out.println("Marks:" + this.marks);

	}

}

public class ConstructorInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student1 std1 = new Student1(21, "swathi", 50.78);
		std1.display();
		Student1 std2 = new Student1();
		std2.display();
	}

}
