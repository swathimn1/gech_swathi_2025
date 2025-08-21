package intermediate;

import java.util.Scanner;

public class SumOfDigitsDivisibleBy3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number:");
		int num = sc.nextInt();
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		if (sum % 3 == 0) {
			System.out.println("Sum of digits divisible by 3");
		} else {
			System.out.println("Not divisible by 3");
		}

	}

}
