package com.predefinedFunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsInJava1 {

	public static void main(String[] args) {
       
		List<Integer> list=Arrays.asList(12,13,14,15,16);
		Stream<Integer> stream=list.stream().filter(x->x>10);
//		Long res=stream.count();
//		System.out.println(res);
		List<Integer> result=stream .collect(Collectors.toList());//we cannot reuse it
		System.out.println(result);
//		Long res1=stream.count();
//		System.out.println(res1);//we cannot use same termination function more than once.
	}

}
