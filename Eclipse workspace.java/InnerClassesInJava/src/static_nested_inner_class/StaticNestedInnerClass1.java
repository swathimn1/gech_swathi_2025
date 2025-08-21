package static_nested_inner_class;

public class StaticNestedInnerClass1 {
	public static String name="swathi";
	static class Inner {
		public void display() {
			System.out.println(name);
//			System.out.println(name);
		}
	}

	public static void main(String[] args) {

//		Inner in = new Inner();
//		in.display();
		StaticNestedInnerClass1.Inner obj = new StaticNestedInnerClass1.Inner();
		obj.display();

	}

}
