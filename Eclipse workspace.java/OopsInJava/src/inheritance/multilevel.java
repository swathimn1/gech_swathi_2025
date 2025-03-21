package inheritance;

class grandParentClass {
	public void grandParentMethod() {
		System.out.println("This  is  the Grand Parent Method");
	}
}

class ParentClass extends grandParentClass {
	public void ParentMethod() {
		System.out.println("This  is  the Parent Method");
	}
}

class ChildClass extends ParentClass {
	public void ChildMethod() {
		System.out.println("This  is  the Child Method");
	}
}

public class multilevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildClass child = new ChildClass();
		child.grandParentMethod();
		child.ParentMethod();
		child.ChildMethod();
		ParentClass  parent=new ParentClass();
		parent.grandParentMethod();
		parent.ParentMethod();
		
		

	}

}
