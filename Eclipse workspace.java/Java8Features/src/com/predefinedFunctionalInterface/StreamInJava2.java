package com.predefinedFunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamInJava2 {

	public static void main(String[] args) {
		List<String> list=Arrays.asList("one","two","three","four");
		List<String> new_list=list.stream().map((s)->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(new_list);
		List<String> list1=new_list.stream().map((s)->s.toLowerCase()).collect(Collectors.toList());
		System.out.println(list1);
		List<String> list2=list.stream().map((s)->s.replace("four", "five")).collect(Collectors.toList());
		System.out.println(list2);
		
		
		
	}

}
