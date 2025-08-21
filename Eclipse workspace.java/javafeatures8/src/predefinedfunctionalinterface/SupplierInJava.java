package predefinedfunctionalinterface;

import java.time.LocalDate;
import java.util.Date;
import java.util.function.Supplier;

public class SupplierInJava {
	public static void main(String[] args) {
		/*
		 * Supplier: 
		 * ========= 
		 * it won't take anything it will return the value.
		 */

		Supplier<Double> sup = () -> Math.random() * 10;
		// In java ,any name starts with the capital letter(like Math),we consider it as a class,we
		// have to create a object for that,
		// but it is a static class ,we can access it using a class name
		Double res = sup.get();
		System.out.println(res);

		Supplier<Date> s = () -> new Date();
		Date date = s.get();
		System.out.println(date);

		System.out.println(LocalDate.now());
		Supplier<LocalDate> s1 = () -> LocalDate.now();
		LocalDate res1 = s1.get();
		System.out.println(res1);

	}
}
