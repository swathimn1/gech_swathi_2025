package practicecode;

import java.util.Scanner;

public class Sumofalltheelements {

	public static void main(String[] args) {
//       Scanner sc=new Scanner(System.in);
//       System.out.println("Enter a number of elements:");
//       int number=sc.nextInt();
//       
//       int sum=0;
//       for(int i=0;i<number;i++) {
//    	   sum=sum+i;
//    	   System.out.println("Sum of all the elements is :"+sum);
		
//       }
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number:");
		int number=sc.nextInt();
		int sum=0;
		for(int i=0;i<number;i++) {
			sum=sum+i;
			
		}
		System.out.println("sum of all the elements is :"+sum);
       
	}

}
