package com.collectioninjava;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		/*
		 * ArrayList: ======= Array list is a improved version of array(Dynamic Array) 
		 * 
		 * *Array list underline data structure is Dynamic array(we don't mention the array size in array list it
		 * will automatically increase the array size when we insert automatically
		 * decrease/shrink the array size when we delete ).
		 * 
		 *  Array list allow duplicate
		 *  
		 * array list allow random access(using index). 
		 * Array list will allow null
		 * values. 
		 * Array list will preserve the order of insertion
		 */

		ArrayList<Integer> list = new ArrayList<>();
		list.add(12);//0
		list.add(1);//1
		list.add(1);//2
		list.add(null);//3
		list.add(null);//4
		list.add(34);//5
		list.add(13);//6
		list.add(10);//7
		list.add(11);//8
		list.add(null);//9
		list.add(null);//10
		list.add(345);//11
		System.out.println(list);
		System.out.println(list.get(3));
		
		list.remove(0);
		System.out.println(list);
		list.remove(5);
		Integer i=34;
		list.remove(i);
//		list.clear();
		System.out.println(list);
		ArrayList<Integer> list1=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list1);

	}
	

}
