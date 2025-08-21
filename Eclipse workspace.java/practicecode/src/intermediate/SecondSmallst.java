package intermediate;

import java.util.Scanner;

public class SecondSmallst {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number");
		int n = sc.nextInt();
		int smallest = 9;
		int secondsmallest = 9;
		while (n != 0) {
			int digit = n % 10;
			if (digit < smallest) {
				secondsmallest = smallest;
				smallest = digit;
			} else if (digit > smallest && digit < secondsmallest) {
				secondsmallest = digit;
			}
			n /= 10;
		}
		if (secondsmallest == 9) {
			System.out.println("No second smallest digit");
		} else {
			System.out.println("Second smallest digit:" + secondsmallest);
		}

	}

}
