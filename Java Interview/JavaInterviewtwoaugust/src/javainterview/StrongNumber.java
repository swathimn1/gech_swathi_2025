package javainterview;

import java.util.Scanner;

public class StrongNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, originalNum, remainder, sum = 0;

		System.out.println("enter a number:");
		num = sc.nextInt();
		originalNum = num;
		while (num > 0) {
			remainder = num % 10;
			sum += fact(remainder);
			num = num / 10;

		}
		if (originalNum == sum) {
			System.out.println(originalNum + " is a strong number");
		} else {
			System.out.println(originalNum + " is not a strong number:");
		}

	}

	public static int fact(int num) {

		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;

		}
	
		return fact;
	}

}
