package practicecode;

import java.util.Scanner;

public class Fibo {

	public static void main(String[] args) {
			
//			Scanner sc1=new Scanner(System.in);
//			System.out.println("enter a number:");
//			int number=sc1.nextInt();
//			System.out.println("the fibonacci sequence is:\n");
//			int a=0,b=1;
//			for(int i=0;i<=number;i++) {
//				System.out.println(a);
//				int c=a+b;
//				a=b;
//				b=c;
//			}
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number:");
		int number=sc.nextInt();
		System.out.println("the fibonacci sequence is:\n");
		int a=0,b=1;
		for(int i=0;i<number;i++) {
			System.out.println(a);
			int c=a+b;
			a=b;
			b=c;
		}
			
			
		}
	}
	
	


