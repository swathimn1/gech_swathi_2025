package digitsbeginner;

import java.util.Scanner;

public class palindrome {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number:");
		int num=sc.nextInt();
		 int originalnum=num,reverse=0;
		while(num!=0) {
			int remainder=num%10;
			reverse=reverse*10+remainder;
			num/=10;
			
		}if(originalnum==reverse) {
		System.out.println("palindrome");
		}

	}

}
