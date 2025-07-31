package inheritance_in_java; //Hierarchical inheritance example

class GrandParentClass {
	String name1 = "Nagaraja";

	public void grandparent() {
		System.out.println("This is a parent method");
	}
}

class Parenti extends GrandParentClass {

	String name2 = "Varshini";

	public void parent1() {
		System.out.println("This is a parent1 method");
	}
}

class Parent2 extends GrandParentClass {
	String name3 = "Swathi";

	public void parent2() {
		System.out.println("This is a parent2 method");
	}
}

class Child1 extends Parent2 {
	String name4 = "Brunda";

	public void child1() {
		System.out.println("This is a child1 method");
	}
}

class Child2 extends Parent2 {
	String name5 = "Lasya";

	public void child2() {
		System.out.println("This is a child2 method");
	}
}

public class Inheritance4 {

	public static void main(String[] args) {
		Parenti parent1 = new Parenti();
		System.out.println(parent1.name1);
		System.out.println(parent1.name2);

		parent1.parent1();
		parent1.grandparent();
		System.out.println();

		Parent2 parent2 = new Parent2();
		System.out.println(parent2.name1);
		System.out.println(parent2.name3);
		parent2.grandparent();
		parent2.parent2();
		System.out.println();

		Child1 child1 = new Child1();
		System.out.println(child1.name3);
		System.out.println(child1.name4);
		child1.grandparent();
		child1.parent2();
		child1.child1();
		System.out.println();

		Child2 child2 = new Child2();
		System.out.println(child2.name3);
		System.out.println(child2.name5);
		child2.child2();
		child2.grandparent();
		child2.parent2();
	}

}
