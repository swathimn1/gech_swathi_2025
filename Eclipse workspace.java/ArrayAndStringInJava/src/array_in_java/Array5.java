package array_in_java;

import java.util.Scanner;

public class Array5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("enter the  size of an array");
		int size = sc.nextInt();
		int[] arr = new int[size];

		System.out.println("enter the elements:");
		for (int i = 0; i < size; i++) {

			System.out.println("enter " + (i + 1) + " element:");
			arr[i] = sc.nextInt();

		}
		int max =  arr[0], min=arr[0];
		for (int i = 0; i < size; i++) {
			System.out.println((i + 1) + " element is :" + arr[i]);
			if (arr[i] > max) {
				max = arr[i];

			}
			else {
				if(arr[i]<min) {
					min=arr[i];
				}
			}

		}
		System.out.println("the maximum element in an array:" + max);
		System.out.println("the minimum element in an array:" + min);

	}

}
