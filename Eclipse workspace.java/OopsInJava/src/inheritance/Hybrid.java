package inheritance;

interface Interface{
	public void  InterfaceMethod();
}



class Parent2Class{
	public void ParentMethod() {
		System.out.println("This is the parent Method");
	}
}
class Child  extends Parent2Class implements Interface{
	@Override
	public void InterfaceMethod() {
		// TODO Auto-generated method stub
		 System.out.println("This is child class implements the Interface");
	}
//	public void ChildMethod() {
//		System.out.println("This is the child class extends the Parent Class");
//	}
}

//class Child5 extends Parent2Class{
//	public void ChildMethod() {
//		System.out.println("This is the child class extends the Parent Class");
//	}
//}
public class Hybrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Child child=new Child();
     child.InterfaceMethod();
//     child.ChildMethod();
     child.ParentMethod();
	}

}


