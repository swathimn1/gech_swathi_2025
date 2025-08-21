package stringbuffer_in_java;

public class MethodsInStringBuffer {

	public static void main(String[] args) {
		/**/
		// 1.Basic methods
		/*
		 * 1.length()- Returns number of characters 2.capacity() - Returns current
		 * buffer capacity
		 */

		StringBuffer sb = new StringBuffer("Hello");
		System.out.println(sb.length()); // 5
		System.out.println(sb.capacity()); // 21 (default 16 + 5)
		/*
		 * 3.ensureCapacity(int minCapacity) - Ensures min capacity 4.setLength(int
		 * newLength)- Changes length (may truncate or pad)
		 */

		/* ============================== */
		/*
		 * 5.append(...) - Adds data to the end 6.insert(int offset, ...)- Inserts at
		 * given index
		 */

		StringBuffer sb1 = new StringBuffer("Hello");
		sb1.append(" World"); // "Hello World"
		sb1.insert(5, " Java"); // "Hello Java World"
		System.out.println(sb1);

		/*
		 * delete(int start, int end)- Deletes from start to end-1 ->sb.delete(0, 5)
		 * deleteCharAt(int index)- Deletes one char ->sb.deleteCharAt(2) replace(int
		 * start, int end, String str) -Replaces with new string ->sb.replace(0, 5,
		 * "Hi")
		 */
		StringBuffer sb2 = new StringBuffer("Hello World");
		sb2.delete(5, 11); // "Hello"
		sb2.replace(0, 5, "Hi"); // "Hi"
		System.out.println(sb2);

		/*
		 * reverse() ->Reverses the characters sb.reverse() setCharAt(int index, char
		 * ch)-> Sets character at index sb.setCharAt(0, 'Y') charAt(int index) ->Gets
		 * character at index sb.charAt(2) substring(int start) ->Returns substring
		 * sb.substring(2) substring(int start, int end) ->From start to end-1
		 * sb.substring(2, 5)
		 */
		StringBuffer sb3 = new StringBuffer("Java");
		sb3.reverse(); // "avaJ"
		sb3.setCharAt(0, 'K'); // "KvaJ"
		System.out.println(sb3);

		/*
		 * toString()->Converts StringBuffer to String String s = sb.toString()
		 */
		StringBuffer sb4 = new StringBuffer("Buffer");
		String s = sb4.toString(); // s = "Buffer"
		System.out.println(s);

	}

}
