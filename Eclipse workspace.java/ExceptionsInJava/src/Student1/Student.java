package Student1;

//Student class
class Student {
 // Private fields (Encapsulation)
 private String name;
 private int rollNumber;
 private double marks;

 // Constructor
 public Student(String name, int rollNumber, double marks) {
     this.name = name;
     this.rollNumber = rollNumber;
     this.marks = marks;
 }

 // Getter and Setter methods
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public int getRollNumber() {
     return rollNumber;
 }

 public void setRollNumber(int rollNumber) {
     this.rollNumber = rollNumber;
 }

 public double getMarks() {
     return marks;
 }

 public void setMarks(double marks) {
     this.marks = marks;
 }

 // Method to check if the student has passed
 public boolean hasPassed() {
     return marks >= 40;
 }

 // Method to display student details
 public void displayDetails() {
     System.out.println("Student Name: " + name);
     System.out.println("Roll Number: " + rollNumber);
     System.out.println("Marks: " + marks);
     System.out.println("Result: " + (hasPassed() ? "Passed" : "Failed"));
 }
}

//Main class to test the Student class

