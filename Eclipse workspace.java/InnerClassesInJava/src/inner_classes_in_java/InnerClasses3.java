package inner_classes_in_java;

public class InnerClasses3 {
	class Engine {
		public String name = "Hello";
	}

	public void m1() {
		Engine en = new Engine();
		System.out.println(en.name);
	}

	public static void main(String[] args) {
		InnerClasses3 out = new InnerClasses3();
		out.m1();
	}

}
