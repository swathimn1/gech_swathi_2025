package interfaceInjava;

//interface A{
//	public void methodA();
//}
//interface  B{
//	 public void methodB();
//}
interface A{
	public void method();
}
interface B{
	public void method();
}

//class child implements A,B{
//
//	@Override
//	public void methodB() {
//		// TODO Auto-generated method stub
//		System.out.println("this is method B");
//	}
//
//	@Override
//	public void methodA() {
//		// TODO Auto-generated method stub
//		System.out.println("this is method A");
//	}
//	
//}
class Child implements A,B{

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("This is method  for  both interfaces A and B");
	}
	
}

public class InterfaceInJava1 {

	public static void main(String[] args) {
//       child child=new child();
//       child.methodA();
//       child.methodB();
		Child child=new Child();
		child.method();
	}

}
