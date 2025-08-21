package collections_in_java;

import java.util.ArrayList;
import java.util.Collection;

public class Collection2 {

	public static void main(String[] args) {
		/*
		 * collection
		 * ==================
		 * collection-->root interface in collection framework
		 * collections-->it will provide some of the utility methods to work with collection 
		 * 
		 * collection
		 * ============
		 * when u represent a group of individual object into a single entity then we should go for collection
		 *root interface in collection framework
		 * this will provide some of the built in methods to work with any collection class
		 * we can store multiple data types
		 * */
		//upcasting 
		Collection col=new ArrayList<>(); //there is no type safety
		col.add("123");
		col.add(123);
		col.add(123.123);
		col.add(true);
		System.out.println(col);
		
		
		
		Collection col2=new ArrayList<>();//there is no type safety
		col.add("hello");
		col.addAll(col2);
		System.out.println(col);
		System.out.println(col.size());
		
		col.remove(123);
		System.out.println(col);
	}

}
