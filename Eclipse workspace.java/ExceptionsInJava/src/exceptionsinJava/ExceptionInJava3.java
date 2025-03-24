package exceptionsinJava;

public class ExceptionInJava3 {
	public static  void validate(int age) {
		if(age<18) {
			throw new ArithmeticException("Invalid age");
		}
		else {
			
			System.out.println(" your age is:"+age);
		}
	}

	public static void main(String[] args) {
      /*
       * finally block:
       * ==========
       * * This will execute even if the execution occurs or not
       * * where we have to write the closing code like 
       * db connection, file close*/
		
	//first,the finally block will execute and the 	error will occur
	
//	try {
//		System.out.println(10/0);
//	} finally {
//		System.out.println("This is finally block 1");
//	}
		//first,the error will occur and the finally block will execute 
//	try {
//		System.out.println(10/0);
//	}catch(Exception e) {
//		System.out.println(e);
//	} finally {
//		System.out.println("This is finally block 2");
//	}
//	
		
		/*
		 * throw:
		 * ======
		 * It is used to throw the exception.*/
		try {
			validate(20);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
