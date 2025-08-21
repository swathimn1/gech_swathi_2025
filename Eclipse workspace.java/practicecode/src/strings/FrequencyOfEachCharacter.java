package strings;

import java.util.HashMap;
import java.util.Scanner;

public class FrequencyOfEachCharacter {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.nextLine();
		HashMap<Character,Integer> freq=new HashMap<>();
		for(char ch:str.toCharArray()) {
			freq.put(ch, freq.getOrDefault(ch,0)+1);
		}
		System.out.println("character frequencies:");
		for(char ch:freq.keySet()) {
			System.out.println(ch+"->"+freq.get(ch));
		}
	}

	
}
