package exceptions;

import java.util.Scanner;

public class Exception3 {

	public static void main(String[] args) {
		//order of catch block child to parent
		Scanner sc = new Scanner(System.in);
		System.out.println("enter first number:");
		int a = sc.nextInt();
		System.out.println("enter second number:");
		int b = sc.nextInt();
		try {
//			int res = a / b;
			String str=null;
			str.toString();
//			System.out.println("The result is:" + res);
		} catch (ArithmeticException e) {
			System.out.println("this is child class");
			System.out.println(e.getMessage());
			System.out.println(e);
		}catch(Exception e) {
			System.out.println("this is parent class");
			System.out.println(e.getMessage());
		}
		System.out.println("End of Program");

	}

}
