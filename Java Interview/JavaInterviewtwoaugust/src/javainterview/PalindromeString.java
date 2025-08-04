package javainterview;

import java.util.Scanner;

public class PalindromeString {

	public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("enter a string:");
      String str=sc.nextLine();
      String reverse=" ";
      reverse =new StringBuilder(str).reverse().toString();
      if(str.equals(reverse)) {
    	  System.out.println("the reversed string is :"+reverse);
      }
      else {
    	  System.out.println("the string is not reversed:"+reverse);
      }
      
      
	}
	

}
