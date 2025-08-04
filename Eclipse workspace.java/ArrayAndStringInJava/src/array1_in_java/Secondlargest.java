package array1_in_java;

import java.util.Scanner;

public class Secondlargest {

	public static void main(String[] args) {
		Scanner  sc=new Scanner(System.in);
	    System.out.println("enter the size of an array");
	    int size=sc.nextInt();
	    int [] arr=new int[size];
	    System.out.println("enter the elements:");
	    for(int i=0;i<size;i++) {
	    	arr[i]=sc.nextInt();
	    	
	}
	    int min=arr[0];
	    int max=arr[0];
	    for(int i=0;i<size;i++) {
	    	if(arr[i]>max) {
	    		max=arr[i];
	    	}
	    	if(arr[i]<min) {
	    		min=arr[i];
	    	}
	    }
	    int secondMax=min;
	    int secondMin=max;
	    for(int i=0;i<size;i++) {
	    	if(arr[i]>secondMax && arr[i]<max) {
	    		secondMax=arr[i];
	    	}
	    	if(arr[i]<secondMin && arr[i]>min) {
	    		secondMin=arr[i];
	    	}
	    }
	    System.out.println(secondMax);
	    System.out.println(secondMin);
	   
	}

}
