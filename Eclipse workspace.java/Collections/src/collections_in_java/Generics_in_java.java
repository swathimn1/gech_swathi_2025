package collections_in_java;

import java.util.ArrayList;
import java.util.List;

public class Generics_in_java {

	public static void main(String[] args) {
		/*
         * Generics
         * ======
         * it provides type safety and to avoid type casting in collection then we should go for generics.
         * syntax
         * =======
         * List<Integer> arr=new List<Integer>();//type safety.
         * List<type of object>
         * ex:-List<Integer>
         * */
		//without generics
		List marks=new ArrayList<>();
		marks.add(120);
		marks.add(140);
		System.out.println(marks);
		int marks1=(int) marks.get(0);
		int marks2=(int) marks.get(1);
		System.out.println("marks1:"+marks1);
		System.out.println("marks2:"+marks2);
		
		//with generics
		List<String> name=new ArrayList<String>();//type safety
		//from java 8 version,it is optional to mention the type of object in the ArrayList.
		name.add("swathi");
		name.add("varshi");
		String name1=name.get(0);//avoid type casting
		String name2=name.get(1);
		System.out.println("name1:"+name1);
		System.out.println("name2:"+name2);
		
	}

}
