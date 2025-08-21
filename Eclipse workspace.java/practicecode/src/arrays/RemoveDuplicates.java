package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicates {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of an array:");
		int size=sc.nextInt();
		System.out.println("enter the elemnts:");
		int [] arr=new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		int  j=0;
//		for(int i=0;i<size-1;i++) {
//			if(arr[i]!=arr[i+1]) {
//				arr[j++]=arr[i];
//			}
//		}
		for(int i = 1;i<size;i++) {
			if(arr[i] != arr[j]) {
				arr[j++] = arr[i-1];
			}
		}
		arr[j++]=arr[size-1];
			
			System.out.println("after removing duplicates:");
			for(int k=0;k<j;k++) {
				System.out.println(arr[k]+" ");
			}
		}
	;

	}


