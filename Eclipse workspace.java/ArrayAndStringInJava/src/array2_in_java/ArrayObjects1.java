package array2_in_java;

import java.util.Scanner;

class Student1 {
	public String name;
	public int roll;
	public String email;
	public String phone_no;
	public String address;
}

public class ArrayObjects1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of an object");
		int size = sc.nextInt();
		Student1[] student = new Student1[size];
		student[0] = new Student1();
		System.out.println("enter the name:");
		student[0].name = sc.next();
		System.out.println("enter the roll no:");
		student[0].roll = sc.nextInt();
		System.out.println("enter the email:");
		student[0].email = sc.next();
		System.out.println("enter the phone no:");
		student[0].phone_no = sc.next();
		System.out.println("enter the address:");
		student[0].address = sc.next();
		System.out.println();

		student[1] = new Student1();
		System.out.println("enter the name:");
		student[1].name = sc.next();
		System.out.println("enter the roll no:");
		student[1].roll = sc.nextInt();
		System.out.println("enter the email:");
		student[1].email = sc.next();
		System.out.println("enter the phone no:");
		student[1].phone_no = sc.next();
		System.out.println("enter the address:");
		student[1].address = sc.next();

		for (int i = 0; i <size; i++) {

			System.out.println("Student's name:" + student[i].name);
			System.out.println("Student's roll:" + student[i].roll);
			System.out.println("Student's email:" + student[i].email);
			System.out.println("Student's phone no:" + student[i].phone_no);
			System.out.println("Student's address:" + student[i].address);
			System.out.println();
		}

	}

}
