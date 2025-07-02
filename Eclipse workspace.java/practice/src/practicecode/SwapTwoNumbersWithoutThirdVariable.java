package practicecode;

import java.util.Scanner;

public class SwapTwoNumbersWithoutThirdVariable {
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter two numbers:");
		int a =sc.nextInt();
		int b=sc.nextInt();
		System.out.println("before swapping :a=" +a  +",b=" +b +" ");
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("After swapping :a=" +a  +",b=" +b +" ");
	}

}
