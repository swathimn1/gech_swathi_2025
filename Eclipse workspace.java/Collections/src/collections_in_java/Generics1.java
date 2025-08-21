package collections_in_java;

class MyGenericClass<T> {
	private T variable1;

	public MyGenericClass(T variable1) {
		super();
		this.variable1 = variable1;
	}

	public T getVariable1() {
		return variable1;
	}

	public void setVariable1(T variable1) {
		this.variable1 = variable1;
	}

}

public class Generics1 {

	public static void main(String[] args) {
		MyGenericClass<String> class1 = new MyGenericClass<>("Swathi");
		System.out.println(class1.getVariable1());
		class1.setVariable1("Varshi");
		System.out.println(class1.getVariable1());
	}

}
