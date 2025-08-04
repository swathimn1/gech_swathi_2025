package abstraction_in_java;
//concrete class
// class Person{
//	public void isWalking() {//non-abstract method or concrete method
//		System.out.println("person is walking");
//	}
//	
//}
//1.abstract class
abstract class Person1{
		public abstract void isWalking() ;//abstract method or non-concrete method
		public void isSleeping() {//non-abstract method or concrete method
			System.out.println("person is sleeping");
		}	
		
}
class Student extends Person1{

	@Override
	public void isWalking() {
      System.out.println("student is walking");		
	}
	
}
public class Abstraction1 {

	public static void main(String[] args) {
		/*
		 * Abstraction ========= It is a process of hiding the implementation(body) and
		 * showing only the essential resources. 
		 * 2 ways: ======= 1.Interface(100%)
		 * 2.abstract class(0-100%) 
		 * if we want 100% abstraction,we can go for a
		 * interface. 
		 * if we want 0-100% abstraction,we can go for a abstract class.
		 * 
		 *we can't be able to create a object for a abstract class
		 *there are 2 types of methods in abstract class 
		 *1.abstract method/non-concrete method -doesn't contain a body
		 *2.non-abstract method/concrete method-contains a full  implementation or a body
		 *
		 *we can't be able to make the abstract class  static :-
		 *=========================================================
		 *because ,it contains abstract method,so to give implementation ,we have to extends the abstract method and we have to  create a object for that ,
		 *so,if we use static , we can't be able to create a object.
		 */
		Student std=new Student();
		std.isWalking();
		std.isSleeping();
		
//		Person1 p1=new Person1() {
//			
//			@Override
//			public void isWalking() {
//				
//			}
//		};

	}
	

}
