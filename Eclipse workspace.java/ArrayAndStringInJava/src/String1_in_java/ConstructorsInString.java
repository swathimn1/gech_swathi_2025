package String1_in_java;

public class ConstructorsInString {

	public static void main(String[] args) {
		/*
		 * String constructors in Java:-
		 *  ==================
		 */
		String str1 = new String();
		System.out.println("string1:" + str1);
		str1 = "Swathi";
		System.out.println("string1:" + str1);

		String str2 = new String("Swathi");
		System.out.println("string2:" + str2);

		char[] arr = { 'a', 'b', 'c' };
		String str3 = new String(arr);
		System.out.println("str3:" + str3);

		byte[] arr1 = { 65, 66, 67, 97, 98 };
		String str4 = new String(arr1);
		System.out.println("str4:" + str4);

		StringBuffer ab = new StringBuffer("12345");
		String str5 = new String(ab);
		System.out.println("str5:" + str5);

	}

}
