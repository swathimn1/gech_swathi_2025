package oopsinjava;

class Student {
	// state
	public String name;
	public String USN;
	public int age;

	// action or behaviour
	public void isWriting() {
		System.out.println("Student is writing");
	}
}

public class ClassAndObject {
	/*
	 * * Class is defined as the blueprint of an object class represent the state
	 * and behaviour of an object where state-variables behaviour-method state-
	 * ======= USN name role age
	 * 
	 * 
	 * behaviour- ========= isPlaying() isEating()
	 * 
	 * how to declare a class- ====================== class class_name{ state
	 * behaviour }
	 * 
	 * for example:- class Student{ public int age ; public void isPlaying(){
	 * syso("the student is playing"); }
	 * 
	 * class do not take up an memory,once when we create an object for a class ,it
	 * will take memory.
	 * 
	 * Object- ======== it is an real-world entity it can be also defined as the
	 * instance/implementation of an class or instance of an state and behaviour
	 * 
	 * how to declare a object syntax- ======= class_name object_name =new
	 * class_name();
	 * 
	 * for example: Student std1=new Student(); where Student is a data_type for
	 * std1.
	 * 
	 * set values- =========== obj_name.state=value;
	 * 
	 * to call a method or an action ============================= obj_name.action;
	 */
	public static void main(String[] args) { /*static is used inside a main() method because jvm dont have a power to
												 create the object,so when we declare a main method as a static ,we
												dont need to create a object ,we can access it using a class_name
												only*/
		/* main() method will accept a String[] -array of  strings */
		
		// creating an object for student
		Student std1 = new Student();
		// setting the values
		std1.name = "Swathi";
		std1.USN = "54";
		std1.age = 21;
		System.out.println("Name:" + std1.name);
		System.out.println("USN:" + std1.USN);

		System.out.println("age:" + std1.age);
		// calling action
		std1.isWriting();

		// memory of class and object
		// when the variables are created ,it will store inside the stack memory.
		// when we created an object using new keyword ,it will store inside the heap
		// memory.

	}

}
