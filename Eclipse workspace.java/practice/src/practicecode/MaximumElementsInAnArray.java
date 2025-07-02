package practicecode;

import java.util.Scanner;

public class MaximumElementsInAnArray {
   public static void main(String [] args) {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("enter a size:");
	   int size=sc.nextInt();
	   int arr []=new int[5];
	   System.out.println("enter the  elements:");
	   for(int i=0;i<size;i++) {
		   arr[i]=sc.nextInt();
	   }
	   int max=arr[0];
	   for( int num:arr) {
		   if(num>max) {
			   max=num;
		   }
		   
		   
	   }
	   System.out.println("Maximum element in an array is:"+max);
   }
} 
