package functional_interface;
import java.lang.*;

@FunctionalInterface
interface FunInterface {
	public int add(int a, int b);
}


interface FunInterface1 {
	public int findLength(String s);
}

@FunctionalInterface
interface FunInterface2 {
	public String UpperCase(String str);
}

public class FunctionalInterface_in_java {

	public static void main(String[] args) {
		FunInterface inter = (a, b) -> a + b;
		int res = inter.add(10, 2);
		System.out.println(res);

		FunInterface1 length = s -> s.length();
		int res1 = length.findLength("Swathi");
		System.out.println(res1);

		FunInterface2 uppercase = s -> s.toUpperCase();
		String res2 = uppercase.UpperCase("swathi");
		System.out.println(res2);

	}

}
