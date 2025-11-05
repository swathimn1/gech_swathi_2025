package arrays;

import java.util.Scanner;

public class FindAllPairs {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of an array:");
		int size = sc.nextInt();
		System.out.println("enter the elemnts:");
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

//		System.out.println("the targeted sum:");
//		int sum=sc.nextInt();
//		System.out.println("Pairs with target sum"+sum+":");
//		boolean found=false;
//		for(int i=0;i<size;i++) {
//			for(int j=i+1;j<size;j++) {
//				if(arr[i]+arr[j]==sum) {
//					System.out.println(arr[i]+","+arr[j]);
//					found=true;
//				}
//			}
//		}
//			if(!found) {
//			System.out.println("No pairs found");
//			}

		System.out.println("enter the targeted sum:");
		int sum = sc.nextInt();
		System.out.println("pairs with targetted sum:" + sum + ":");
		boolean found = false;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] + arr[j] == sum) {
					System.out.println(arr[i] + "," + arr[j]);
					found = true;
				}
			}
		}
		if (!found) {
			System.out.println("No pairs found");
		}
	}

}
