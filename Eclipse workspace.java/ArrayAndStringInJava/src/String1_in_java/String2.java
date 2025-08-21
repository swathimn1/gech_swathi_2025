package String1_in_java;

public class String2 {

	public static void main(String[] args) {
		/*
		 * In Java, a String is an object that represents a sequence of characters. It
		 * is a fundamental and widely used class in Java programming
		 *
		 * Syntax: ======= String var_name="value";//String literals->this will only
		 * create if doesn't exists.
		 *
		 * String var_name=new String("value");//create a new object every time.
		 */
		//1.String literals
		String str1="Swathi";
		String str2="Swathi";
		
		//2.using new keyword
		String str3=new String("Swathi");
		String str4=new String("Swathi");
		System.out.println("String1:"+str1);
		System.out.println("String2:"+str2);
		System.out.println("String3:"+str3);
		System.out.println("String4:"+str4);
		System.out.println("=======================");
		/*
		 * String comparison:
		 * ==============
		 * 1.==->compares the address or reference
		 * 2..equals()->compares the values
		 * 3.compareTo->based on bytes
		 *     if two string are equal->0
		 *     else string greater than 0 -> >0
		 *      else string less than 0 -> <0 
		 *     */
		System.out.println("str1==str2"+(str1==str2));//true-this will compare the reference.
		System.out.println("str1==str3"+(str1==str3));
		System.out.println("str1==str4"+(str1==str4));
		System.out.println("=======================");
		System.out.println("str1.equals(str2): "+" "+(str1.equals(str2)));
		System.out.println("str1.equals(str3)):"+" "+(str1.equals(str3)));
		System.out.println("str1.equals(str4)):"+" "+(str1.equals(str4)));
		System.out.println("=======================");
		System.out.println("str1.compareTo(str2):"+" "+(str1.compareTo(str2)));
		System.out.println("str1.compareTo(str3):"+" "+(str1.compareTo(str3)));
		System.out.println("str1.compareTo(str2):"+" "+(str1.compareTo(str4)));
		String str5="Swathi";
		String str6=new String("Swathi").intern();
		System.out.println("=="+(str5==str6));
		
		
		
		
	}

}
