package com.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListInJava {

	public static void main(String[] args) {
		/*linked List
		 * ========
		 * *linked list underline data structure is doubly linked list
		 * linked list allow duplicate
		 * 
		 * linked list allow random access(using index). 
		 * linked list will allow null values. 
		 * linked list will preserve the order of insertion
		 */
		
		List<Integer> list=new LinkedList<Integer>();
		list.add(45);
		list.add(45);
		list.add(null);
		list.add(23);
		list.add(30);
		System.out.println(list);
		System.out.println(list.get(2));
		
		
		/*
		 * linked list underline data structure is doubly linked list
		 * array list Dynamic Array
		 * 
		 * linked list will occupy more memory(3 nodes).
		 * array list will occupy less memory
		 * 
		 * when ever there is a continuous operation on deletion we should go for a linked list.
		 * when ever there is not  a continuous operation on deletion we should go for a linked list..
		 * 
		 * when ever there is a continuous operation on  insertion we can go for a linked list.
		 * when ever there is  not a continuous operation on  insertion we can go for a linked list.
		 * 
		 * for a easy memory access using index we should go for array list.
		 * for not  a easy memory access using index we should go for linked  list -because it makes use of pointers(It stores the addresss of a another variable).
		 * 
		 * integer takes a 4 bytes of memory for each block
		 * */
	}
	

}
