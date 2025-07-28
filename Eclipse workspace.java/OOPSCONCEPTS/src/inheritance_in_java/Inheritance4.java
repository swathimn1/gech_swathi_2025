package inheritance_in_java; //Hierarchical inheritance example

class Parent1Class {
	String name1 = "Nagaraja";

	public void parent() {
		System.out.println("This is a parent method");
	}
}

class Child1 extends Parent1Class {

	String name2 = "Varshini";

	public void child1() {
		System.out.println("This is a child1 method");
	}
}

class Child2 extends Parent1Class {
	String name3 = "Swathi";

	public void child2() {
		System.out.println("This is a child2 method");
	}
}

class Child3 extends Child2 {
	String name4 = "Brunda";

	public void child3() {
		System.out.println("This is a child3 method");
	}
}

class Child4 extends Child2 {
	String name5 = "Lasya";

	public void child4() {
		System.out.println("This is a child4 method");
	}
}

public class Inheritance4 {

	public static void main(String[] args) {
		Child1 child1 = new Child1();
		System.out.println(child1.name1);
		System.out.println(child1.name2);

		child1.parent();
		child1.child1();
		System.out.println();

		Child2 child2 = new Child2();
		System.out.println(child1.name1);
		System.out.println(child2.name3);
		child2.parent();
		child2.child2();
		System.out.println();

		Child3 child3 = new Child3();
		System.out.println(child3.name3);
		System.out.println(child3.name4);
		child3.child2();
		child3.child3();
		System.out.println();

		Child4 child4 = new Child4();
		System.out.println(child4.name3);
		System.out.println(child4.name5);
		child4.child2();
		child4.child4();
	}

}
