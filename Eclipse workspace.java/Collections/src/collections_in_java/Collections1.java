package collections_in_java;

import java.util.Arrays;
class Student{
	public int age;
	public String name;
	public int rollNo;
	public Student(int age, String name, int rollNo) {
		super();
		this.age = age;
		this.name = name;
		this.rollNo = rollNo;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", rollNo=" + rollNo + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
}

public class Collections1 {

	public static void main(String[] args) {
		/*
		 * why we need collection:
		 * ======================
		 * to overcome the drawback of array,we have to go for a collection.
		 * 
		 * drawback of array:
		 * ==================
		 * 1.fixed size
		 * 2.same data type elements
		 * 3.we cannot reduce the size of an array
		 * 
		 * advantages of an array:
		 * =========================
		 * 1.random access
		 * 2.type safety-the elements inside the array is based on the data type.
		 * 3.type casting-to print elements  the array no need to type cast.
		 * 
		 * Also we can store more then one data type using Object Array
		 * Object[] arr=new Object[5];
		 * 
		 * */
     int [] arr=new int[5];
     arr[0]=12;
     arr[1]=14;
     System.out.println(Arrays.toString(arr));
     int value=arr[0];//no need to type cast an array
     System.out.println("value:"+value);
     
     Object [] obj=new Object[5];//there is no safety
     obj[0]="Swathi";
     obj[1]=123;
     obj[2]=12.45;
     obj[3]=true;
     obj[4]=new Student(21,"Swathi",54);
     Student st=new Student(23,"Varshini",65);
     obj[4]=st;
     System.out.println(obj[4]);
     Student std=(Student)obj[4];
    
     String name=(String)obj[0];//we need type casting
     System.out.println(Arrays.toString(obj)); 
     
	}

}
