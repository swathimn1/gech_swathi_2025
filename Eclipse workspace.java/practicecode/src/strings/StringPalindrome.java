package strings;

import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.nextLine();
		String reversed=new StringBuilder(str).reverse().toString();
		if(str.equalsIgnoreCase(reversed)) {
			System.out.println("palindrome");
		}
		else {
			System.out.println("not a palindrome");
		}
	}
	
	

}
