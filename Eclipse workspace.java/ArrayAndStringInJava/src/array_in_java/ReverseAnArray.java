package array_in_java;

import java.util.Scanner;

public class ReverseAnArray {
	public static void main(String[] args) {
//		int temp;
//
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("enter the  size of an array");
//		int size = sc.nextInt();
//		int[] arr = new int[size];
//
//		System.out.println("enter the elements:");
//		for (int i = 0; i < size; i++) {
//
//			System.out.println("enter " + (i + 1) + " element:");
//			arr[i] = sc.nextInt();
//
//		}
//		
//		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
//		    temp = arr[i];
//		    arr[i] = arr[j];
//		    arr[j] = temp;
//		}
//		
//
//		
//		System.out.println("the reversed array is :");
//		for (int k = 0; k < arr.length; k++) {
//			System.out.println((k + 1) + " element is :" + arr[k]);
//		}
		int temp;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of an array");
		int size=sc.nextInt();
		int [] arr=new int[size];
		System.out.println("enter the elements:");
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
		}
		for(int i=0,j=arr.length-1;i<j;i++,j--) {
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		System.out.println("the reversed array is:");
		for(int i=0;i<size;i++) {
			System.out.println(arr[i]);
		}
	}
}
