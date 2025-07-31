package array1_in_java;

import java.util.Scanner;

public class TrianglePattern {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the numbers of rows:");
		int rows = sc.nextInt();


		System.out.println("The elements are :");
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	

}
