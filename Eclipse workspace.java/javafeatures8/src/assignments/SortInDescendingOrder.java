package assignments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
//1. Sort the list of numbers in Descending order

public class SortInDescendingOrder {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(89, 90, 100, 878, 871);
		List<Integer> sort = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(sort);
		List<Integer> sort1 = numbers.stream().sorted().collect(Collectors.toList());
		System.out.println(sort1);

	}

}
