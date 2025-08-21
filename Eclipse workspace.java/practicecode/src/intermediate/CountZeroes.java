package intermediate;

import java.util.Scanner;

public class CountZeroes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number:");
		int num = sc.nextInt();
		int count = 0;
		while (num != 0) {
			if (num % 10 == 0) {
				count++;
			}
			num /= 10;
		}
		System.out.println("Number of zeroes:" + count);
	}

}
