package String1_in_java;

public class String3 {

	public static void main(String[] args) {
		/*
		 * Mutability: String objects are immutable, meaning once a String is created,
		 * its content cannot be changed. Any operation that appears to modify a String
		 * (like concatenation) actually creates a new String object.
		 */
		String str="Swathi ";
		str=str.concat("MN");
		System.out.println("Result:"+str);
		String str1=new String("Swathi ");
		str1=str1.concat("mn");
		System.out.println("str1:"+str1);
		StringBuilder str2=new StringBuilder("Hello ");
		str2.append("World");
		System.out.println("str2:"+str2);
		StringBuffer str3=new StringBuffer("My ");
		str3.append("World");
		System.out.println("str3:"+str3);
		
		
	}

}
