package strings;

import java.util.Scanner;

public class ToUppercase {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.nextLine();
		StringBuilder sb=new StringBuilder();
		for(char ch:str.toCharArray()) {
			if(ch >='a' && ch<='z') {
				sb.append((char)(ch - 32));
			}
			else {
				sb.append(ch);
			}
		}
		System.out.println("uppercase:"+sb);
	}
	
	

}
