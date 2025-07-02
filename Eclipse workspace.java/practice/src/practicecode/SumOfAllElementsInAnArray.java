package practicecode;

import java.util.Scanner;

public class SumOfAllElementsInAnArray {
   public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter the size of an array:");
	   int size=sc.nextInt();
	   int [] arr=new int[size];
	   int sum=0;
	   System.out.println("Enter the elements in an array:");
	   for(int i=0;i<size;i++) {
		   arr[i]=sc.nextInt();
		   sum+=arr[i];
	   }
	   System.out.println("Sum of all the elements:"+sum);
	   
   }
}
