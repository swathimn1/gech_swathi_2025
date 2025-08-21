package collections_in_java;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList4 {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(10);
		arr.add(14);
		arr.add(30);
		arr.add(5);
		arr.add(25);

		// 1.comparable-if you need default or natural sorting order ,we should go for a
		// comparable interface.
		Collections.sort(arr);
		System.out.println("using comparable:" + arr);

		// 2.comparator-if you need custom sorting order ,we should go for a comparator
		// interface.
		Collections.sort(arr, (a1, a2) -> a2 - a1);
		// if equal return 0,if +ve ->return +ve or >0 value ,if - ve or <0  ->return - ve value

		/*
		 * compare() Method: The core of the Comparator interface is the compare(T o1, To2) method. 
		 * This method takes two objects of the same type (T) as arguments and returns: 
		 *     A negative integer if o1 should come before o2. 
		 *     Zero if o1 and o2 are considered equal for sorting purposes. 
		 *     A positive integer if o1 should come after o2.
		 */
		System.out.println("using comparator:" + arr);

	}

}
