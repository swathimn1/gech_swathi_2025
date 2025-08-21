package method_and_constructor_reference;

import java.util.function.Consumer;
/*
 * 1.Static Method Reference
    ==========================
    Syntax:-
   ClassName::StaticMethodReference
   */

public class StaticMethodReference {
	public static void printMessage(String message) {
		System.out.println("your messge is:" + message);
	}

	public static void main(String[] args) {
		// without static method reference
		Consumer<String> con = s -> StaticMethodReference.printMessage(s);
		con.accept("Hello world");

		// with static method reference
		Consumer<String> con1 = StaticMethodReference::printMessage;
		con1.accept("Hello world");
	}

}
