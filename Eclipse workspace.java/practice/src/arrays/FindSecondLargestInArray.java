package arrays;

public class FindSecondLargestInArray {

	public static void main(String[] args) {
      int arr[]= {10,67,78,89,90};
      int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
      for(int num:arr) {
    	  if(num>first) {
    		  second=first;
    		  first=num;
    	  }
    	  else if(num>second && num!=first) {
    		  second=num;
    	  }
      }
      System.out.println("Second Largest Element:"+second);
	}

}
