package practicecode;

import java.util.Scanner;

public class ReverseAString {

	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.println("enter a string:");
       String str=sc.nextLine();
       String reversed=" ";
       for(int i=str.length()-1;i>=0;i--) {
    	   reversed+=str.charAt(i);
    	   System.out.println("reversed string is:"+reversed);
       }
	}

}
