package inheritance;
//by default  we can only give  two access modifiers  for  a class-public,default,final,static.

class Student{
	//states
	public int age=23;
	public String name="Swathi";
	public double marks=230.45;
	
	public Student() {
		
	}
	
	

	//actions
	public void isPlaying() {
		System.out.println( this.name+" is playing");
	}
	public void isSleeping() {
		System.out.println( this.name+"is sleeping");
	}
	
}

public class ClassObjectsInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * class:
		 * ======
		 * class will represents the  state and behaviour  of an object
		 * state->property
		 * behaviour->action
		 * 
		 * 
		 * object:
		 * =====
		 * object is an implementation of class(state and action)
		 * ex:-
		 * =====
		 * Student
		 * 
		 * property:
		 * =====
		 * USN
		 * Name
		 * age
		 * branch
		 * 
		 * action
		 * =====
		 * isplaying()
		 * issleeping()
		 * 
		 * how to declare class and object.
		 * ====
		 * class class_name{
		 * state
		 * action
		 * }
		 * ex:-
		 * class Student{
		 * property:
		 * public int age=30;
		 * 
		 * action:
		 * public void isplaying(){
		 * syso("the student is playing");
		 * }
		 * 
		 * object :
		 * ====
		 * <datatype> variable_name=new <datatype>;
		 * Student std1=new Student();
		 * */
		
		
		Student std1=new Student();
		System.out.println(std1.name);
		System.out.println(std1.age);
		System.out.println(std1.marks);
		std1.isPlaying();
		std1.isSleeping();
		
		Student std2=new Student();
		System.out.println(std2.name);
		System.out.println(std2.age);
		System.out.println(std2.marks);
		std2.isPlaying();
		std2.isSleeping();
		
		

	}

}

