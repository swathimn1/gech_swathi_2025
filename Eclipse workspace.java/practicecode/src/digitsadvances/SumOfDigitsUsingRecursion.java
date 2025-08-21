package digitsadvances;

public class SumOfDigitsUsingRecursion {
	public static int sumDigits(int num) {
		if (num == 0)
			return 0;
		return num % 10 + sumDigits(num / 10);
	}

	public static void main(String[] args) {
		int num = 9875;
		System.out.println("sum of digits:" + sumDigits(num));

	}

}
