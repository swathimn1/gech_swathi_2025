package array_in_java;

import java.util.Scanner;

public class Array2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] std_marks = new int[10];// starting index 0 and ending index n-1 ->10-1=9
		System.out.println("enter the elements");
		for (int i = 0; i <= 9; i++) {

			std_marks[i] = sc.nextInt();
//    	  std_marks[i]=i+10;

		}
		for (int i = 0; i <= 9; i++) {
			System.out.println(i + 1 + " element is :" + std_marks[i]);
		}
	}

}
