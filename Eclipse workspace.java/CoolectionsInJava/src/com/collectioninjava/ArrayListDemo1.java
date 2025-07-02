package com.collectioninjava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(20);
		list.add(10);
		list.add(30);
		list.add(40);
		//to iterate/traverse through each element we use 4 loops like:-for loop,for each, forEach,iterator
		// for loop
		// for (int i = 0; i < list.size(); i++) {
		// 	System.out.print(list.get(i) + " ");
		// }
		// System.out.println();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i)+"");
		}
		System.out.println();

		// 2. for each loop
		// for (int i : list) {

		// 	System.out.print(i + " ");
		// }
		// System.out.println();
		for(int i:list){
			System.out.println(i+"");
		}
		System.out.println();
		
		// 3.forEach
		list.forEach(i-> System.out.print(i + " "));
		System.out.println();
		list.forEach(i->System.out.println(i+""));
		System.out.println();
		
		// 4.iterator
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {  //to check if next element is present or not.
//        	int i=itr.next();//to return the next element.
			System.out.print(itr.next() + " ");
//			System.out.print(i + " ");
		}
		Iterator<Integer>itr1=list.iterator();
		while(itr.hasNext()){
			System.out.println(itr1.next()+"");
		}

	}
}

