package arrays;

import java.util.Scanner;

public class LinearSearch {
	public static int LinearSearch(int arr[],int target) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target) {
				return i;
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a size");
		int size=sc.nextInt();
		
		int [] arr=new int[size];
		System.out.println("enter the elements:");
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("enter a target");
		int target=sc.nextInt();
		int result=LinearSearch(arr,target);
		System.out.println(result);
		
		
		
		

	}

}
