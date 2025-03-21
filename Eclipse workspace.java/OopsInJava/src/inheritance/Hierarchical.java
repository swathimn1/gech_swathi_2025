package inheritance;

class Parent1Class{
	public void ParentMethod() {
		System.out.println("This is Parent Method");
	}
}

class Child1 extends Parent1Class {
	public void Child1ClassMethod() {
		System.out.println("This  is the  child1 Method");
	}
}
class Child3 extends Parent1Class {
	public void Child3ClassMethod() {
		System.out.println("This  is the  child3 Method");
	}
}


public class Hierarchical {//one parent and 2 Child.(use the keyword extends)

	public static void main(String[] args) {
      Child1 child= new Child1();
      child.ParentMethod();
      child.Child1ClassMethod();
      
      Child3 child3=new Child3();
      child3.ParentMethod();
      child3.Child3ClassMethod();
      
      
      
	}

}
