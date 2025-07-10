package practicecode;

import java.util.Scanner;

public class palindromeOrNot {
 public static void main(String [] args) {
	 Scanner sc=new Scanner(System.in);
	 int num;
	 System.out.println("enter a number:");
	 num=sc.nextInt();
	 int originalNum=num,reversed=0;
	 while(num>0) {
		 int digit=num %10;
		 reversed=reversed*10+digit;
		 num/=10;
	 }
	 if(originalNum ==reversed) {
		 System.out.println("palindrome");
	 }
	 else {
		 System.out.println("Not a palindrome");
	 }
 }
}
	 
 

