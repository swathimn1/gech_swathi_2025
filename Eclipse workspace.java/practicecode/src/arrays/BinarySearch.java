package arrays;

import java.util.Scanner;

public class BinarySearch {
	public static int BinarySearch(int[] arr, int target) {
//		int low = 0, high = arr.length - 1;
//		while (low <= high) {
//
//			int mid = low + (high - low) / 2;
//			if (arr[mid] == target) {
//
//				return mid;
//			} else if (arr[mid] < target) {
//				low = mid + 1;
//
//			} else {
//				high = mid - 1;
//			}
//		}
//
//		return low;
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter the size of an array:");
//		int size = sc.nextInt();
//		System.out.println("enter the elements:");
//		int[] arr = new int[size];
//		for (int i = 0; i < size; i++) {
//			arr[i] = sc.nextInt();
//		}
//		System.out.println("enter target:");
//		int target = sc.nextInt();
//		int result = BinarySearch(arr, target);
//		System.out.println(result);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of an array:");
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println("enter the elements:");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("enter the target");
		int target = sc.nextInt();
		int result = BinarySearch(arr, target);
		System.out.println(result);
	}

}
