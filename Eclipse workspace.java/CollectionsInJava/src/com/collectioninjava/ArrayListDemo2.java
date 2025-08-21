package com.collectioninjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(120);
		list.add(10);
		list.add(30);
		list.add(40);
		System.out.println("Before list:" + list);
		/*
		 * Collections: ===== it is a utility class that provide methods to work with
		 * collection
		 */
		Collections.sort(list);
		System.out.println("After list:" + list);
		int min = Collections.min(list);
		System.out.println("Min value:" + min);
		int max = Collections.max(list);
		System.out.println("Max value:" + max);
		Collections.reverse(list);
		System.out.println("reverse order of list:" + list);
	}
	

}
