package strings;

import java.util.Scanner;

public class CountVowels {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.nextLine().toLowerCase();
		int vowels=0,consonants=0,digits=0,spaces=0;
		for(char ch:str.toCharArray()) {
			if("aeiou".indexOf(ch)!=-1)
				vowels++;
			else if(ch>='a' && ch<='z')consonants++;
			else if(ch >='0' && ch<='9')digits++;
			else if(ch==' ')spaces ++;
				
		}
		System.out.println("vowels:"+vowels);
		System.out.println("consonants:"+consonants);
		System.out.println("digits:"+digits);
		System.out.println("spaces:"+spaces);

	}
	

}
