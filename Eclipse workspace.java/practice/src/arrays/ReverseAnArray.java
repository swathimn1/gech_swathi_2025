package arrays;

public class ReverseAnArray {

	public static void main(String[] args) {
	int temp;
	int [] arr= {1,2,3,4,5};
	int i=0;
	int j=arr.length-1;
	while(i<j) {
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		i++;
		j--;
	}
	for(int k=0;k<arr.length;k++) {
		System.out.println(arr[k]+" ");
	}
	

}
}
