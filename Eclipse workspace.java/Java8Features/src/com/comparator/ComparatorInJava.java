package com.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class funInterface implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
	return o1-o2;
//		return o2-o1;
	}

}

public class ComparatorInJava {

	public static void main(String[] args) {
		
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(12);
		list.add(2);
		list.add(30);
		list.add(3);
		
//		Collections.sort(list,new funInterface());
//		Collections.sort(list,(o1,o2)->o1-o2);
		Collections.sort(list,(a,b)->a-b);
		Collections.sort(list,(a,b)->b-a);
		Collections.sort(list,(o1,o2)->o2-o1);
		System.out.println(list);
        
	}

}
