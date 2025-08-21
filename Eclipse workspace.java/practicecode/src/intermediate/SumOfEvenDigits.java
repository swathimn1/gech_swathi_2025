package intermediate;

import java.util.Scanner;

public class SumOfEvenDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number");
		int num = sc.nextInt();
		int sum = 00;
		while (num != 0) {
			int digit = num % 10;
			if (digit % 2 == 0) {
				sum += digit;
			}
			num /= 10;
		}
		System.out.println("Sum of even digits:" + sum);
	}

}
