package anonymous_inner_class;

class Person {
	public String name;
	public int age;

	public void isWalking() {
		System.out.println("Person is walking");
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
}

public class AnonymousInnerClass {

	public static void main(String[] args) {
		// this is called instance block it will called before constructor called
		// it is used to initialize a instance variables
		Person person = new Person() {
			public static int i;
			{
				name = "swathi";
				age = 21;
			}
			// this is called static block ,it will execute before constructor called
			//it is used to initialize a static variables.
			static {
				i = 10;
			}

//			public String name="swathi";
//			public int age=21;

//			public String getName() {
//				return name;
//			}
//
//			public int getAge() {
//				return age;
//			}

			public void isWalking() {
				System.out.println("Swathi is walking");
			}
		};
//		System.out.println(person.getAge());
//		System.out.println(person.getName());
		System.out.println(person.name);
		System.out.println(person.age);
		person.isWalking();
	}

}
