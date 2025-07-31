package arraysInJava.arrays;

public class ArrayInJava {

	public static void main(String[] args) {

		/*
		 * arrays in java
		 * 
		 * if we want to store a  different values of same datatype
		 * how to declare a array
		 * <datatype>[]=new <datatype>[size];
		 * int [] array1=new int[3];
		 * int [] array={1,2,3,4,5};
		 *  types:
		 *  ======
		 *  1.1D->single row 
		 *  int [] array1=new int[4];
		 *  2.2D-> in the  form of tables.
		 *  int [][] array2=new  int[4][3];
		 *  
		 *  
		 * */
		
		int [] arr=new int[5];
		arr[0]=30;
		arr[1]=32;
		arr[2]=34;
		arr[3]=36;
		arr[4]=38;
		arr[5]=40;
		for(var i:arr) {
			System.out.println(i+" ");
		}
	}

}
