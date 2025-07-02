package practicecode;

import java.util.Scanner;

public class SwapTwoNumbersWithThirdVariable {
  public static void main(String [] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("enter two numbers:");
	  int a=sc.nextInt();
	  int b=sc.nextInt();
	  System.out.println("Before swapping: a="+a+" ,b="+b+" ");
	  int temp;
	  temp=a;
	  a=b;
	  b=temp;
	  System.out.println("After swapping: a="+a+" ,b="+b+" ");
	
}
}
