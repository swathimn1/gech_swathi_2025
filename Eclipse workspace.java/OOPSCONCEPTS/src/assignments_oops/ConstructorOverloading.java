package assignments_oops;

class Product {
	public String name;
	public double price;
	public int quantity;

	public Product(String name) {
		this.name = name;
		this.price = 0.00;
		this.quantity = 0;
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		this.quantity = 0;
	}

	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public void displayDetails() {
		System.out.println("Product Name:" + name);
		System.out.println("Product Price:" + price);
		System.out.println("Product  quantity:" + quantity);
	}
}

public class ConstructorOverloading {

	public static void main(String[] args) {
		Product p1 = new Product("Pen");
		Product p2 = new Product("Notebook", 50.00);
		Product p3 = new Product("Bag", 700.00, 1);

		p1.displayDetails();
		System.out.println();
		p2.displayDetails();
		System.out.println();
		p3.displayDetails();

	}

}
