package collections_in_java;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class TraversalArrayList {

	public static void main(String[] args) {
    
		ArrayList arr=new ArrayList();
		arr.add(2);
		arr.add(4);
		arr.add(20);
		arr.add(26);
		arr.add(40);
		//1.for loop
		System.out.println("using for loop");
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i)+"");
		}
		//2.for each
		System.out.println("using for each");
		for(Object item:arr) {
			System.out.println(item+"");
		}
		//3.forEach
		System.out.println("using forEach");
		arr.forEach((item)->System.out.println(item+""));
		System.out.println();
		
		//4.Iterator-uni directional(forward-hasNext()-to check if the next element is present or not)
		//next()-method used to print the next element.
		//it can be used inside any child interfaces like collection,list,queue and map ,set 
		//because it is the parent interface of all the interfaces.
		System.out.println("using iterator");
		
		Iterator itr=arr.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next()+"");
		}
		//5.ListInterator-bi directional(forward -hasNext() and backward-hasPrevious())
		//it can used inside the list and implementing classes like ArrayList and LinkedList ,vector and stack.
		System.out.println("using list iterator");
		ListIterator list=arr.listIterator();
		while(list.hasNext()) {
			System.out.println(list.next()+"");
		}
		//6.Enumeration-it is an interface it is used when we are working with vector and stack and Hash Table,Properties (legacy classes).
		Vector vec=new Vector();
		vec.add("Hello");
		vec.add(123);
		System.out.println("using Enumeration");
		Enumeration em=vec.elements();
		while(em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
	}

}
