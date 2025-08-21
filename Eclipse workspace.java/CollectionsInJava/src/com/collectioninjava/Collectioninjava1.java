package com.collectioninjava;

import java.util.ArrayList;
import java.util.Collection;

public class Collectioninjava1 {

	public static void main(String[] args) {
		
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
			collection3.add("varshini");
			collection3.add(60.78);
			System.out.println(collection3);
			System.out.println(collection3.isEmpty());
			System.out.println(collection3.size());

			
	}
	

}