package polymorphism_in_java;

class Shape {

	public void area() {
		System.out.println("calculating area......");
	}
}

class Circle extends Shape {

	public int radius;

	public Circle(int radius) {
		this.radius = radius;

	}

	@Override
	public void area() {
//		System.out.println("this is a circle method" + " and the area of the circle is : "
//				+ (3.14 * this.radius * radius) + " cm^2");
		double area = 3.14 * this.radius * radius;
		System.out.println("the area of a circle is :" + area + " cm^2");
	}

}

class Rectangle extends Shape {

	private int length, width;

	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public void area() {
		double area = length * width;
		System.out.println("the area of the rectangle is :" + area + " units");
	}
}

public class Polymorphism2 {

	public static void main(String[] args) {
//		Circle circle = new Circle(20);
//		circle.area();
		Shape circle = new Circle(20);
		circle.area();// up casting // down casting-we have to learn
		
		Shape rectangle = new Rectangle(4, 6);
		rectangle.area();

	}

}
