package array_in_java;

import java.util.Scanner;

public class Array4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("enter the  size of an array");
		int size = sc.nextInt();
		int[] arr = new int[size];
		int sum = 0;
		System.out.println("enter the elements:");
		for (int i = 0; i < size; i++) {

			System.out.println("enter " + (i + 1) + " element:");
			arr[i] = sc.nextInt();
			sum += arr[i];

		}
		for (int i = 0; i < size; i++) {
			System.out.println((i + 1) + " element is :" + arr[i]);

		}
		System.out.println("the sum of all the elements in an array:" + sum);

	}

}
