package vehicle;

public class Vehicles {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Toyota", 120);
        System.out.println("Vehicle Details:");
        vehicle.displayDetails();

        System.out.println("\nCar Details:");
        Car car = new Car("Honda", 150, 4);
        car.displayDetails();
    }
}
