package array_in_java;

import java.util.Scanner;

public class SecondLargestAndSecondSmallest {

	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.println("enter the size of an array");
       int size=sc.nextInt();
       int [] arr=new int [size];
       System.out.println("enter the elements:");
       for(int i=0;i<arr.length;i++) {
    	   System.out.println("enter "+(i+1)+" elements:");
    	   arr[i]=sc.nextInt();
       }
       int largest=arr[0];
       int smallest=arr[0];
       for(int i=0;i<size;i++) {
    	   if(arr[i]>largest) {
    	   largest=arr[i];
    	   }
    	   if(arr[i]<smallest) {
    	    	  arr[i]=smallest;
    	      }
       }
       System.out.println("largest element in an array:"+largest);
       System.out.println("smallest  element in an array:"+smallest);
      int secondLargest=Integer.MIN_VALUE;
      int secondSmallest=Integer.MAX_VALUE;
      for(int i=0;i<size;i++) {
    	  if(arr[i]>secondLargest  && arr[i] < largest) {
    		  secondLargest=arr[i];
    	  }
    	  if(arr[i] < secondSmallest && arr[i] > smallest) {
    		  secondSmallest=arr[i];
    	  }
      }
      if(secondLargest==Integer.MIN_VALUE) {
    	  System.out.println("no second largest element found in an array");
      }
      else {
    	  
    	  System.out.println("second largest element in an array is: "+secondLargest);
      }
      if(secondSmallest==Integer.MAX_VALUE) {
    	  System.out.println("no second largest element found in an array");
      }
      else {
    	  System.out.println("second smallest element in an array is :"+secondSmallest);
      }
	}

}
