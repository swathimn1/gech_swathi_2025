package inner_classes_in_java;

import inner_classes_in_java.University1.Department;

class University1 {
	class Department {
		public String name = "swathi";
	}
}

public class InnerClasses4 {

	public static void main(String[] args) {
		University1 u1 = new University1();
		Department department = u1.new Department();
		System.out.println(department.name);

	}

}
