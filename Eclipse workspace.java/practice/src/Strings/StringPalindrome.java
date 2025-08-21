package Strings;

public class StringPalindrome {

	public static void main(String[] args) {
     String str="Swathi";
     String reversed=new StringBuilder(str).reverse().toString();
     if(str.equals(reversed)) {
    	 System.out.println("palindrome:"+reversed);
     }
     else {
    	 System.out.println("Not palindrome:"+reversed);
     }
	}

}
