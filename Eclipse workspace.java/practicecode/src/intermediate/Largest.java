package intermediate;

import java.util.Scanner;

public class Largest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number:");
		int num = sc.nextInt();
		int largest = 0;
		while (num > 0) {
			int digit = num % 10;
			if (digit > largest) {
				largest = digit;
			}
			num /= 10;
		}
		System.out.println("largest:" + largest);

	}

}
