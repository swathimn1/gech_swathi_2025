package stringbuffer_in_java;

public class StringBuffer1 {

	public static void main(String[] args) {
		// StringBuffer
		// we have .capacity in string buffer to find the capacity ,by default ,16
		StringBuffer sb = new StringBuffer();
		sb.append("Swathi");
		System.out.println("sb:" + sb);
		System.out.println("initial  capacity:" + sb.capacity());
		sb.append("11111111111111111111");
		/*
		 * formula to find the capacity: (initial capacity+1)*2
		 */
		System.out.println("sb:" + sb);
		System.out.println("capacity:" + sb.capacity());
		sb.append("111111111111111111111");
		System.out.println("sb:" + sb);
		System.out.println("capacity:" + sb.capacity());

		String str1 = "123456";
		final String str2 = "123";
		String str3 = "123";

		String str4 = str2 + "456";
		String str5 = str3 + "456";
		System.out.println(str1 == str5); // false
		System.out.println(str1 == str4); // true

		/*
		 * String str1 = "123456"; "123456" is a string literal, so it goes into the
		 * String Constant Pool.
		 * 
		 * str1 refers to this interned string object.
		 * 
		 * 🔹 final String str2 = "123"; Since str2 is marked final, the compiler knows
		 * its value at compile time.
		 * 
		 * So, when you do str2 + "456", it becomes "123" + "456" → "123456" at compile
		 * time.
		 * 
		 * Therefore, str4 also refers to the same interned object as str1.
		 * 
		 * String str3 = "123"; Also refers to "123" in the string pool.
		 * 
		 * But not final, so the compiler does not treat it as a constant.
		 * 
		 * 🔹 String str5 = str3 + "456"; Since str3 is not final, the compiler treats
		 * it as a runtime expression.
		 * 
		 * So "123" + "456" is computed at runtime using StringBuilder under the hood.
		 * 
		 * The result is a new String object on the heap, not the one in the pool.
		 */

		// All wrapper classes are immutable
		/*
		 * In Java, beyond the String class, several other built-in classes are
		 * immutable, meaning their state cannot be changed after they are created.
		 * These include: Primitive Wrapper Classes: All the wrapper classes for
		 * primitive data types are immutable. This includes: 1.Integer .2Byte 3.Long
		 * 4.Float 5.Double 6.Character 7.Boolean 8.Short ================ Java 8 Date
		 * and Time API Classes (java.time package): The classes introduced in the
		 * modern Date and Time API are designed to be immutable, ensuring thread-safety
		 * and predictable behavior. Examples include: 1.LocalDate 2.LocalTime
		 * 3.LocalDateTime 4.Instant 5.ZonedDateTime =================
		 * 
		 * BigInteger and BigDecimal: ========================== These classes, used for
		 * arbitrary-precision arithmetic, are also immutable. Operations on these
		 * objects return new instances with the modified values.
		 * ============================================================================
		 * 
		 * StackTraceElement: This class, used in building exception stack traces, is
		 * immutable. ==================
		 * 
		 * Most enum classes: ================== While not a strict rule, most enum
		 * classes in the standard API are implicitly immutable, as their instances
		 * represent fixed constants. ====================================== File:
		 * ==================== Although File objects represent external entities (files
		 * on the system) whose state can change, the File object itself, representing
		 * the path, is immutable. Font and BasicStroke (from java.awt): These classes,
		 * used in graphics operations, are also immutable.
		 */

	}
	/*
	 * constructors in StringBuffer: =============================================
	 *
	 * StringBuffer()-Creates an empty buffer with default capacity (16)
	 * StringBuffer(int capacity)-Creates an empty buffer with custom initial
	 * capacity StringBuffer(String str)-Creates a buffer with initial content of
	 * the given string StringBuffer(CharSequence seq)-Initializes buffer with the
	 * given character sequence (like String, StringBuilder)
	 */

}
