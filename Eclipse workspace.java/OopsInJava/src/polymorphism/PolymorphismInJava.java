package polymorphism;

//1.method overriding
class Person {
	public  void walking() {
		System.out.println("person is walking");
	}
}

class Mohan extends Person {
	public void walking() {
		System.out.println("Mohan is walking");
	}
}

//2.method-overloading
class Addition{
	public  void add(int a,int b) {
		System.out.println("Addition is:"+(a+b));
	}
//	public void add(int a,int b,int c) {
//		System.out.println("Addition is:"+(a+b+c));
//	}
	public static void add(int a,int b,int c) {
		System.out.println("Addition is:"+(a+b+c));
	}
	
	
}



public class PolymorphismInJava {

	public static void main(String[] args) {
		/*
		 * polymorphism ======= poly->many morphism->forms 
		 * it is a mechanism that methods(set of code that performs specific task) will perform a different
		 * actions based on the situation 
		 * 1.method-overloading(one class)
		 * 2.method-overriding(two class)
		 */

		// 1.method overriding/dynamic polymorphism/runtime polymorphism/dynamic binding.
		//At the runtime only,it decides to run the method in the 2nd or child class to execute.
		Mohan mohan = new Mohan();
		mohan.walking();
		// if we do not want a default implementation of an parent we can override the
		// parent method in child or the 2nd class.
		// the access modifiers also same the method also same as the parent and we have
		// to change the printing the system in syso in 2nd class to override the parent class
		// it contain two classes.
		
		
		//2.method-overloading/compile time polymorphism/static polymorphism/static binding.
		Addition addition=new Addition();
//		addition.add(10, 20);
//		addition.add(10, 20,30);
		Addition.add(10,20, 30);
		
		//Within the same class ,same method name with different parameters
		//At the compilation time,compiler decides which method method to call.
		
		
		
		
		
		/* POLYMORPHISM:
			 * 
			 * poly-> many , morphism -> forms
			 * 
			 * => It is a mechanism where methods will perform a different actions based on
			 * the situation 
			 * => In simple words polymorphism is where we use the same method in different classes and changing the action.
			 * 1. method-overloading(one class) 
			 * 2. method-overriding(two class) / dynamic- polymorhism/ runtime polymorphism
			 * 
			 * => 1. overloading/Compile-time polymorphism/static polymorphism/static binding - same method with different inputs within the same class.
			 * -Called as Complile time polymorhism beacuse the compiler decides which input method to be called during compile time.
			 * 
			 * => 2. overriding for two classes - Using the same method
			 * in the child class extending to parent class but printing different by
			 * overriding the method and printing the new thing we want to print.*/

	}

}
