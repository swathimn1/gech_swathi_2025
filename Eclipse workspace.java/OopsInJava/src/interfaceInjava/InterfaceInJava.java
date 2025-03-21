package interfaceInjava;

interface Animal{
     public void makeSound();
}
class Dog implements Animal{

	@Override
	public void makeSound() {
		System.out.println("Dog barks");
	}
	
}
class Cat implements Animal{

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Cat make sound meow");
	}

}

public class InterfaceInJava {

	public static void main(String[] args) {

		/*
		 * Interface
		 * =======
		 * It is a blueprint of class
		 * The methods in the interface by default abstract:-does not contain any body
		 * 
		 * from java 8 we can write default and static methods in interface.
		 * if you don't know the complete implementation of the particular method.
		 * 
		 * how to declare interface
		 * interface interface_name{
		 *code
		 *
		 *interface Animal{
		 *public void  makeSound();
		 *}
		 */
		Dog dog=new Dog();
	    dog.makeSound();
	    Cat cat=new Cat();
	    cat.makeSound();
		 
		

	}

}
