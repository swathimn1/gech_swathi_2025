package digitsadvances;

public class Harshad {

	public static void main(String[] args) {
		int num = 18;
		int sum = 0, temp = num;
		while (temp > 0) {
			sum += temp % 10;
			temp /= 10;

		}
		System.out.println(num % sum == 0 ? "Harshad" : "Not Harshad");

	}

}
