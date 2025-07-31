package polymorphism_in_java;

class Addition {
	public void add(int a, int b) {
		System.out.println("the result of the 1 st mt is :" + (a + b));
	}

	public void add(int a, int b, int c) {
		System.out.println("the result of the 2 nd mt is :" + (a + b + c));
	}
}

public class Polymorphism1 {

	public static void main(String[] args) {

		/*
		 * polymorphism ======= poly->many morphism->forms it is a mechanism that
		 * methods(set of code that performs specific task) will perform a different
		 * actions based on the situation 1.method-overloading(one class)
		 * 2.method-overriding(two class)
		 */
		// 2.method-overloading/compile time polymorphism/static polymorphism/static
		// binding.
		Addition add1 = new Addition();
		add1.add(10, 2);
		add1.add(6, 4, 5);
		// Within the same class ,same method name with different parameters
		// At the compilation time,compiler decides which method method to call.

		/*
		 * POLYMORPHISM:
		 * 
		 * poly-> many , morphism -> forms
		 * 
		 * => It is a mechanism where methods will perform a different actions based on
		 * the situation => In simple words polymorphism is where we use the same method
		 * in different classes and changing the action. 1. method-overloading(one
		 * class) 2. method-overriding(two class) / dynamic- polymorhism/ runtime
		 * polymorphism
		 * 
		 * => 1. overloading/Compile-time polymorphism/static polymorphism/static
		 * binding - same method with different inputs within the same class. -Called as
		 * Complile time polymorhism beacuse the compiler decides which input method to
		 * be called during compile time.
		 * 
		 * => 2. overriding for two classes - Using the same method in the child class
		 * extending to parent class but printing different by overriding the method and
		 * printing the new thing we want to print.
		 */
	}

}
