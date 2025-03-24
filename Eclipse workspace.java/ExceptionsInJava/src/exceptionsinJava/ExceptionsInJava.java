package exceptionsinJava;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExceptionsInJava {
	// recursion.
//	public static void display() {
//		display();
//	}

	public static void main(String[] args) throws FileNotFoundException {

		/*
		 * Exception In Java: ========= there is a unwanted or unexpected event occur in
		 * the programme. when ever there is a exception the normal flow will stops.
		 * 
		 * 2 types: ====== 1.checked exception(compile time)-FileNotFoundException: ====
		 * 2 ways * try catch throws 2.unchecked
		 * exception(runtime)-ArrayIndexoutofboundException
		 *
		 * 
		 * Error: ======= it is a problem when the programmer can't handle it ex: ====
		 * stack overflow error out of memory error
		 * 
		 * virtual machine error.
		 */
		// ERROR
//		ExceptionsInJava.display();

		// checked exception
		// 1.try catch
		// 2.throws
//		
//		PrintWriter printWriter = new PrintWriter("abc.txt");
//		printWriter.println("Hello World");
//		System.out.println("Hello World");
//		 
//		try {
//			PrintWriter printWriter = new PrintWriter("abc.txt");
//			printWriter.println("Hello World");
//			System.out.println("Hello World");
//			printWriter.close();
////		}catch(IOException e) {
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//			System.out.println(e);
//		}
		
		//2.throws
		PrintWriter printWriter = new PrintWriter("abc.txt");
		printWriter.println("Hello World");
		System.out.println("Hello World");
		printWriter.close();
		

	}

}
