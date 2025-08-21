package arrays;

import java.util.Scanner;

public class MisiingNumber {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		 System.out.println("Enter the size of first array:");
	        int n1 = sc.nextInt();
	        int[] arr1 = new int[n1-1];
	        int sum=0;
	        System.out.println("Enter the elements of  array : ");
	        for (int i = 0; i < n1-1; i++) {
	            arr1[i] = sc.nextInt();
	            sum+=arr1[i];
	        }
	        int totalSum=n1*(n1+1)/2;
	        System.out.println("missing number:"+(totalSum-sum));
	        
	}

}
