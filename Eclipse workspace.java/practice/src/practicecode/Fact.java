package practicecode;

import java.util.Scanner;

public class Fact {
	public static void main(String [] args) {
	    
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number:");
		int num=sc.nextInt();
		int fact=1;
		for(int i=1;i<=num;i++) {
			fact*=i;
			System.out.println(fact);
		}
	}

}
