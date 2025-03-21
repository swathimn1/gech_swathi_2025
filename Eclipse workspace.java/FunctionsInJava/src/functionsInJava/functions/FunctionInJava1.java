package functionsInJava.functions;

public class FunctionInJava1 {
	//1.public function:
			//->anywhere
	
	public void publicFunction() {
		System.out.println("this is public Function");
	}
	//2.private function
	//can be access within a class 
	private void privateFunction() {
		System.out.println("this is private Function");
	}
	//3.default function
	//can be accessed within a package
	 void defaultFunction() {
		System.out.println("this is default Function");
	}
//4.protected
	 //can be access  within a package and subclass in other package.
	 protected void protectedFunction() {
			System.out.println("this is protected Function");
		}
	 
	 //5.static function
	 //we can access using class name
	 public static void staticFunction() {
		 System.out.println("this is static function");
		 
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionInJava1 obj1=new FunctionInJava1();
		obj1.publicFunction();
		obj1.privateFunction();
		obj1.protectedFunction();
		obj1.defaultFunction();
		FunctionInJava1.staticFunction();
		
		

	}

}
