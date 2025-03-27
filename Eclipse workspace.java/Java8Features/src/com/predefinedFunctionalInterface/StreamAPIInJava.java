package com.predefinedFunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIInJava {

	public static void main(String[] args) {
         
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(35);
		list.add(40);
		System.out.println(list);
		
//	    list.stream().filter(x->x%2==0).count();
		System.out.println(list.stream().filter(x->x%2==0).count());
		//i need to filter the odd numbers from the list and generate a list
		
		Stream<Integer> stream=list.stream();
		List<Integer> numbers=stream.filter((i)->i%2!=0).collect(Collectors.toList());
		System.out.println(numbers);
		
		
		List<Integer> numbers2=list.stream().filter((i)->i%2!=0).collect(Collectors.toList());
		System.out.println(numbers2);
		List<Integer> numbers1=list.stream().filter((i)->i%2==0).collect(Collectors.toList());
		System.out.println(numbers1);
		
		
		
	}

}
