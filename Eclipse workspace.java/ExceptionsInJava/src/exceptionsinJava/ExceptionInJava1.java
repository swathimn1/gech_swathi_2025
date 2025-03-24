package exceptionsinJava;

public class ExceptionInJava1 {

	public static void main(String[] args) {
     /*
      * unchecked exception(run time)
      * */
		int a=10;
		int b=0;
//		System.out.println("Result is:"+(a/b));
		try {
			System.out.println("Result is:"+(a/b));
			
		} catch (ArithmeticException e) {
			System.out.println(e);
			System.out.println(e.getMessage());//only gives the description(text) exception.
			e.printStackTrace();//one of the method to display the error.
		}
		System.out.println("Hello World");
		
	}
		

}

