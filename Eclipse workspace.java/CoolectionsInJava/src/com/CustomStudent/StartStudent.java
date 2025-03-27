package com.CustomStudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StartStudent {

	public static void main(String[] args) {

		Student std1 = new Student("swathi", 54, 21);
		System.out.println(std1);
		Student std2 = new Student("varshini", 55, 21);
		System.out.println(std2);
		Student std3 = new Student("varshini", 56, 21);
		System.out.println(std3);
		Student std4 = new Student("swathi", 57, 21);
		System.out.println(std4);
		List<Student> students = new ArrayList<>();
		students.add(std1);
		students.add(std2);
		students.add(std3);
		students.add(std4);
		students.add(new Student("praju", 26, 19));
		System.out.println(students);
		// students.remove(0);
		
		
		//sort roll number
		System.out.println("Before sorting roll number:");
//		System.out.println(students);
		Collections.sort(students, (s1,s2)->s1.getRoll_num()-s2.getRoll_num());
		System.out.println(students);
		//we use the concept of comparator.
		//to sort in ascending order.
		// comparator is an functional interface(it contain only one abstract method
		// irrespective of default and static method)
		//int compare(T o1,T o2)-data type o1-object1,o2-object2.[syntax for the compare].
		//lamba -don't have function name,return type
		
		//sort student roll number
		Collections.sort(students, (s1,s2)->s2.getRoll_num()-s1.getRoll_num());//to sort in descending order
		System.out.println("After sorting roll number:");
		System.out.println(students);
		
		//
		System.out.println("Before sorting age:");
		Collections.sort(students, (s1,s2)->s1.getAge()-s2.getAge());
		System.out.println(students);
		
		Collections.sort(students, (s1,s2)->s2.getAge()-s1.getAge());//to sort in descending order
		System.out.println("After sorting age:");
		System.out.println(students);
		Collections.sort(students, (s1,s2)->s2.getName().compareTo(s1.getName()));//to sort in descending order
		System.out.println("After sorting name:");
		System.out.println(students);
		
		Collections.sort(students, (s1,s2)->s1.getName().compareTo(s2.getName()));//to sort in ascending order
		System.out.println("After sorting name:");
		System.out.println(students);
		
	
	

	}

}
