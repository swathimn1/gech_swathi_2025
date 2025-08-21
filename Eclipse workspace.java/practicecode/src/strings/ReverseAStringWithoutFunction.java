package strings;

import java.util.Scanner;

public class ReverseAStringWithoutFunction {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.nextLine();
		char[] chars=str.toCharArray();
		int start=0,end=str.length()-1;
		while(start<end) {
			char temp=chars[start];
			chars[start]=chars[end];
			chars[end]=temp;
			start++;
			end--;
		}
		System.out.println("reversed string:"+new String(chars));
	}
	

	
}
