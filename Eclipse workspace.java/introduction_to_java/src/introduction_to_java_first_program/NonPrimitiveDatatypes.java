package introduction_to_java_first_program;

import java.util.Scanner;

public class NonPrimitiveDatatypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Array
		 * 
		 * String
		 * 1.Array:
		 * =======
		 * <datatype>[]arrayname={};
		 * 
		 * 1.String
		 * String name="";
		 * */
//		int[] array1= {1,2,3,4,5};
//		System.out.println(array1[2]);
//		
//		
//		Scanner sc=new Scanner(System.in);
//		String name="";
//		System.out.println(name);
//		System.out.println("enter the student name:");
//		name=sc.nextLine();
//		System.out.println("the name of the student is :"+name);
		
		Scanner sc=new Scanner(System.in);
//		sc.next();
//		sc.nextLine();
		System.out.println("Enter the student  name:");
		String name=sc.nextLine();
		System.out.println("the name of the student is :"+name);
		
		/*
		 * student name-String
		 * student age-byte,int
		 * student marks-double
		 * student gender-char,string
		 * student branch-String
		 * student address-String*/
		
		System.out.println("Enter the student age:");
		
		byte age=sc.nextByte();
		System.out.println("The age of the student is :"+age);
		
        System.out.println("Enter the student marks:");
		
        double marks=sc.nextDouble();
		System.out.println("The marks of the student is :"+marks);
		
		sc.nextLine();
		System.out.println("Enter the student gender:");
		char gender=sc.nextLine().charAt(0); 
		System.out.println("The gender of the student is :"+gender);
		
		System.out.println("Enter the student branch:");
		String branch=sc.nextLine();
		System.out.println("The marks of the student is :"+branch);
		
		System.out.println("Enter the student address:");
		String address=sc.nextLine();
		System.out.println("The marks of the student is :"+address);
		

		

	}

}
