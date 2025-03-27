package Student1;

public class Student1 {
	 public static void main(String[] args) {
	     // Creating student objects
	     Student student1 = new Student("Swathi", 101, 85);
	     Student student2 = new Student("Varshini", 102, 35);

	     // Displaying student details
	     System.out.println("Student 1:");
	     student1.displayDetails();

	     System.out.println("\nStudent 2:");
	     student2.displayDetails();
	 }
	}
