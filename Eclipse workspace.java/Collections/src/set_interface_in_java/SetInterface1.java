package set_interface_in_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class SetInterface1 {

	public static void main(String[] args) {
		/*
		 * Set ========= 
		 * It is a child interface of collection
		 * when u represent a group of individual object into a single
		 * entity where insertion order is not preserved,duplicate values not allowed
		 * ,then we go for a Set Interface.
		 * 
		 * 1.order is not preserved. 2.duplicate values will not allowed 3.random access
		 * is not there 4.to access the values,we have to traverse using for loop,for
		 * each loop,forEach loop and iterator.
		 */
		Set<Integer> st = new HashSet<>();
		st.add(12);
		st.add(14);
		st.add(12);
		st.add(34);
		st.add(14);
		st.add(null);
		st.add(100);
		st.add(null);
		System.out.println(st);
		
		List<Integer>marks=new ArrayList<>();
		marks.add(100);
		marks.add(200);
		marks.add(120);
		marks.add(200);
		marks.add(130);
		marks.add(120);
		System.out.println(marks);
		
		Set<Integer> uniquemarks=new HashSet<Integer>(marks);
		System.out.println(uniquemarks);
		
		Iterator<Integer> iterator=marks.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
