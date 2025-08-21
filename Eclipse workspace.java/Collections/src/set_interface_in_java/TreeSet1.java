package set_interface_in_java;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet1 {

	public static void main(String[] args) {
      TreeSet<Integer> treeset=new TreeSet<>((a,b)->b-a);
      treeset.add(22);
      treeset.add(20);
      treeset.add(27);
      treeset.add(25);
      System.out.println(treeset);
      
      TreeSet<String> treeset1=new TreeSet<>(Comparator.reverseOrder());
      treeset1.add("swathi");
      treeset1.add("varshi");
      treeset1.add("apple");
      treeset1.add("banana");
      System.out.println(treeset1);
	}

}
