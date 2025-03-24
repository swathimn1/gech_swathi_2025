package abstraction;

//1.interface
interface Animal {
	public void eat();// we cannot write the body inside the interface that's why we can achieve a
						// 100% abstraction.
}

class Lion implements Animal {

	@Override
	public void eat() {
		System.out.println("Lion will eat");
	}

}

//2.abstract class.
abstract class Vehicle {
	// abstract method
	public abstract void start();

	// non abstract method.
	public void stop() {
		System.out.println("The Vehicle is stopped");
	}

}

class Car extends Vehicle {

	@Override
	public void start() {
		System.out.println("The Car started with a key");
	}

}

public class AbstractionInJava {

	public static void main(String[] args) {
		/*
		 * Abstraction ========= It is a process of hiding the implementation(body) and
		 * showing only the essential resources. 2 ways: ======= 1.Interface(100%)
		 * 2.abstract class(0-100%) if we want 100% abstraction,we can go for a
		 * interface. if we want 0-100% abstraction,we can go for a abstract class.
		 */

		Lion lion = new Lion();
		lion.eat();

		Car car = new Car();
		car.start();
		car.stop();
	}

}
