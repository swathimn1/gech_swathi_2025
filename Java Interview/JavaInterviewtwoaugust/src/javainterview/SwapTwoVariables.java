package javainterview;

public class SwapTwoVariables {

	public static void main(String[] args) {
       int a=5,b=10;
       System.out.println("before swapping: a=" + a + ",b=" +b + " ");
       a=a+b;
       b=a-b;
       a=a-b;
       System.out.println("After swapping : a=" + a+ " ,b= "+b + " ");
	}
	

}
