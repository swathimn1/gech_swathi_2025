package array1_in_java;

import java.util.Scanner;

public class RotateArrayRight {

	public static void main(String[] args) {
    Scanner  sc=new Scanner(System.in);
    System.out.println("enter the size of an array");
    int size=sc.nextInt();
    int [] arr=new int[size];
    System.out.println("enter the elements:");
    for(int i=0;i<size;i++) {
    	arr[i]=sc.nextInt();
    	
    }
    System.out.println("enter the number of positions to be rotated:");
    int k=sc.nextInt();
    k=k % size;
    int [] rotated=new int[size];
    for(int i=0;i<size;i++) {
    	rotated[(i+k) % size]=arr[i];
    }
    System.out.println("the array after right rotating "+ k+ " positions:");
    for(int i=0;i<size;i++) {
    	System.out.println(rotated[i]);
    }
    sc.close();
	}

}
