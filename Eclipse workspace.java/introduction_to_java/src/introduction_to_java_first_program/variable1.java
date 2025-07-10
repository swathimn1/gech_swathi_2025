package introduction_to_java_first_program;

import java.util.Arrays;

public class variable1 {

	public static void main(String[] args) {
       /**
        * variables in java
        * syntax:
        * ========
        * data_type variable_name;//declaration;
        * variable_name=value;//initialization 
        * 
        * in a single line
        * ================
        * data_type variable_name=value;
        */
		//byte
		byte age; //1 byte
		age=20;
		System.out.println("the age is :"+age);
		short age1=22;//2 byte
		System.out.println("the age 1 is :"+age1);
		int it=122;//4 byte
		System.out.println("the it is:"+it);
		float ft=14.5f; //4 byte
		System.out.println("the float value is:"+ft);//println it print a new line after after  executing a current line ,if we use print ,it wont create a new line.
		long lg=155L; //8 byte
		System.out.println("the long value is :"+lg);
		double dl=166;
		System.out.println("the double value is :"+dl);
		char var='a';
		System.out.println("the char value is:"+var);
		boolean isValid=true;
		System.out.println("the boolean value is :"+isValid);
		
		//non-primitive data types
		//1.Array
		int [] arr= {1,2,3,4,5};
		System.out.println("the array is:"+Arrays.toString(arr));
		//2.String
		String name="Swathi";
		System.out.println("the string value is:"+name);
		
		
	}

}
