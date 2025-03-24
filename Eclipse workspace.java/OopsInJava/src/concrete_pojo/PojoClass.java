package concrete_pojo;

class Student{
	
	private String name;
	private int age;
	private double marks;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", marks=" + marks + "]";
	}
	public Student() {
		System.out.println("no args constructor");
	}
	
	public Student(String name, int age, double marks) {
		this();
		System.out.println("Full args constructor");
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	
	public void display() {
		System.out.println("Name:"+this.name);
		System.out.println("Age:"+this.age);
		System.out.println("marks:"+this.marks);
		
	}
	
}

public class PojoClass {

	public static void main(String[] args) {
      /*
       * POJO Class:
       * =======
       * *plain old java object(POJO)
       * rules:
       * ======
       * 1.The class should not extends or implements any class or interface
       * 2.Every field(sates/properties)should be private 
       * 3.All-args Constructor
       * No-args Constructor
       * toString()
       * Getters and Setters should be private methods
       * */
		
		Student std1=new Student("swathi",21,90);
		std1.display();
		std1.getName();
		std1.getMarks();
		std1.getAge();
		System.out.println(std1);
	}

	
}
