package Strings;

public class ReverseAString {

	public static void main(String[] args) {
     String str="Hello";
     String reversed=new StringBuilder(str).reverse().toString();
     System.out.println("original string:"+str);
     System.out.println("reversed string:"+reversed);
	}

}
