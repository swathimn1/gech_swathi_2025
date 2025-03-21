package arraysInJava.arrays;



public class StringsInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Strings
		 * =====
		 * it is group of characters
		 * ex:table
		 * need to enclose the within"".
		 * 
		 * how to declare the string
		 * ======
		 * 1.using string literal
		 * String var_name = "String_name";
		 * 
		 * 2. using new keyword
		 * 
		 * String var_name = new String("string_name");
		 */
		String str1 = "String1";
		String str2 = new String("String1");
		String str3 = "String1";
		String str4 = new String("String1");
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str1.equals(str2));//check for values
		System.out.println(str1==str2);//check for references/address
		System.out.println(str1==str3);//true
		System.out.println(str1.equals(str3));//true
		System.out.println(str2.equals(str4));//true
		System.out.println(str2==str4);//false
		//we cannot change the value of string but we can assign 
		String str5 = new String("hello");
		str5 = str5.concat("lavanya");
		System.out.println(str5);
		}

}
