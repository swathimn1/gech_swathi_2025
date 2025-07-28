package inheritance_in_java;//multi-level  inheritance

class GrandParent{
	int age1=100;
	public void grandparent() {
		System.out.println("This is a Grand parent method");
	}
	
}
class Parent1 extends GrandParent{
	int age2 =60;
	public void parent() {
		System.out.println("This is a parent method");
	}
}

public class Inheritance2 extends Parent1 {
	int age3=30;
 public void child() {
	 System.out.println("This is a child method");
 }
	public static void main(String[] args) {
      Inheritance2 two =new Inheritance2();
      System.out.println("Grandparent age:"+two.age1);
      System.out.println("Parent age:"+two.age2);
      System.out.println("Child age:"+two.age3);
      two.grandparent();
      two.parent();
      two.child();
	}

}
