package exceptions;

public class Exception5 {
	public static void isValid(int age) {
		if (age >= 18) {
			System.out.println("your age is:" + age);
		} else {
			throw new ArithmeticException("your age is ivalid or less than 18");
		}
	}

	public static void main(String[] args) {
		/*
		 * throw: 
		 * ====== 
		 * to explicitly throw an new exception.
		 */
//		isValid(10);
		try {
			isValid(20);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("program is completed");
		}

	}

}
