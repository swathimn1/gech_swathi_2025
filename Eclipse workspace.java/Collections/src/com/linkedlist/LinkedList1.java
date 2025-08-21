package com.linkedlist;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
class Sort implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2-o1;
	}
	
}


public class LinkedList1 implements Comparable<Integer>{

	public static void main(String[] args) {
		/*
		 * LinkedList in Java
		 * ==================
		 * - Underlying data structure is a **Doubly Linked List**
		 * - Allows duplicate values
		 * - Allows null elements
		 * - Preserves insertion order
		 * - Slower random access (access by index) compared to ArrayList
		 *
		 * LinkedList vs ArrayList
		 * ========================
		 * - LinkedList uses more memory (each node stores data + 2 pointers):-it is backed by doubly linked list.
		 * - ArrayList is backed by a dynamic array and uses less memory
		 * 
		 * - LinkedList is preferred when:
		 *     -> Frequent insertions and deletions (especially in the middle or start)
		 *     -> No frequent random access required
		 *
		 * - ArrayList is preferred when:
		 *     -> Frequent random access (get/set by index)
		 *     -> Few insertions/deletions, especially at end
		 *
		 * - Index-based access is **faster in ArrayList** (O(1))
		 * - In LinkedList, access by index is **O(n)** (needs traversal)
		 *
		 * Memory:
		 * - Integer takes 4 bytes, but in LinkedList additional memory is used for next and previous pointers
		 */
		List<Integer> list = new LinkedList<Integer>();
		list.add(22);
		list.add(14);
		list.add(19);
		list.add(20);
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.size());
		System.out.println(list.remove(1));
		System.out.println(list.isEmpty());

		System.out.println(list.containsAll(list));
		System.out.println(list.indexOf(12));

		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.reversed());
		System.out.println(list);
		System.out.println("sorting ascending order");
		Collections.sort(list, (s1,s2)->s1-s2);
		System.out.println(list);
		System.out.println("sorting descending order");
		Collections.sort(list,(s1,s2)->s2-s1);
		System.out.println(list);
		System.out.println("using comparator");
		Collections.sort(list,new Sort());
		System.out.println(list);
		System.out.println("using comparable");
		Collections.sort(list);
		System.out.println(list);
		

		
	}

	@Override
	public int compareTo(Integer o) {
		return this.compareTo(o);
	}
	

}
