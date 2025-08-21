package String1_in_java;

public class MethodsInString {

	public static void main(String[] args) {
		// 1.length()-Returns the length of the string
		String str1 = "Hello";
		String str2 = "hello";
		System.out.println(str1.length());

		// 2.charAt(int index)-Returns character at the specified index
		System.out.println(str1.charAt(2));

		// 3.codePointAt(int index)-Returns Unicode code point at index
		System.out.println(str1.codePointAt(0));

		// 4.equals(Object obj)-Compares string contents/values (case-sensitive)
		System.out.println(str1.equals(str2));

		// 5.equalsIgnoreCase(String anotherString)-Ignores case
		System.out.println(str1.equalsIgnoreCase(str2));

		// 6.concat(String str)-Concatenates strings
		System.out.println(str1.concat(str2));

		// 7.replace(char oldChar, char newChar)-Replaces all occurrences
		System.out.println(str2.replace("h", "Hello"));

		System.out.println("==================");
		// Substring and search
		String s = "banana";
		// 8contains(String s)-Checks substring
		System.out.println(s.contains("nan")); // true

		// 9.startsWith(String s)-Checks prefix
		System.out.println(s.startsWith("ba"));// true

		// 10.endsWith(String s)-Checks suffix
		System.out.println(s.endsWith("na")); // true

		// 11.indexOf(String s)- index of element
		System.out.println(s.indexOf("a")); // 1

		// 12.lastIndexOf(String "a")-last index of element
		System.out.println(s.lastIndexOf("a")); // 5

		// 13.substring(int begin, int end)-From begin to end-1
		System.out.println(s.substring(1, 4));

		System.out.println("======================");
		// Modify Strings
		String str3 = " Hello ";

		// 14.trim()-Removes leading/trailing spaces
		System.out.println(s.trim()); // "Hello"

		// 15.replace(char old, char new)-Replaces chars
		System.out.println(s.replace("e", "a")); // " Hallo "

		// 16.replaceAll(String regex, String replacement)-Replaces using regex
		System.out.println(s.replaceAll("\\s", "")); // "Hello"

		System.out.println("ha".repeat(3));
		// "hahaha"
		System.out.println("=========");
		// Case conversion
		String str4 = "Java";
		System.out.println(s.toUpperCase()); // "JAVA"
		System.out.println(s.toLowerCase());
		// "java"
		// Splitting and joining
		String str5 = "a,b,c";
		String[] parts = s.split(",");

		for (String part : parts) {
			System.out.print(part + " "); // a b c
		}

		String joined = String.join("-", "a", "b", "c");
		System.out.println(joined);

		// a-b-c
		// whitespace Check
		String str6 = "   ";
		System.out.println(s.isBlank()); // true (only whitespace)
		System.out.println(s.isEmpty()); // false (length is 3)

		// Formatting and Transform
		String formatted = String.format("Hello %s", "Swathi");
		System.out.println(formatted); // Hello Swathi

		String upper = "java".transform(String::toUpperCase);
		System.out.println(upper); // JAVA

		String str7 = "test";
		System.out.println(s.toString()); // "test"
		System.out.println(s.hashCode()); // e.g., 3556498

		// comparison
		String a = "Java";
		String b = "java";

		System.out.println(a.equals(b)); // false
		System.out.println(a.equalsIgnoreCase(b)); // true
		System.out.println(a.compareTo("Javb"));

		// -1
		// Creation & Conversion

		String str8 = String.valueOf(123);
		System.out.println(str8);// "123"
		char[] chars = "hello".toCharArray();
		System.out.println(chars);// ['h', 'e', 'l', 'l', 'o']
		byte[] bytes = "abc".getBytes();
		System.out.println(bytes); // [97, 98, 99]
		String pooled = "abc".intern();
		System.out.println(pooled);// Returns pooled version from string pool

		String str9 = "Swathi";
		String str10 = new String("Swathi").intern();
		System.out.println("==" + (str9 == str10));
		/*
		 * String.intern() in Java The intern() method in Java is used to ensure that
		 * all identical String objects share the same memory location in the String
		 * Constant Pool. It's a special memory area inside the Java heap that stores
		 * unique string literals.
		 * 
		 * Java automatically stores string literals in this pool to save memory.
		 * ====================== Purpose of intern() If the string already exists in
		 * the pool, it returns the reference to the pooled string.
		 * 
		 * If it does not exist, it adds it to the pool and returns the reference. When
		 * to Use intern() When memory optimization is important (e.g., many duplicate
		 * strings).
		 * 
		 * In large-scale applications like compilers, symbol tables, etc.
		 */
	}

}
