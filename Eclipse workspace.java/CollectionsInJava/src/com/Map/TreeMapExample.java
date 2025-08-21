package com.Map;
import java.util.*;

public class TreeMapExample {

	public static void main(String[] args) {
      
		TreeMap<Integer,String> treemap=new TreeMap<>();
		treemap.put(1,"apple");
		treemap.put(2, "banana");
		treemap.put(3,"kivi");
		treemap.put(4,"grapes");
		System.out.println(treemap);
		System.out.println(treemap.get(2));
        treemap.remove(4);
        System.out.println(treemap);
        System.out.println(treemap.firstKey());
        System.out.println(treemap.containsKey(3));
        System.out.println(treemap.containsValue("kivi"));
        System.out.println(treemap.replace(1, "cherry"));
        System.out.println(treemap);
        System.out.println(treemap.size());
        System.out.println(treemap.higherKey(1));
        System.out.println(treemap);
        System.out.println(treemap.reversed());
        System.out.println(treemap.values());
        System.out.println(treemap.keySet());
	}
	

}
