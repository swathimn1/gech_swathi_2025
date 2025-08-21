package collections_in_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayList3 {

	public static void main(String[] args) {
     List arr=new ArrayList();
     arr.add(10);
     arr.add(6);
     arr.add(90);
     arr.add(11);
     arr.add(30);
     System.out.println(arr);
     Collections.sort(arr);//sort method internally uses comparable method ->it is used for default sorting or natural sorting order.
     //comparable is a functional interface ,it has only one abstract method compareTo.
     System.out.println("After:"+arr);
     System.out.println("Min:"+Collections.min(arr));
     System.out.println("Max:"+Collections.max(arr));
     //if we want custom sorting,we have to go for a comparator,it has one method compare 
     //it can be used to sort more than one element.
	}

}
