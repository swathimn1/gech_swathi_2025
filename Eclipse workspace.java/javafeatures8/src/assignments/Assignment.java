package assignments;

import java.util.Arrays;
import java.util.List;

public class Assignment {

	public static void main(String[] args) {
		// 7.Check if any numbers in the list is greater than 100
		List<Integer> numbers = Arrays.asList(10, 120, 89, 78, 89, 90);
		boolean result = numbers.stream().anyMatch(n -> n > 100);
		System.out.println(result);

		// 8. Check if all the numbers in the list are greater than 100
		boolean result1 = numbers.stream().allMatch(n -> n > 100);
		System.out.println(result1);

	}

}
