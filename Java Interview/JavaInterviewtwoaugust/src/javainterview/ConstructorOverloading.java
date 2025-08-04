package javainterview;

class Student {
	public String name;
	public int roll_no;
	public double marks;

	public Student(String name) {
		super();
		this.name = name;
		this.roll_no = 0;
		this.marks = 0.0;
	}

	public Student(String name, int roll_no) {
		super();
		this.name = name;
		this.roll_no = roll_no;
		this.marks = 0.0;
	}

	public Student(String name, int roll_no, double marks) {
		super();
		this.name = name;
		this.roll_no = roll_no;
		this.marks = marks;
	}

}

public class ConstructorOverloading {

	public static void main(String[] args) {
		Student std1 = new Student("Swathi");
		Student std2 = new Student("Swathi", 54);
		Student std3 = new Student("Swathi", 54, 95);
		System.out.println("Name:"+std1.name);
		System.out.println("Roll No:"+std1.roll_no);
		System.out.println("marks:"+std1.marks);
		System.out.println();
		System.out.println("Name:"+std2.name);
		System.out.println("Roll No:"+std2.roll_no);
		System.out.println("marks:"+std2.marks);
		System.out.println();
		System.out.println("Name:"+std3.name);
		System.out.println("Roll No:"+std3.roll_no);
		System.out.println("marks:"+std3.marks);
		
	}

}
