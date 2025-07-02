package practicecode;

import java.util.Scanner;

public class ArmStrongNumber {

	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the number:");
       int number=sc.nextInt();
       int originalNum=number,sum=0;
       while(number!=0) {
    	   int digit=number%10;
    	   sum +=digit*digit*digit;
    	   number=number/10;   
       }
       if(originalNum==sum) {
    	   System.out.println("Armstrong Number:");
       }
       else {
    	   System.out.println("Not a Armstrong Number:");
       }
	}

}
