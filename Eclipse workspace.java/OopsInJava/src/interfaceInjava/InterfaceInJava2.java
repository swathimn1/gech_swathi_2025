package interfaceInjava;

interface Interface1 {
	public void method();

	public default void defaultmethod() {
		System.out.println("This is default method in interface");
		// we can use default and static keyword for interface from java 8.
		// by using default and static ,we can write body inside the interface only
		// without creating a class.
		// abstract method does not have a body,we have to write a class to access
		// abstract method to give a body ,to access class ,we have create a object with
		// the use of new keyword.
	}

	public static void staticmethod() {
		System.out.println("This is static method in interface");
	}

}

class Child1 implements Interface1 {

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("this is method");
	}

}

public class InterfaceInJava2 {
	/*
	 * default and static method inside interface.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child1 child1 = new Child1();
		child1.method();
		child1.defaultmethod();
		Interface1.staticmethod();
        //to access static method in Interface we use Interface_name only .
        //In Interface ,both interface and class are same only.
		// we cannot call the constructor for a interface.because we cannot assign a
		// value for a instance variables inside interface.
	}

}
