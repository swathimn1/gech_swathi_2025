package strings;

import java.util.Scanner;

public class RemoveAllWhiteSpace {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.nextLine();
		String result=str.replaceAll("\\s+", "");
		System.out.println("After removing spaces:"+result);

	}
	

	
}
