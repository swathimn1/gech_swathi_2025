package array_in_java;

import java.util.Scanner;

public class Array3 {
public static void main(String[] args) {
	int sum=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the size of an array");
	int size=sc.nextInt();
	int [] arr=new int[size];
	System.out.println("enter the elements");
	for(int  i=0;i<arr.length;i++) {
		
      System.out.println("enter "+ (i+1)+" element:");
		arr[i]=sc.nextInt();
		
		  
	}
	for(int i=0;i<arr.length;i++) {
		System.out.println((i+1)+" element  is :"+ arr[i]);
		
	}
	sc.close();
}
}
