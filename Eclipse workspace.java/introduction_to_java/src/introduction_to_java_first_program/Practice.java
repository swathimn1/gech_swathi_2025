package introduction_to_java_first_program;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		String name=sc.nextLine();
		System.out.println("Enter the student  name:");
		byte age=sc.nextByte();
		System.out.println("Enter the student age:");
		double marks=sc.nextDouble();
		System.out.println("Enter the student marks:");
		char gender=sc.nextLine().charAt(0);
		
		String branch=sc.nextLine();
		String address=sc.nextLine();
		
		
		System.out.println("the name of the student is :"+name);
		
		
		
		
		
		
		System.out.println("The age of the student is :"+age);
		
        
		
        
		System.out.println("The marks of the student is :"+marks);
		
		sc.nextLine();
		System.out.println("Enter the student gender:");
		
		System.out.println("The gender of the student is :"+gender);
		
		System.out.println("Enter the student branch:");
		
		System.out.println("The marks of the student is :"+branch);
		
		System.out.println("Enter the student address:");
		
		System.out.println("The marks of the student is :"+address);
		

	}

}
