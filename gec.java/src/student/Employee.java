package student;

public class Employee {
    public String name;
    public int age;
    public String employeeId;
    public String department;
    public double salary;

    public Employee(String name, int age, String employeeId, String department, double salary) {
        this.name = name;
        this.age = age;
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }  


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
    
    
}
