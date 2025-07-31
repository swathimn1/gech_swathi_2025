package array2_in_java;

class Student {
	public String name;

	public int roll;
}

public class ArrayObjects {
	public static void main(String[] args) {
		Student[] students = new Student[2];
		students[0] = new Student();
		students[0].name = "swathi";
		students[0].roll = 54;
		students[1] = new Student();
		students[1].name = "varshi";
		students[1].roll = 65;
		for (int i = 0; i < 2; i++) {
			System.out.println("Student's name:" + students[i].name);
			System.out.println("Student's roll:" + students[i].roll);
		}

	}

}
