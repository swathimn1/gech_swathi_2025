package com.collectioninjava;

import java.util.ArrayList;
import java.util.List;

public class Listinjava {

	public static void main(String[] args) {
        /*
          *List
         * ================
         * it is a child interface of collection
         * it will contain some of the built in method that used inside a list implemented classes only
         * when you represent  a group of individual object as a single entity where order is preserved and index based access and duplicate is allowed
         * 
         * 
         * 
         * 
         * */
		List list=new ArrayList();
		list.add(2);//0
		list.add("Hello");//1
		list.add(10.67);//2
		System.out.println(list);
		String str=(String) list.get(1);
		System.out.println(str);
		Double value=(double)list.get(2);
		System.out.println(value);
		List list1=new ArrayList();
		list1.add(5);//0
		list1.add("swathi");//1
		list1.add(90.67);//2
		System.out.println(list1);
		int value2=(int)list.get(0);
		System.out.println(value2);
		String str1=(String)list1.get(1);
		System.out.println(str1);
		Double value1=(double)list1.get(2);
		System.out.println(value1);

		List list2=new ArrayList();
		list2.add(5);
		list2.add("swathi");
		list2.add(60.78);
		System.out.println(list);
		System.out.println(list.get(1));
		Object value3=list2.get(3);
		System.out.println(value3);
	
		
		
	}
	
	


	
}