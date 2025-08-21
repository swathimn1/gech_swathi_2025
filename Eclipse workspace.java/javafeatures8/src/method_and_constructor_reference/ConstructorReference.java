package method_and_constructor_reference;

import java.util.function.Function;
import java.util.function.Supplier;

class Student {
	public String name;

	public Student() {
		System.out.println("this is a student constructor");
	}

	public Student(String name) {
		this.name = name;
		System.out.println("this is a student 2 constructor");
		System.out.println("the name of a student is:" + name);
	}
//	@Override
//	public String toString() {
//		return "Student [name=" + name + "]";
//	}

}

public class ConstructorReference {

	public static void main(String[] args) {
		Supplier<Student> sup = () -> new Student();
		sup.get();

		Supplier<Student> sup1 = Student::new;
		sup1.get();

		Function<String, Student> fun1 = Student::new;
		fun1.apply("Swathi");

	}

}
