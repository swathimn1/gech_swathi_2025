package inner_classes_in_java;

public class InnerClasses2 {
	class Department {
		public int a = 10;
	}

	public static void main(String[] args) {
		InnerClasses2 outer = new InnerClasses2();
		Department dept = outer.new Department();
		System.out.println(dept.a);
	}

}
