package com.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetInterfaceDemo {

	public static void main(String[] args) {
		/*
		 * Set ========= when u represent a group of individual object into a single
		 * entity where insertion order is not preserved,duplicate values not allowed
		 * ,then we go for a Set Interface.
		 * 
		 * 1.order is not preserved. 2.duplicate values will not allowed 3.random access
		 * is not there 4.to access the values,we have to traverse using for loop,for
		 * each loop,forEach loop and iterator.
		 */
		Set<Integer> set = new HashSet<Integer>();
		set.add(12);
//		set.add(null);
		set.add(12);
		set.add(30);
		set.add(45);
		set.add(30);
		System.out.println(set);
//		
		for(int num=0;num<set.size();num++) {
		System.out.print(num+" ");
		}
		System.out.println();
	for(int num:set) {
		System.out.print(num+" ");
	}
		System.out.println();
	set.forEach(num->System.out.print(num+" "));	
	System.out.println();

	Iterator<Integer> itr=set.iterator();
	while(itr.hasNext()) {
		//int i=itr.next();
			System.out.print(itr.next()+" ");

	}
	System.out.println();

		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(34);
		System.out.println("List:" + list);

		Set<Integer> set1 = new HashSet<Integer>(list);

		System.out.println("Set1:" + set1);
	}
	

}
