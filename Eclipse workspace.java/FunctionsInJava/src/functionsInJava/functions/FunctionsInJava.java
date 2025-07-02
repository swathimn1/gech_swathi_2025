package functionsInJava.functions;

public class FunctionsInJava {
	
	//1.function accepting a parameter and returning a value
	
	public int add(int a, int b) {
		return a +b;
		
	}
	
	//2.function not accepting  a parameter and returning a value
	
	public void add3() {
		System.out.println("good morning");
		
	}
	
	//3.function accepting a parameter and not returning a value
	public void  add1(int c,int d) {
		System.out.println("function accepting a parameter and not returning a value");
	}
	//4.function not accepting a parameter and not  returning a value
	public void add2() {
		System.out.println("function not accepting a parameter and not  returning a value");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Functions/methods in java
		 * ===============
		 * <access modifier>return type function_name(parameters){
		 *code
		 *}
		 *example:
		 *public void add(int a,int b){
		 *
		 *syso(a+b);
		 *}
		 *two:
		 *===
		 *1.buit-in-next(),nextLine(),println(),equals()
		 *2.user defined:
		 *========
		 *a.function return a value not accepting a parameter
		 *b.function return a value accepting a parameter
		 *a.function not  return a value not accepting a parameter
		 *a.function  not return a value  accepting a parameter
		 * */
		FunctionsInJava obj1=new FunctionsInJava();
		int  res=obj1.add(19, 20);
		System.out.println("output is:"+res);
		obj1.add1(20,30);
		obj1.add2();
		obj1.add3();
		
		//FunctionsInJava obj2=new FunctionsInJava();
		//obj2.privateFunction();
		

	}

}
