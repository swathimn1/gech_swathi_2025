package method_and_constructor_reference;

import java.util.Arrays;

/*3.Instance Method Reference of an arbitrary object of a particular type
=====================================

Syntax:-
ClassName::InstanceMethodReference*/

public class InstanceMethodreference2 {

	public static void main(String[] args) {
		// without
		String[] names = { "swathi", "nithya", "shwetha", "sinchana" };
		Arrays.sort(names, (a, b) -> a.compareToIgnoreCase(b));
		System.out.println(Arrays.toString(names));

//     //with 
		String[] names1 = { "swathi", "nithya", "shwetha", "sinchana" };
		Arrays.sort(names1, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(names1));
	}

}
