package final_this_super;

class Person{
	
	public String name;
	public int age;
	
	//no args constructors
		public Person() {
			System.out.println("Default constructor");
		}
	
	//full or all  args constructor
	public Person(String name, int age) {
		this();//this is for default constructor
		this.name = name;//used to refer the values for a instance variables.
		this.age = age;
		System.out.println("Full/All args constructor");
	}
	
	public void sayHello() {
		System.out.println("Hello");
	}
	
	public void display() {
		this.sayHello();//used to refer methods in current class.
		System.out.println("Name is:"+this.name);//used to refer the current class constructor
		//System.out.println("Age is:"+age);
		System.out.println("Age is:"+this.age);
	}
	
}

public class ThisInJava {

	public static void main(String[] args) {
      /*
       * This keyword 
       * ======
       * 1.this is used to refer the instance variables
       * 2.used to refer current class constructor
       * 3.used to refer methods in current class.*/
		
		Person person=new Person("Swathi",21);
		person.display();
	}

}
