package arrays;

import java.util.Scanner;

public class MaximumSubArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of an array:");
		int size=sc.nextInt();
		System.out.println("enter the elements:");
		int [] arr=new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
		}
		int currentMax=arr[0];
		int maxSofar=arr[0];
		for(int i=0;i<size;i++) {
		currentMax=	Math.max(arr[i],arr[i]+currentMax);
		
			maxSofar=Math.max(maxSofar, currentMax);
		}
		System.out.println("maximum subarray:"+maxSofar);

	}
	

}
