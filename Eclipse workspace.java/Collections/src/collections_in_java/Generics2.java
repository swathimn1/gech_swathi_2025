package collections_in_java;

class Student1<T> {
	private T name;

	public Student1(T name) {
		super();
		this.name = name;
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}
	

}

class Student2<T> {
	private T age;
	private T USN;

	public Student2(T age, T uSN) {
		super();
		this.age = age;
		USN = uSN;
	}

	public T getAge() {
		return age;
	}

	public void setAge(T age) {
		this.age = age;
	}

	public T getUSN() {
		return USN;
	}

	public void setUSN(T uSN) {
		USN = uSN;
	}

}

public class Generics2 {

	public static void main(String[] args) {
		Student1<String> std1 = new Student1<>("Swathi");
		System.out.println(std1.getName());
		std1.setName("Varshi");
		System.out.println(std1.getName());

		Student2<Integer> std2 = new Student2<>(21, 54);
		System.out.println(std2.getAge());
		System.out.println(std2.getUSN());
		std2.setAge(23);

		std2.setUSN(65);

		System.out.println(std2.getAge());
		System.out.println(std2.getUSN());
	}

}
