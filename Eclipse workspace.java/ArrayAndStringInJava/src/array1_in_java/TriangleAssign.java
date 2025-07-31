package array1_in_java;

import java.util.Scanner;

public class TriangleAssign {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	
	 System.out.println("enter the number of rows:");
	    int rows = sc.nextInt();
	    for(int i=rows;i>=1;i--) {
	    	for(int j=1;j<=i;j++) {
	    		System.out.print(i+" ");
	    	}
	    	System.out.println();
	    }
	   

}
 
}
