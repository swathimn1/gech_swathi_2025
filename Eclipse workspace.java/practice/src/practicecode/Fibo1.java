package practicecode;

import java.util.Scanner;

public class Fibo1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number:");
		int number=sc.nextInt();
		System.out.println("The fibonacci sequence is :");
		int a=0,b=1,c;
		for(int i=0;i<=number;i++) {
			System.out.println(a+" ");
			c=a+b;
			System.out.println(c+" ");
			a=b;
			b=c;
		}
	}

}
