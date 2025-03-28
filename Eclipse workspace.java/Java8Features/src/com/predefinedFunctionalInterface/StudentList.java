package com.predefinedFunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    String name;
    int age;
    double marks;

    public Student(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", marks=" + marks + "}";
    }

    public void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Marks: " + this.marks);
    }
}

// ✅ StudentList is now a separate class (not inside Student)
public class StudentList {
    public static void main(String[] args) {
        // List of students
        List<Student> students = Arrays.asList(
            new Student("Swathi", 12, 90.0),
            new Student("Varshini", 13, 98.0),
            new Student("Praju", 14, 99.0),
            new Student("Ravi", 15, 50.0)
        );

        // Filtering students with marks > 60
        List<Student> Students = students.stream().filter(student -> student.marks > 60).collect(Collectors.toList());

        // Printing original and filtered lists
        System.out.println("All Students: " + students);
        System.out.println("Students with Marks > 60: " + Students);

        // Display details of passed students
        System.out.println("\nDetails of Passed Students:");
        Students.forEach(Student::display);
      
    }
}
