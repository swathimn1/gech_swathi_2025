package strings;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter first string");
		String str1=sc.nextLine().toLowerCase();
		System.out.println("enter second string:");
		String str2=sc.nextLine().toLowerCase();
		if(str1.length()!=str2.length()) {
			System.out.println("not an anagram");
		}
		char[] arr1=str1.toCharArray();
		char[] arr2=str2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if(Arrays.equals(arr1, arr2)) {
			System.out.println("anagram");
		}
		else {
			System.out.println("not an anagram");
		}

	}
	

}
