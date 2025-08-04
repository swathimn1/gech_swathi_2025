package array1_in_java;

import java.util.Scanner;

public class RotateArray {

	public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("enter the size of an array:");
      int size=sc.nextInt();
      int [] arr=new int[size];
      System.out.println("enter the elements:");
      for(int i=0;i<size;i++) {
    	  arr[i]=sc.nextInt();
      }
      System.out.println("enter the positions to be rotated:");
      int k=sc.nextInt();
      k=k%size;
      for(int i=k;i<size;i++) {
    	  System.out.println(arr[i]+" ");
      }
      for(int i=0;i<k;i++) {
    	  System.out.println(arr[i]+" ");
      }
      System.out.println();
      for(int i=size-k;i<size;i++) {
    	  System.out.println(arr[i]+" ");
      }
      for(int i=0;i<size-k;i++) {
    	  System.out.println(arr[i]+" ");
      }
	}

}
