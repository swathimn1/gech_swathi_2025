package com.functionalinterface;
@FunctionalInterface         //contains only one abstract method.
interface Interface2{
	public void display();
//	public void display1();
	
}

interface Interface3{
	public int String(String s);
}
interface Interface4{
	public int add(int a ,int b) ;
		
	
}

public class FunctionalInterface2 {

	public static void main(String[] args) {
		
//		Interface2 i=()->System.out.println("Hello world");
//		i.display();
	    
	Interface3 i3=s->s.length();
	int res=i3.String("Hello World");
	System.out.println("Result is:"+res);
	
	
  Interface4 i4=( int a, int b)->
  {
	  return a+b;
  };
  int res1=i4.add(3,4);
  System.out.println("Result is:"+res1);
  
	
	Interface4 i5=(a,b)->a+b;
	int res2=i5.add(6, 7);
    System.out.println(res2);

	}

}
