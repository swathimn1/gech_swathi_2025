package predefinedfunctionalinterface;

import java.util.function.Predicate;

public class PrimeNumber {

	public static void main(String[] args) {
		Predicate<Integer> isPrime = num -> {
			if (num <= 1)
				return false;
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					return false;
				}
			}
			return true;

		};
		boolean res = isPrime.test(2);
		System.out.println(res);

	}
}
