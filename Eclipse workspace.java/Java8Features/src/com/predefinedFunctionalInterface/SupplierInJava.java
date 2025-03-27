package com.predefinedFunctionalInterface;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierInJava {

	public static void main(String[] args) {
        /*
         * Supplier:
         * =========
         * it won't take anything it will return the value.
         * */
//		Supplier<Date> s =()->new Date();
//		Date date=s.get();
//		System.out.println(date);
		
		Supplier<Date> s=()->new Date();//the data type of a lambda expression is functional interface.
		Date date=s.get();
		System.out.println(date);
	}

}
