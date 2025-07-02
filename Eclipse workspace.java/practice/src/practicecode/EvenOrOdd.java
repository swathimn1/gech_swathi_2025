package practicecode;

import java.util.Scanner;

public class EvenOrOdd {

	public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("enter a  number");
      int number=sc.nextInt();
      if(number %2 ==0) {
    	  System.out.println("the number is an even number"+number);
    	  
      }
      else {
    	  System.out.println("the number is an odd number"+number);
      }
	}

}
