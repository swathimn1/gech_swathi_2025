package stream_api_in_java;

import java.util.Arrays;
import java.util.List;

public class StreamApi1 {

	public static void main(String[] args) {
		List<String> names=Arrays.asList("Swathi","Shwetha","Nithya");
		names.stream().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println();
		List<String> names1=Arrays.asList("Swathi","Shwetha","Nithya");
		names1.stream().map(String::toUpperCase).forEach(System.out::println);
		

	}

}
