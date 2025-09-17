package practicecode;

import java.util.Scanner;

public class PalindromeStringCheck {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter a string:");
//		String str = sc.nextLine();
//		String reversed = new StringBuilder(str).reverse().toString();
//		if (str.equals(reversed)) {
//			System.out.println("Palindrome");
//		} else {
//			System.out.println("Not a Palindrome");
//		}
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.nextLine();
		String reversed=new StringBuilder(str).reverse().toString();
		if(str.equals(reversed)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not a Palindrome");
		}

	}

}
