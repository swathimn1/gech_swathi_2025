package com.collectioninjava;

import java.util.ArrayList;
import java.util.Collection;

public class Collectioninjava1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		 * */
			Collection collection = new ArrayList();
			collection.add(10);//obj by default
			collection.add("munazza");
			collection.add(10.87);
			//collection.remove(10);
			//collection.isEmpty();
			//collection.clear();
			System.out.println(collection);
			System.out.println(collection.isEmpty());
			
			Collection collection1=new ArrayList();
			collection1.add(5);
			collection1.add("swathi");
			collection1.add(60.78);
			System.out.println(collection1);
			System.out.println(collection1.isEmpty());
			System.out.println(collection1.size());

			Collection collection3=new ArrayList();
			collection3.add(6);
			collection3.add("varshinii");
			collection3.add(60.78);
			System.out.println(collection3);
			System.out.println(collection3.isEmpty());
			System.out.println(collection3.size());

			
	}
	

}