package arraysInJava.arrays;



public class ArrayInJava2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 2D array
		 */
		int [][]arr = new int[2][2];
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 30;
		arr[1][1] = 40;
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				System.out.println(arr[i][j]+" ");
			}
		//	System.out.println();
			//use to give a space between the elements or move to next line
			
			
		}
	}

}
