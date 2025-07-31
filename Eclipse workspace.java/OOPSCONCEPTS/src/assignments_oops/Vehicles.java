package assignments_oops;

abstract class Vehicle {
	public abstract void start();

	public void fuel() {
		System.out.println("this is a  method to check vehicle's fuel ");
	}
}

class Car extends Vehicle {

	@Override
	public void start() {
		System.out.println("car is starting");
	}

}

class Bike extends Vehicle {

	@Override
	public void start() {
		System.out.println("Bike is starting");
	}

}

public class Vehicles {

	public static void main(String[] args) {
		Vehicle car = new Car();
		car.start();
		car.fuel();

		Vehicle bike = new Bike();
		bike.start();
		bike.fuel();
	}

}
