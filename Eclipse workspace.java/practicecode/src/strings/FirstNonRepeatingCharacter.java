package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.nextLine();
		Map<Character,Integer>freq=new HashMap<>();
		for(char ch:str.toCharArray()) {
			freq.put(ch,freq.getOrDefault(ch,0)+1);
		}
		for(Map.Entry<Character,Integer>entry:freq.entrySet()) {
			if(entry.getValue()==1) {
				System.out.println("first non repeating character:"+entry.getKey());
				return;
				
			}
			else {
				System.out.println("no repeating character found");
			}
			
		}

	}
	

}
