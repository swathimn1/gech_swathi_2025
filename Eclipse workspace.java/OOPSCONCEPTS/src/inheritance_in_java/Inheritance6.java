package inheritance_in_java;
class Student{
	public String name;
	public int age ;
	
	public Student(String name,int  age ) {
		this.name=name;
		this.age=age;
		
	}
	public void isStudent() {
		System.out.println("He is "+name+"and his age is "+age);
	}
	
}
class Person extends Student{
   public String address;
	public Person(String name, int age,String address) {
		super(name, age);
		this.address=address;
	}
	@Override
	public void isStudent() {
		System.out.println("he is "+name+" and his age is "+age +" and his address is "+address);
	}
	
}

public class Inheritance6 {

	public static void main(String[] args) {
		Person p=new Person("Prajwal",18,"Mokali");
		p.isStudent();
		

	}

}
