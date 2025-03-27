package com.functionalinterface;


@FunctionalInterface         //contains only one abstract method.
interface Interface1{
	public void display();
	
}

class Display implements Interface1{

	@Override
	public void display() {
		 System.out.println("Hello world");
	}
	

}
public class FunctionalInterfaceInJava {

	public static void main(String[] args) {
		Display  display=new Display();
		display.display();

	}

}
