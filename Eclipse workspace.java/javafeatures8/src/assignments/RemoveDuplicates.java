package assignments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//2. Remove the Duplicate elements from list
public class RemoveDuplicates {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(89, 87, 87, 67, 56);
		List<Integer> distinct = list.stream().distinct().collect(Collectors.toList());
		System.out.println(distinct);

	}

}
