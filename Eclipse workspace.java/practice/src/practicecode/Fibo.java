package practicecode;

import java.util.Scanner;

public class Fibo {

	public static void main(String[] args) {
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("enter the number of terms:");
//		int number=sc.nextInt();
//		int a=0,b=1,c;
//		System.out.println("Fibonacci sequence is:");
//		for(int i=0;i<=number;i++) {
//			System.out.println(a+" ");
//			c=a+b;
//			a=b;
//			b=c;
//		}
//		Scanner sc=new Scanner(System.in);
//		
//		System.out.println("enter the number of terms:");
//		int number=sc.nextInt();
//		int a=0,b=1,c;
//		System.out.println("The fibonacci sequence is:\n");
//		for(int i=0;i<=number;i++) {
//			System.out.println(a);
//			c=a+b;
//			a=b;
//			b=c;
			
			Scanner sc1=new Scanner(System.in);
			System.out.println("enter a number:");
			int number=sc1.nextInt();
			System.out.println("the fibonacci sequence is:\n");
			int a=0,b=1;
			for(int i=0;i<=number;i++) {
				System.out.println(a);
				int c=a+b;
				a=b;
				b=c;
			}
			
			
		}
	}
	
	


