package intermediate;

import java.util.Scanner;

public class SecondLargest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number:");
		int num = sc.nextInt();
		int largest = -1, secondlargest = -1;
		while (num > 0) {
			int digit = num % 10;
			if (digit > largest) {
				secondlargest = largest;
				largest = digit;
			} else if (digit > secondlargest && digit < largest) {
				secondlargest = digit;
			}

			num /= 10;
		}
		System.out.println("secondlargest" +" "+ secondlargest);

	}

}
