package constructor_in_java;

class Car {
	public String name;
	public int model;

	public Car(String name, int model) {
		this.name = name;
		this.model = model;
	} /*
		 * we can have more than one constructor in a class . 
		 * there are two types of constructor in java, they are 
		 * 1.parameterized constructor 
		 * 2.default constructor
		 */

	public Car() {

	}
}

public class Constructor3 {

	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car("Audi", 25);
		System.out.println("Name:" + car2.name);
		System.out.println("Model:" + car2.model);

	}

}
