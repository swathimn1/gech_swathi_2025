package inheritance;

//1.single level inheritance.
class Parent {
	int pData = 100;

	public void parentMethod() {//public

		System.out.println("This is parent method");
	}

}
//class Parent {
//	int pData = 100;
//
//	private void parentMethod() {//private
//
//		System.out.println("This is parent method");
//	}
//
//}
//class Parent {
//	int pData = 100;
//
//	 void parentMethod() {//default
//
//		System.out.println("This is parent method");
//	}
//
//}
//class Parent {
//	int pData = 100; //static
//
//	public static void parentMethod() {
//
//		System.out.println("This is parent method");
//	}
//
//}



class Child2 extends Parent {
	int cData = 200;

	public void childMethod() {

		System.out.println("This is child class");
	}
}

//class Child2 extends Parent {
//	int cData = 200;
//
//	 private void childMethod() {
//
//		System.out.println("This is child class");
//	}
//}
//class Child2 extends Parent {
//	int cData = 200;
//
//	  void childMethod() {
//
//		System.out.println("This is child class");
//	}
//}
//class Child2 extends Parent {
//	int cData = 200;
//
//	 public static void childMethod() {
//
//		System.out.println("This is child class");
//	}
//}
public class InheritanceInJava {

	public static void main(String[] args) {
		/*
		 * Inheritance ===== extending the properties of parent class to child class.
		 * properties(state and actions).
		 * 
		 * types:- ====== 1.single level-parent to child(extends)
		 * 2.multi-level-parent2-parent1-child(parent2-parent1(extends) and
		 * parent1-child(extends)). 3.hierarchical-parent-child1(extends) &
		 * parent-child2(extends). 4.hybrid:-child-interface(implements)&
		 * child-parent(extends) 5.multiple inheritance-cannot be achieved in Java.
		 */

		Child2 child2 = new Child2();
		child2.parentMethod();
		child2.childMethod();
//		Parent.parentMethod();
//		Child2.childMethod();
		
		System.out.println(child2.pData);
		System.out.println(child2.cData);
    //by using private we cannot  access the method we get  an error because we cannot access private keyword outside the class.
		//by using default keyword we  can access  value but we do not use the word default .
		//by using static also we  can access the method ,but we can access it using class_name.
	}

}
