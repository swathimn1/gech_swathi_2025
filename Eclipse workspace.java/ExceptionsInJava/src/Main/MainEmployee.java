package Main;

//Abstract base class
abstract class Employee {
 protected String name;

 // Constructor
 public Employee(String name) {
     this.name = name;
 }

 // Abstract method to calculate salary
 public abstract double calculateSalary();

 // Method to display employee details
 public void displayDetails() {
     System.out.println("Employee Name: " + name);
     System.out.println("Salary: " + calculateSalary());
 }
}

//Subclass for full-time employees
class FullTimeEmployee extends Employee {
 private double monthlySalary;

 // Constructor
 public FullTimeEmployee(String name, double monthlySalary) {
     super(name);
     this.monthlySalary = monthlySalary;
 }

 // Implement abstract method
 @Override
 public double calculateSalary() {
     return monthlySalary;
 }
}

//Subclass for part-time employees
class PartTimeEmployee extends Employee {
 private double hourlyRate;
 private int hoursWorked;

 // Constructor
 public PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
     super(name);
     this.hourlyRate = hourlyRate;
     this.hoursWorked = hoursWorked;
 }

 // Implement abstract method
 @Override
 public double calculateSalary() {
     return hourlyRate * hoursWorked;
 }
}

//Main class
public class MainEmployee {
 public static void main(String[] args) {
     Employee fullTimeEmp = new FullTimeEmployee("Alice", 5000);
     Employee partTimeEmp = new PartTimeEmployee("Bob", 20, 80);

     System.out.println("Full-Time Employee Details:");
     fullTimeEmp.displayDetails();

     System.out.println("\nPart-Time Employee Details:");
     partTimeEmp.displayDetails();
 }
}