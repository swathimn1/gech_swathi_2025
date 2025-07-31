package array_in_java;

public class Array1 {

	public static void main(String[] args) {
		int[] std_marks; // declaration of an array
		std_marks = new int[5];//initialization of an array
		std_marks[0] = 10;
		std_marks[1] = 100;
		std_marks[2] = 200;
		std_marks[3] = 300;
		std_marks[4] = 400;
		System.out.println("First element:" + std_marks[0]);
		System.out.println("Second element:" + std_marks[1]);
		System.out.println("Third element:" + std_marks[2]);
		System.out.println("Fourth element:" + std_marks[3]);
		System.out.println("Fifth element:" + std_marks[4]);
//    System.out.println(std_marks[5]);//ArrayIndexOutOfBoundException
	}

}
