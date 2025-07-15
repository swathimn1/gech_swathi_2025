package practicecode;

import java.util.Scanner;

public class Armstrong {
 public static void main(String [] args) {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("enter a number:");
	 int num=sc.nextInt();
	 int originalNum=num,result=0;
	 while(num>0) {
		 int digit=num%10;
		 result+=digit*digit*digit;
		 num/=10;
	 }
	 if(result==originalNum) {
		 System.out.println("Armstrong number");
	 }
	 else {
		 System.out.println("Not a armstrong number");
	 }
 }
}
