package digitsbeginner;

import java.util.Scanner;

public class ReverseADigit {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number:");
		int n=sc.nextInt();
		int reverse=0;
		while(n>0) {
			int remainder=n %10;
			reverse=reverse*10+remainder;
			n=n/10;
		}
		System.out.println("Reversed number:"+reverse);

	}

}
