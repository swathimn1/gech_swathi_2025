package final_this_super;

//final for methods-we cannot override the methods.

// final class Person {
//	public   void walking() {
//		System.out.println("person is walking");
//	}
//}
//
//class  Mohan extends Person {
//	public void walking() {
//		System.out.println("Mohan is walking");
//	}
//}


//class-we cannot extends the class when we use final for a class 
//final class Animal{
//	public void eat() {
//		System.out.println("This is implememtation of final");
//	}
//}
//
//class dog extends Animal{
//	
//}

public class FinalInJava {

	public static void main(String[] args) {
		/*
		 * final-> we cannot change the values variables,method,class variables-> the
		 * variable value cannot be changed. method-->we cannot override. class-->we
		 * cannot extends the class.
		 */
		// final for variables.
		final double PI = 3.14;
		System.out.println(PI);
		// PI=4.34;
		// System.out.println(PI);
		
		final int age=21;
		System.out.println(age);
		//age=22;

//		Mohan mohan=new Mohan();
//		mohan.walking();

	}

}
