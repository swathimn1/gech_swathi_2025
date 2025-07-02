package practicecode;

import java.io.IOException;
import java.util.Stack;

public class EvalRPN {

	public static void main(String[] args) throws IOException {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(tokens));

	}

	private static int evalRPN(String[] tokens) {
		int returnValue=0;
		String operators="+-*/";
		
		Stack<String> stack=new Stack<String>();
		for(String t:tokens) {
			if(!operators.contains(t)) {
				stack.push(t);
			}else {
				int a=Integer.valueOf(stack.pop());
				int b=Integer.valueOf(stack.pop());
				int index=operators.indexOf(t);
			
				switch(index) {
				case 0:
					stack.push(String.valueOf(a + b));
					break;
				
			    case 1:
				stack.push(String.valueOf(b - a));
				break;
			
		        case 2:
			    stack.push(String.valueOf(a * b));
		
	            case 3:
		        stack.push(String.valueOf(a / b));
	}
}

}
		returnValue=Integer.valueOf(stack.pop());

return returnValue;

}

}
