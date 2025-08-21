package collections_in_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortStudent implements Comparator<Student3> {

	@Override
	public int compare(Student3 o1, Student3 o2) {
		// TODO Auto-generated method stub
		return o2.getRoll_no() - o1.getRoll_no();
	}
	

}

class Student3 implements Comparable<Student3> {
	private String name;
	private int age;
	private int roll_no;
	private String email;

	public Student3(String name, int age, int roll_no, String email) {
		super();
		this.name = name;
		this.age = age;
		this.roll_no = roll_no;
		this.email = email;
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

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student3 [name=" + name + ", age=" + age + ", roll_no=" + roll_no + ", email=" + email + "]";
	}

	@Override
	public int compareTo(Student3 o) {

		return this.getRoll_no() - o.getRoll_no();
	}

}

public class CustomObject {

	public static void main(String[] args) {
		Student3 std1 = new Student3("Swathi", 21, 54, "swathi@gmail.com");
		System.out.println(std1);// internally call toString method
		Student3 std2 = new Student3("Varshi", 23, 65, "varshini@gmail.com");
		System.out.println(std2);
		Student3 std3 = new Student3("Praju", 18, 50, "praju@gmail.com");
		System.out.println(std3);
		Student3 std4 = new Student3("Shantha", 38, 57, "shantha@gmail.com");
		System.out.println(std4);

		List<Student3> students = new ArrayList<>();
		students.add(std1);
		students.add(std2);
		students.add(std3);
		students.add(std4);
		System.out.println("before sorting");
		System.out.println(students);
		System.out.println();
		Collections.sort(students, new SortStudent());
		System.out.println("after sorting");
		System.out.println(students);

		System.out.println();
		// using comparable
		System.out.println("using comaparable");
		Collections.sort(students);
		System.out.println(students);
		System.out.println();

		System.out.println("using comparator after java 8 using comparator");
		// sorting in ascending order
		// After java 8 using comparator
		Collections.sort(students, (s1, s2) -> s1.getRoll_no() - s2.getRoll_no());
		System.out.println(students);
		System.out.println();

		// sorting in descending order
		System.out.println("sorting in descending order using comparator");
		Collections.sort(students, (s1, s2) -> s2.getRoll_no() - s1.getRoll_no());
		System.out.println(students);

	}

}
