package arrays;

import java.util.Scanner;
import java.util.Stack;

public class ValidParanthesis {
	public static boolean isValid(String s) {
//		Stack<Character> stack=new Stack<>();
//		for(char ch:s.toCharArray()) {
//			if(ch=='(') {
//				stack.push(')');
//			}
//			else if(ch=='[') {
//				stack.push(']');
//			}
//			else if(ch=='{') {
//				stack.push('}');
//			}else if(stack.isEmpty()||stack.pop()!=ch) {
//				return false;
//			}
//		}
//		return stack.isEmpty();
//	}
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				stack.push(')');
			} else if (ch == '{') {
				stack.push('}');
			} else if (ch == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != ch) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a string");
		String str = sc.nextLine();
		boolean result = isValid(str);
		System.out.println("valid paranthesis:" + result);

	}

}
