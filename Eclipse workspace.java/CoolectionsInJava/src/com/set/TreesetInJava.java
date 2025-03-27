package com.set;

import java.util.TreeSet;

public class TreesetInJava {

	public static void main(String[] args) {
//       TreeSet<Integer> treeset=new TreeSet<Integer>();
//       TreeSet<Integer> treeset=new TreeSet<Integer>((a,b)->a-b);
       TreeSet<Integer> treeset=new TreeSet<Integer>((a,b)->b-a);
       treeset.add(67);
       treeset.add(89);
       treeset.add(12);
       treeset.add(5);
       System.out.println(treeset);
	}
	
	

}
