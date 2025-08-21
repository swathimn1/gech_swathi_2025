package intermediate;

import java.util.Scanner;

public class AllOdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number");
		int num = sc.nextInt();
		boolean allodd = true;
		while (num != 0) {
			if ((num % 10) % 2 == 0) {
				allodd = false;
				break;
			}
			num /= 10;
		}
		if (allodd) {
			System.out.println("Contains only odd numbers");
		} else {
			System.out.println("Contains even numbers");
		}

	}

}
