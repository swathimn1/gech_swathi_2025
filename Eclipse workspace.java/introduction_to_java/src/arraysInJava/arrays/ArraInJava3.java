package arraysInJava.arrays;

import java.util.Scanner;

public class ArraInJava3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of rows and columns:");
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int [][] arr = new int[row][col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		System.out.println("array elements are:");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(arr[i][j]+" ");// add ln it gives o/p in rows
			}
			System.out.println();
		}
		
		

	}

}
// character for assignment