package practicecode;

import java.util.Scanner;

public class Fibonacci {
 public static void main(String [] args) {
	 
	 Scanner  sc=new Scanner(System.in);
	 System.out.println("enter the number of terms:");
	 int num=sc.nextInt();
	 int a=0,b=1,c;
	 System.out.println("the fibonacci sequence is :");
	 for(int i=0;i<=num;i++) {
		 System.out.println(a);
		 c=a+b;
		 a=b;
		 b=c;
	 }
 }
}
