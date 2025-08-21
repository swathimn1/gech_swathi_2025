package strings;

import java.util.Scanner;

public class NaivePatternMatching {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a text:");
		String text=sc.nextLine();
		System.out.println("enter a pattern:");
		String pattern=sc.nextLine();
		for(int i=0;i<=text.length()-pattern.length();i++) {
			int j;
			for( j=0;j<pattern.length();j++) {
				if(text.charAt(i+j)!=pattern.charAt(j)) {
					break;
				}
				
		}
			if(j==pattern.length()) {
				System.out.println("pattern found at index:"+i);
			}
		}
		
		

	}
	

}
