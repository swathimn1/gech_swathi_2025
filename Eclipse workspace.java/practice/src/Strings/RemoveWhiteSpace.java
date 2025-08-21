package Strings;

public class RemoveWhiteSpace {

	public static void main(String[] args) {
      String str="hello world";
      String result=str.replaceAll("\\s","");
      System.out.println("output:"+result);
	}

}
