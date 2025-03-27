package com.predefinedFunctionalInterface;

import java.util.function.Predicate;

public class PredicateInJava {

	public static void main(String[] args) {
       /*
        * Predicate:
        * ========
        * * It will holds a condition
        * the output will be in boolean values like whether condition is true or false.
        * it uses test method to check whether the condition is true or false.
        * */
		//to find a number is even or odd.
		Predicate<Integer> p=(a)->a%2==0;
		System.out.println(p.test(20));
		System.out.println(p.test(21));
	}

}
