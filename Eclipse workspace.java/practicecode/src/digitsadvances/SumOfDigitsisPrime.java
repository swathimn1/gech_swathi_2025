package digitsadvances;

public class SumOfDigitsisPrime {
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		int num = 1234;
		int sum = 0;
		while (num > 0) {

			sum += num % 10;
			num /= 10;
		}
		System.out.println(isPrime(sum) ? "Sum is prime" : "sum is not a prime");

	}

}
