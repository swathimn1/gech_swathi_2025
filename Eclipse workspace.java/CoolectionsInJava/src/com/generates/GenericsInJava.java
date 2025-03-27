package com.generates;

import java.util.ArrayList;
import java.util.List;

public class GenericsInJava {

	public static void main(String[] args) {
        /*
         * Generics
         * ======
         * it provides type safety and to avoid type casting in collection then we should go for generics.
         * syntax
         * =======
         * List<type of object>
         * */
		char [] arr= {'a','b','c'};//type safety.
		char firstEle=arr[0];//without type casting.(not required)
		System.out.println(firstEle);
		
		//without generics
		List arr1=new ArrayList();//there is no type safety.
		arr1.add(12);
		arr1.add(10.9);
		arr1.add("swathi");
		
		int value=(int)arr1.get(0);//explicit type casting.
		System.out.println(value);
		
		//generics
		//List<Integer> list=new ArrayList<Integer>();//from java8 it is removed to mention the type of ArrayList.
		List<Integer> list=new ArrayList<>();//type safety
		list.add(12);//0
		list.add(120);//1
		//list.add(10.9);
		int a  = list.get(1);//get method is used to get the elements of an list using the index of that element.
		System.out.println(a);//there is no concept of type casting
		System.out.println(list);
		
		
	}

}
