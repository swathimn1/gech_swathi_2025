package inheritance;

interface Interfaces1 {
	public void methodI1();
}

interface Interfaces2 {
	public void methodI2();
}

interface Interfaces3 extends Interfaces1, Interfaces2 {
	public void methodI3();
}

class P1 implements Interfaces3 {

	@Override
	public void methodI1() {
		// TODO Auto-generated method stub
		System.out.println("This is method I1");
	}

	@Override
	public void methodI2() {
		// TODO Auto-generated method stub
		System.out.println("This is method I2");
	}

	@Override
	public void methodI3() {
		// TODO Auto-generated method stub
		System.out.println("This is method I3");
	}

}

class C1 extends P1 {
	public void methodC1() {
		System.out.println("This is method C1");
	}
}

class C2 extends P1 {
	public void methodC2() {
		System.out.println("This is method C2");
	}
}

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		C1 obj1 = new C1();
		obj1.methodC1();
		obj1.methodI1();
		obj1.methodI2();
		obj1.methodI3();

		C2 obj2 = new C2();
		obj2.methodC2();
		obj2.methodI1();
		obj2.methodI2();
		obj2.methodI3();

	}

}
