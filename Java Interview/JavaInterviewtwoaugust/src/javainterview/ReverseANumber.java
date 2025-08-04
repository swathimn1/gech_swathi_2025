package javainterview;

import java.util.Scanner;

public class ReverseANumber {

	public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("enter a number:");
      int num=sc.nextInt();
      int reverse=0,originalNum;
      
      originalNum=num;
      while(num >0) {
    	  int remainder=num%10;
    	  reverse=reverse*10+remainder;
    	  num=num/10;
    	  
      }
      if(originalNum==reverse) {
    	  System.out.println("reversed number:"+reverse);
      }
      else {
    	  System.out.println("the number is not reversed:"+reverse);
      }
	}
	
	

}
