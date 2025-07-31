package array1_in_java;

import java.util.Scanner;

public class MaxAndMin {

	public static void main(String[] args) {
		int[][] arr = new int[3][4];
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the elements:");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int max = arr[0][0];
		int min = arr[0][0];
		System.out.println("the elements are:");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {

				System.out.print(arr[i][j] + " ");
				if (arr[i][j] > max) {
					max = arr[i][j];
				}
				if (arr[i][j] < min) {
					min = arr[i][j];
				}

			}
			System.out.println();
		}
		System.out.println("the maximum element in an array:" + max);
		System.out.println("the minimum element in an array:" + min);
		sc.close();
	}

}
