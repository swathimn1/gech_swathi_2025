package comparator_in_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

class funInterface implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}
}

public class Comparator1 {
	public static void main(String[] args) {

		List<Integer> marks = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.println("enter " + (i + 1) + " marks");
			marks.add(sc.nextInt());
		}
//		marks.add(14);
//		marks.add(80);
//		marks.add(75);
//		marks.add(70);

		System.out.println("before sorting");
		System.out.println(marks);
		Collections.sort(marks, (o1, o2) -> o2 - o1);
		System.out.println("After sorting:");
		System.out.println(marks);
		System.out.println("using comparator interface");
		Collections.sort(marks, new funInterface());
		System.out.println(marks);

	}
}
