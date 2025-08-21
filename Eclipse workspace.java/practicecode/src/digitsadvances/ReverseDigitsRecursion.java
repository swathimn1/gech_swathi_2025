package digitsadvances;

public class ReverseDigitsRecursion {
	public static int ReverseDigits(int num, int rev) {
		if (num == 0)
			return rev;
		return ReverseDigits(num / 10, rev * 10 + num % 10);
	}

	public static void main(String[] args) {
		int num = 1234;

		System.out.println("Reverse:" + ReverseDigits(num, 0));
	}

}
