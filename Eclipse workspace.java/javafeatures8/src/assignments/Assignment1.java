package assignments;

import java.util.Arrays;
import java.util.List;

public class Assignment1 {

	public static void main(String[] args) {
      //6. Concatenate all list of strings into single string
		List<String> words=Arrays.asList("h","e","l","l","o");
		String concatenate=words.stream().reduce("",(a,b)->a+b);
		System.out.println(concatenate);
	}

}
