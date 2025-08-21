package exceptions;

public class Exception8 {

	public static void main(String[] args) {
		try {
			int [] a= {1,2,3,4,5};
			System.out.println(a[5]);
			
			try {
				int x=a[2]/0;
			}catch(ArithmeticException e) {
				System.out.println("Division by zero is not possible");
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException");
			System.out.println("Element at such index does not exists");
		}
		/*
		 * working of  nested try blocks
		 * ================================
		 * if the exception occurs at the parent outer block,error message of the parent shows ,but the inner block will not executed.
		 * if the exception occurs at the child inner block ,if the catch does not handle the exception correctly,it will go to the parent outer block.  
		 * */
	
		/*
		 * we cannot have a single try with multiple finally blocks.
		 * */

		
		
	}
	}
		


