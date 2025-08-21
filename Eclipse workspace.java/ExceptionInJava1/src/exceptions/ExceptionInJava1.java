package exceptions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExceptionInJava1 {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Exception In Java: ========= there is a unwanted or unexpected event occur in
		 * the programme. when ever there is a exception the normal flow will stops.
		 * 
		 * 2 types: ====== 1.checked exception(compile time)-FileNotFoundException: ====
		 * 2 ways * try catch throws 2.unchecked
		 * exception(runtime)-ArrayIndexoutofboundException ===== 1 way
		 *
		 * 
		 * Error: ======= it is a problem when the programmer can't handle it ex: ====
		 * stack overflow error out of memory error virtual machine error.
		 */
		// 1.ERROR
		// stack overflow error
//		int res=fact(3);
//		System.out.println(res);
//
//	}
//
//	private static int fact(int i) {
//		
//		return i*fact(i-1);
//	}
		// parent of IoException -Exception
		// IoException
		// parent of FileNotFoundException
		
		//1st way
//		try {
//			PrintWriter printwriter = new PrintWriter("abc.txt");
//			printwriter.println("Hello world");
//			printwriter.println("12345");
//			System.out.println("Hello world");
//			printwriter.close();
//		} catch (FileNotFoundException e) {
//			System.out.println(e);
//			System.out.println(e.getMessage()); // it will give entire details
//			e.printStackTrace();
//		}
		
		//2nd way throws in main() method
		PrintWriter printwriter = new PrintWriter("abc.txt");
		printwriter.println("Hello world");
		printwriter.println("12345");
		System.out.println("Hello world");
		printwriter.close();
	}
}
