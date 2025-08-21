package predefinedfunctionalinterface;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionInJava {

	public static void main(String[] args) {
		/*
		 * Function:- 
		 * ========= 
		 * it will take a parameter then perform action and return
		 * the value.
		 */
		Function<String, Integer> fun = s -> s.length();
		int res = fun.apply("hello world");
		System.out.println(res);

		Function<String, String> upper = s -> s.toUpperCase();
		String res1 = upper.apply("swathi");
		System.out.println(res1);

		Function<Integer, Integer> square = s -> s * s;
		int res2 = square.apply(20);
		System.out.println(res2);

		Function<Integer, Integer> factorial = i -> fact(i);
		int res3 = factorial.apply(2);
		System.out.println(res3);

		Predicate<Integer> prime = p -> isprime(p);
		boolean res4 = prime.test(6);
		System.out.println(res4);
		
		

	}

	private static Integer fact(int num) {
		int fact = 1;
		if (num == 0 || num == 1) {
			return 1;
		} else {
			return num * fact(num - 1);
		}
	}

	private static Boolean isprime(int num) {
		if (num <= 1) {
			return false;
		} else {
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
