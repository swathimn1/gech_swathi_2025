package inheritance_in_java;//single -level inheritance
class Parent{
	int age=40;
	public void parent() {
		System.out.println("This is a parent class");
	}
}

public class Inheritance1 extends Parent {

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
		Inheritance1 one =new  Inheritance1();
		System.out.println("Parent age:"+one.age);
		one.parent();

	}

}
