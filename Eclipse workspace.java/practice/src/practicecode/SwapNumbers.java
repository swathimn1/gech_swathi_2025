package practicecode;

public class SwapNumbers {
public static void main(String [] args) {
	int a=5,b=10;
	System.out.println("before swapping :a="+a+",b="+b);
	int temp=a;
	a=b;
	b=temp;
	
	System.out.println("after swapping :a="+a+",b="+b);
}
}
