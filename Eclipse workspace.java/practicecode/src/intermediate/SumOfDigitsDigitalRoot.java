package intermediate;

import java.util.Scanner;

public class SumOfDigitsDigitalRoot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number:");
		int num = sc.nextInt();
		while (num > 9) {
			int sum = 0;
			while (num > 0) {

				sum += num % 10;
				num /= 10;
			}
			num = sum;
		}
		System.out.println("Digital root:"+num);
	}

}
