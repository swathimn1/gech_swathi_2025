package introduction_to_java_first_program;

import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		int age;
		System.out.println("enter age:");
		Scanner sc = new Scanner(System.in);
		age = sc.nextInt();

		char gender;
		System.out.println("enter gender:");
		gender = sc.next().charAt(0);

		double marks;
		System.out.println("enter marks:");
		marks = sc.nextDouble();
		sc.nextLine();

		String name;
		System.out.println("enter name:");
		name = sc.nextLine();
		
        System.out.println("Student details:");
		System.out.println("Entered age:" + age);
		System.out.println("entered gender:" + gender);
		System.out.println("entered marks :" + marks);
		System.out.println("entered name:" + name);

	}

}
