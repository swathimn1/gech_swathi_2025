package arrays;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesFromArray {

	public static void main(String[] args) {
      int arr[] = {10,20,30,40,50,50,40};
      Set<Integer> number=new LinkedHashSet<>();
      for(int num:arr) {
    	  number.add(num);
      }
      System.out.println("Unique element in an set:"+number);
	}

}
