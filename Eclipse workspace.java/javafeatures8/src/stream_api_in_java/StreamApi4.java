package stream_api_in_java;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi4 {

	public static void main(String[] args) {
		List<List<Integer>> aslist = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
		System.out.println("Before:" + aslist);
		System.out.println(aslist.get(0));
		System.out.println(aslist.get(0).get(0));
		List<Integer> flattenedList = aslist.stream().flatMap(c -> c.stream()).collect(Collectors.toList());
		List<Integer> flattenedList1 = aslist.stream().flatMap(Collection::stream).collect(Collectors.toList());
		
		System.out.println("After:" + flattenedList);
		System.out.println("After:" + flattenedList1);
		
	}

}
