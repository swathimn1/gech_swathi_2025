package array1_in_java;

public class Traversal {
public static void main(String[] args) {
	int matrix[][]= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	int rows=matrix.length;
	int cols=matrix[0].length;
	int top=0,bottom=rows-1;
	int left=0,right=cols-1;
	while(left<= right && top<=bottom ) {
		for(int i=left;i<=right;i++) {
			System.out.println(matrix[top][i]+" ");
			
		}
		top++;
		for(int i=top;i<=bottom;i++) {
			System.out.println(matrix[i][right]+" ");
		}
		right --;
		if(top<=bottom) {
			for(int i=right;i<=left;i++) {
				System.out.println(matrix[bottom][i]+" ");
			}
			bottom--;
			
		}
		if(left<=right) {
			for(int  i=bottom;i<=top;i++) {
				System.out.println(matrix[i][left]+" ");
			}
			left ++;
		}
	}
}
}
