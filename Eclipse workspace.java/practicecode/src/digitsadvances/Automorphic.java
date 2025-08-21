package digitsadvances;

public class Automorphic {

	public static void main(String[] args) {
		int num = 76;
		long square = (long) num * num;
		System.out.println(String.valueOf(square).endsWith(String.valueOf(num)) ? "Automorphic" : "Not Automorphic");

	}

}
