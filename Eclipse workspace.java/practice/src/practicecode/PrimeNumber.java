package practicecode;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter an number:");
		int num=sc.nextInt();
		if(isPrime(num)) {
			System.out.println(num+" "+"is a prime number"+num);
		}
		else {
			System.out.println(num+" "+ "is not a prime number"+num);
		}
	}
		public static boolean isPrime(int num) {
			if(num<=1) {
			 return false;
			}
			for(int i=2;i<=num/2;i++) {
				if(num%i==0) {
					return false;
				}
			}
			return true;
		
	}
}