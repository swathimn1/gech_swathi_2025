package exceptions;

class InvalidAgeException extends Exception {

	public InvalidAgeException(String message) {
		super(message);
	}

}

public class Exception6 {
	public static void validateAge(int age) throws InvalidAgeException {
		if (age >= 18) {
			System.out.println("your age is:" + age);
		} else {
			throw new InvalidAgeException("your age is invalid or less than 18 ");
		}
	}

	public static void main(String[] args) {
		/*
		 * to create our own exception
		 */
		try {
			validateAge(18);
		} catch (InvalidAgeException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("program completed");
		}

	}

}
