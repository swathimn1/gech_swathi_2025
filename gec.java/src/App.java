// import student.Student;

import student.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        Student std1= new Student(21, "swathi");
        Student std2= new Student(22, "varshini");
        System.out.println("the student details are:");
        System.out.println("Hello, World!");
        System.out.println("Id: "+std1.stdId);
        System.out.println("Name:"+std1.stdName);
        System.out.println("Id: "+std2.stdId);
        System.out.println("Name:"+std2.stdName);


        Employee emp1 = new Employee("Swathi", 21, "E001", "IT", 60000);
        Employee emp2 = new Employee("varshini", 23, "E002", "HR", 55000);
        System.out.println("Employee Details:");
        System.out.println("Employee ID: " + emp1.employeeId);
        System.out.println("Name: " + emp1.name);
        System.out.println("Age: " + emp1.age);
        System.out.println("Department: " +emp1. department);
        System.out.println("Salary: $" + emp1.salary);

        System.out.println("Employee ID: " + emp2.employeeId);
        System.out.println("Name: " + emp2.name);
        System.out.println("Age: " + emp2.age);
        System.out.println("Department: " +emp2.department);
        System.out.println("Salary: $" + emp2.salary);




}
}