package intermediate;

import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number:");
		int num=sc.nextInt();
		int originalnum=num;
		int sum=0;
		while(num>0) {
			int digit=num%10;
			sum+=digit*digit*digit;
			num/=10;
		}
		if(originalnum==sum) {
			System.out.println("armstrong number");
		}
		else {
			System.out.println("not a armstrong number");
		}

	}

	

}
