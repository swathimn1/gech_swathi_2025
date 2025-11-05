package practicecode;

import java.util.Scanner;

public class PrimeNumber {
//	public static boolean isPrime(int num) {
//		if(num<=1) {
//			return false;
//		}
//		else {
//			for(int i=2;i<=num/2;i++) {
//				if(num%i==0) {
//					return false;
//				}
//			}
//			return true;
//		}
//		
//	}
//
//	public static void main(String[] args) {
////		Scanner sc=new Scanner(System.in);
////		System.out.println("enter an number:");
////		int num=sc.nextInt();
////		if(isPrime(num)) {
////			System.out.println(num+" "+"is a prime number"+num);
////		}
////		else {
////			System.out.println(num+" "+ "is not a prime number"+num);
////		}
////	}
////		public static boolean isPrime(int num) {
////			if(num<=1) {
////			 return false;
////			}
////			for(int i=2;i<=num/2;i++) {
////				if(num%i==0) {
////					return false;
////				}
////			}
////			return true;
//		
//		Scanner sc=new Scanner(System.in);
//		int num=sc.nextInt();
//		
//		if(isPrime(num)) {
//			System.out.println(num+" is a prime number");
//		}
//		else {
//			System.out.println("not a prime number");
//		}
//		
		
//	}
	public static boolean isPrime(int num) {
		if(num<=1) {
			return false;
		}
		else {
			for(int i=2;i<=num/2;i++) {
				if(num%i==0) {
					return false;
				}
			}
			return true;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(isPrime(num)) {
			System.out.println(num+"is a prime number");
		}
		else {
			System.out.println(num+"is not a prime number");
		}
	}
}