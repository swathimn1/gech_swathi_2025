package shapes;

//Base class
class Shape {
 // Method to calculate area (to be overridden)
 public double calculateArea() {
     return 0; // Default implementation
 }

 // Method to display area
 public void displayArea() {
     System.out.println("Area: " + calculateArea());
 }
}

//Circle subclass
class Circle extends Shape {
 private double radius;

 // Constructor
 public Circle(double radius) {
     this.radius = radius;
 }

 // Override calculateArea method
 @Override
 public double calculateArea() {
     return Math.PI * radius * radius;
 }
}

//Rectangle subclass
class Rectangle extends Shape {
 private double length, width;

 // Constructor
 public Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 // Override calculateArea method
 @Override
 public double calculateArea() {
     return length * width;
 }
}

//Main class
public class Shapes {
 public static void main(String[] args) {
     Shape circle = new Circle(5);
     Shape rectangle = new Rectangle(4, 6);

     System.out.println("Circle:");
     circle.displayArea();

     System.out.println("\nRectangle:");
     rectangle.displayArea();
 }
}