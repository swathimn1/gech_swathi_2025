package collections_in_java;

import java.util.ArrayList;
import java.util.List;

public class ListInterface {

	public static void main(String[] args) {
		 /*
         *List
        * ================
        * it is a child interface of collection
        * it will contain some of the built in method that used inside a list implemented classes only
        * when you represent  a group of individual object as a single entity, where order is preserved and 
        * index based access and duplicate is allowed,we can go for a list interface.
        * 
     
        * 
        * */
		List l1=new ArrayList();//up casting
		l1.add("hello");
		l1.add(12);
		
		String name=(String) l1.get(0);
		System.out.println(l1);
		System.out.println(l1.get(1));
		System.out.println(l1.size());
		System.out.println(l1.remove(0));
		System.out.println(l1);
		
		
		
		

}
}
