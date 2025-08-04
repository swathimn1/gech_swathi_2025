package javainterview;

import java.util.Scanner;

public class FactorialOfANumberUsingRecursion {
	static int factorial(int n) {
		if (n == 0 || n == 1) {

			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number:");
		int num = sc.nextInt();
		if (num < 0) {
			System.out.println("factorial is not used for negative values:");
		} else {
			int result = factorial(num);
			System.out.println("factorial of a number is:" + result);
		}

		sc.close();

	}
	

}
