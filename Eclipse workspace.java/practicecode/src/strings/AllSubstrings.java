package strings;

import java.util.Scanner;

public class AllSubstrings {

	public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     System.out.println("enter a string");
     String str=sc.nextLine();
     System.out.println("all substrings:");
     for(int i=0;i<str.length();i++) {
    	 for(int j=i+1;j<=str.length();j++) {
    		 System.out.println(str.substring(i,j));
    	 }
     }
	}
	

}
