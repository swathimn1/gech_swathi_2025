package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exception7 {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Error reading file:" + e.getMessage());
		}
		/*
		 * The try-with-resources statement, introduced in Java 7, is a construct
		 * designed to simplify resource management by automatically closing resources
		 * that implement the AutoCloseable interface. This eliminates the need for
		 * explicit finally blocks to ensure resources are closed, even when exceptions
		 * occur.
		 */
	}

}
