package inheritance_in_java;//heirarchical inheritance -one parent 2 childs.
class ParentClass{
	public void parent() {
		System.out.println("This is a parent method");
	}
}
class Child extends ParentClass{
	public void child1() {
		System.out.println("This is a child1 class");
	}
}

public class Inheritance3  extends  ParentClass{
	public void child2() {
		System.out.println("This is a child2 class");
	}

	public static void main(String[] args) {
      Child child=new Child();
      child.parent();
      child.child1();
      
      
      Inheritance3 inheritance3=new Inheritance3();
      inheritance3.parent();
      inheritance3.child2();

      
	}

}
