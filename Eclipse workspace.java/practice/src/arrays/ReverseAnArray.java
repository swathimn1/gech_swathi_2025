package arrays;

public class ReverseAnArray {

	public static void main(String[] args) {
		int [] arr= {1,2,3,4,5};
		for(int i=0;j=arr.length-1;i<j;i++;j--) {
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		System.out.println("Reversed Array is :");
	}

}
