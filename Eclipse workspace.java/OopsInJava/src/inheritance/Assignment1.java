package inheritance;

interface I1{
	public void methodI1();
}
interface I2{
	public void methodI2();
}

class P{
	public void methodP() {
		System.out.println("This is method P");
	}
}

class C extends P implements I1,I2{

	@Override
	public void methodI2() {
		// TODO Auto-generated method stub
		System.out.println("This is method I2");
		
	}

	@Override
	public void methodI1() {
		// TODO Auto-generated method stub
		System.out.println("This is method I1");
		
	}
	public void  methodC() {
		System.out.println("this is method C");
	}
	
}

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		C obj=new C();
		obj.methodI1();
		obj.methodI2();
		obj.methodC();
		obj.methodP();

	}

}
