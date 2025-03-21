package arraysInJava.arrays;

import java.util.Scanner;

public class ArrayInJava1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*write a programe to take a input values include
		 * size and store inside array and just print*/
		
		 Scanner sc = new Scanner(System.in);
		 System.out.println("enter the size of the array");
		 int size = sc.nextInt();
		 int[] arr = new int[size];
		 
		 System.out.println("enter the values for array");
		 for(int i=0;i<arr.length;i++) {
			 System.out.println("enter "+i+"th element");
			 arr[i]=sc.nextInt();
			 }
		 System.out.println("th array elements are");
		 for(int j=0;j<size;j++) {
			 System.out.println(arr[j]+" ");
		 }
		 sc.close();
		 

	}

}
// using user input
//package arraystringinjava.arrays;
//
//import java.util.Scanner;
//
//public class ArrayInJava1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // Taking the size of the array as input
//        System.out.print("Enter the size of the array: ");
//        int size = sc.nextInt();
//        int[] arr = new int[size];
//
//        // Taking array elements as input
//        System.out.println("Enter the values for the array:");
//        for (int i = 0; i < size; i++) {
//            System.out.print("Enter element at index " + i + ": ");
//            arr[i] = sc.nextInt();
//        }
//
//        // Displaying the array elements
//        System.out.println("\nThe array elements are:");
//        for (int j = 0; j < size; j++) {
//            System.out.print(arr[j] + " ");
//        }
//
//        // Closing the scanner
//        sc.close();
//    }
//}