package digitsbeginner;

import java.util.Scanner;

public class CountDigits {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number:");
		int n=sc.nextInt();
		int count=0;
		while(n>0) {
			count++;
			n/=10;
		}
		System.out.println("count of digits:"+count);

	}

}
