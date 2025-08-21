package intermediate;

import java.util.Scanner;

public class SumOfOddAndEvenDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number:");
		int num = sc.nextInt();
		int sumEven = 0, sumOdd = 0;
		while (num != 0) {
			int digit = num % 10;
			if (num % 2 == 0) {

				sumEven += digit;
			} else {
				sumOdd += digit;
			}
			num /= 10;
		}
		System.out.println("difference:" + (sumOdd - sumEven));

	}

}
