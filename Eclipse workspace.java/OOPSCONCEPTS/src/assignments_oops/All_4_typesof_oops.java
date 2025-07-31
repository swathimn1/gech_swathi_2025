package assignments_oops;

abstract class User {
	private String name;

	private String phone;

	public User(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public abstract void showProfile();
}

class Driver extends User {

	public String vehicle;

	public Driver(String name, String phone, String vehicle) {
		super(name, phone);
		this.vehicle = vehicle;
	}

	@Override
	public void showProfile() {
		System.out.println("Driver's profile  is as follows");
		System.out.println("Name:" + this.getName());
		System.out.println("phone:" + this.getPhone());
		System.out.println("vehicle:" + this.vehicle);

	}

}

class Customer extends User {
	public String pickupLocation;

	public Customer(String name, String phone, String pickupLocation) {
		super(name, phone);
		this.pickupLocation = pickupLocation;

	}

	@Override
	public void showProfile() {
		System.out.println("Customer's profile is as follows:");
		System.out.println("Name:" + this.getName());
		System.out.println("Phone:" + this.getPhone());
		System.out.println("PickupLocation:" + this.pickupLocation);
	}

}

interface Ride {
	public void book(String from, String to);
}

class UberRide implements Ride {

	@Override
	public void book(String from, String to) {
		System.out.println("Uber ride started from " + from + " to " + to);
	}

}

public class All_4_typesof_oops {

	public static void main(String[] args) {
		User driver = new Driver("Varshi", "1234567890", "Maruti");
		driver.showProfile();

		User customer = new Customer("Swathi", "9876543210", "AGB layout");
		customer.showProfile();
		Ride uberride = new UberRide();

		uberride.book("AGB layout", "majestic");
	}

}
