package map_in_java;

import java.util.TreeMap;

public class TreeMap1 {
    public static void main(String[] args) {
		TreeMap<Integer,String> treemap=new TreeMap<>();
		treemap.put(0, "swathi");
		treemap.put(1,"varshi");
		treemap.put(2, "apple");
		treemap.put(3, "null");
		treemap.put(5, "banana");
		treemap.put(4,"kiwi");
		System.out.println(treemap);
		System.out.println(treemap.containsKey(1));
		System.out.println();
	}
}
