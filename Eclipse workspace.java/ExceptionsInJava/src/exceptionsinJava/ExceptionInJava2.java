package exceptionsinJava;

public class ExceptionInJava2 {

	public static void main(String[] args) {

		/*
		 * try with multiple catches 
		 * we have to go from child to parent not from parent to child.
		 */
		int[] arr = new int[2];
		arr[0] = 80;
		arr[1] = 100;

		try {
			System.out.println(arr[10]);//ArrayIndexOutOfBoundException
			System.out.println(10 / 0);//Arithmetic Exception
//	}catch(Exception e) {

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);

		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		System.out.println("Hello World");
//		System.out.println(arr);

	}
}
