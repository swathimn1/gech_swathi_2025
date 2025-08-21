package assignments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MaxInaList {

	public static void main(String[] args) {
		//3. Find the Maximum element in List
		List<Integer> num = Arrays.asList(67, 56, 89, 90, 100, 67);
		int max = num.stream().max(Integer::compare).get();
		System.out.println(max);

		// 4.SeconMaxelement
		int secondMax = num.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(secondMax);

		// 5.Calculate the sum of elements in the list
		int sum = num.stream().reduce(0, Integer::sum);
		System.out.println(sum);

	}

}
