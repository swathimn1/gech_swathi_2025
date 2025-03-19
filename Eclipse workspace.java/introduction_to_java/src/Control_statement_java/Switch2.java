package Control_statement_java;

import java.util.Scanner;

public class Switch2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int day=2;   
		 switch (day) {
		case 1 ->System.out.println("monday");
		case 2 ->System.out.println("tuesday");
		case 3 ->System.out.println("wednesday");
		case 4 ->System.out.println("thursday");
		case 5 ->System.out.println("friday");
		case 6->System.out.println("sarurday");
		case 7->System.out.println("sunday");
		default ->System.out.println("none of the conditions satisfied");
			
		
	}
		 
		 /*
		  * take user input integer
		  * check for weekdays and weekend using switch
		  * 1-5 weekdays and 6-7 using switch*/
		 
//		 Scanner sc = new Scanner(System.in);
//	        System.out.print("Enter a number (1-7): ");
//	        int week = sc.nextInt();
//	        
//	        switch (week) {
//	            case 1 -> System.out.println("weekday");
//	            case 2 -> System.out.println("weekday");
//	            case 3 -> System.out.println("weekday");
//	            case 4 -> System.out.println("weekday");
//	            case 5 -> System.out.println("weekday");
//	            case 6 -> System.out.println("weekday");
//	            case 7 -> System.out.println("weekday");
//	            default -> System.out.println("Invalid day");
//	        
//switch(week) {
//case 1,2,3,4,5->System.out.println("weekday");
//case 6,7->System.out.println("weekend");
//default->System.out.println("invalid day");
//}
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a number (1-7): ");
	        int week = sc.nextInt();

	        String res = switch (week) {
	            case 1, 2, 3, 4, 5 -> "Weekday";
	            case 6, 7 -> "Weekend";
	            default -> "Invalid day";
	        };

	        System.out.println("The result is: " + res);
	
	        

}
}
