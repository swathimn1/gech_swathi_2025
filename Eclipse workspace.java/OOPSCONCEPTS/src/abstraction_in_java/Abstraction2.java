package abstraction_in_java;

interface Vehicle {
	public void start(); 
}

class Car implements Vehicle {

	@Override
	public void start() {
		System.out.println("car is starting");

	}

}

public class Abstraction2 {

	public static void main(String[] args) {
		/**
		 * It is a blueprint of class
		 * if you don't know the complete implementation of the particular method.
		 * we can go for a interface
		 * by interface,we can achieve 100% abstraction.
		 * how to declare interface
		 * interface interface_name{
		 *code
		 *
		 *interface Animal{
		 *public void  makeSound();
		 *}
		 *class->extends->class
		 *interface->implements->class
		 *interface->extends ->interface */
		
		
		/** when we create a interface ,they are public and abstract by default.
		 we can declare a interface as a default and static from java 8 version.
		 from java 9-we can declare interface as a private*/
		Car c = new Car();
		c.start();
	
		

	}

}
