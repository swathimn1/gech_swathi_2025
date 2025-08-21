package method_and_constructor_reference;

import java.util.function.Supplier;
/*
 *  2.Instance Method Reference of a particular object
     ==================================================
		    
	 syntax:-
     ObjectName::InstanceMethodReference*/

public class InstanceMethodReference1 {
	public String getMessage() {
		return "this is instance method";
	}

	public static void main(String[] args) {
		InstanceMethodReference1 irl = new InstanceMethodReference1();
		// without instance method reference
		Supplier<String> sup = () -> irl.getMessage();
		System.out.println(sup.get());

		// with instance method reference
		Supplier<String> sup1 = irl::getMessage;
		System.out.println(sup1.get());

	}

}
