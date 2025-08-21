package java1;

import java.util.Scanner;

public class SecondSmallestdigit {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a digit:");
		int num=sc.nextInt();
		int digit=num/10;
	    
		int maxdigit=0;
		int min=0;
		if(digit>maxdigit) {
			maxdigit=digit;
		}
		
		int secondmaxdigit=min;
         if(digit>secondmaxdigit && digit<maxdigit) {
        	 secondmaxdigit=digit;
        	 
         }
         System.out.println("second maximum digit:"+secondmaxdigit);
	}
	
	

}
