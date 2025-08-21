package predefinedfunctionalinterface;

import java.util.function.Predicate;

public class PredicateInJava {

	public static void main(String[] args) {
		 /*
	        * Predicate:
	        * ========
	        * * It will holds a condition
	        * the output will be in boolean values like whether condition is true or false.
	        * it uses test method to check
		    * whether the condition is true or false.
		 */
		
		// to find a number is even or odd.
		Predicate<Integer> pre = a -> a % 2 == 0;
		boolean test = pre.test(26);
		if (test) {
			System.out.println("the given number is even");
		} else {
			System.out.println("the given number is odd");
		}
		
		//to check whether string length greater than 10
		Predicate<String>len=s->s.length()>10;
		boolean test1=len.test("Swathi");
		if(test1) {
			System.out.println("the length of s is greater than 10");
		}else {
			System.out.println("the length of s is less than 10");
		}

	}

}
