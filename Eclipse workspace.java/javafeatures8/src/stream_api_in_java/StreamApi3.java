package stream_api_in_java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi3 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("swathi", "nithya", "sinchana", "shwetha");
		names.stream().filter(name -> name.startsWith("s")).forEach(System.out::println);
		List<String> collect = names.stream().filter(name -> name.startsWith("s")).collect(Collectors.toList());
		System.out.println(collect);
//		names.stream().filter(StreamApi3::startsWith).collect(Collectors.toList());


//		List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
//		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
//		System.out.println(sum);

		List<Integer> num = Arrays.asList(18, 8, 9, 6, 17);
		List<Integer> result=num.stream().filter(n -> n > 10).map(n -> n * n).collect(Collectors.toList());
		System.out.println(result);

	}

}
