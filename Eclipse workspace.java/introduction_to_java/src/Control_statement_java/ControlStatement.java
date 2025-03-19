package Control_statement_java;

public class ControlStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * if,if else,else if ,switch
		 * 
		 * if(condition){  //if the condition is true
		 * }
		 * if(condition){
		 * 
		 * }                     //if there are 2 conditions true and false
		 * else{
		 * }
		 * 
		 * if(condition){          //if there are multiple conditions
		 * 
		 * }
		 * else if(condition){
		 * 
		 * }
		 * else if(condition){
		 * 
		 * }
		 * else if(condition){
		 * 
		 * }
		 * else{
		 * }*/
		//if condition
		int num=3;
		if(num==3) {
			System.out.println("the number is "+num);
		}
		
		//if else condition
		int num1=6;
		if(num1>0) {
			System.out.println("the number is positive"+ ""+ num1);
		}
		else {
			
			System.out.println("the number is negative:"+num1);
		}
		
		//else if ladder
		
		int num2=6;
		if(num2==1) {
			System.out.println("the number is 1"+num2);
		}
		else  if(num2==2){
			
			System.out.println("the number is 2:"+num2);
		}
       else  if(num2==3){
			
			System.out.println("the number is 3:"+num2);
		}
       else  if(num2==4){
			
			System.out.println("the number is 4:"+num2);
		}
       else  if(num2==5){
			
			System.out.println("the number is 5:"+num2);
		}
       else  {
			
			System.out.println("the number is 6:"+num2);
		}
		
		//switch statement
		int num3=4;
		switch(num3) {
		case 1 :{
		if(num2==1) {
			System.out.println("the number is 1"+num2);
			break;
		}
		}
		case 2:{
		  if(num3==2){
			
			System.out.println("the number is 2:"+num2);
			break;
		}
		}
		case 3:{
        if(num3==3){
			
			System.out.println("the number is 3:"+num2);
			break;
		}
	}
		case 4:{
        if(num3==4){
			
			System.out.println("the number is 4:"+num2);
			break;
		}
		
	}
      
      default: {
			
			System.out.println("the none of the conditions satisfied");
		}
      
      
   int day=2;   
 switch (day) {
case 1: {
	
	System.out.println("monday");
	break;
}
case 2: {
	
	System.out.println("tuesday");
	break;
}
case 3: {
	
	System.out.println("wednesday");
	break;
}
case 4: {
	
	System.out.println("thursday");
	break;
}
case 5: {
	
	System.out.println("friday");
	break;
}
case 6: {
	
	System.out.println("saturday");
	break;
}
case 7: {
	
	System.out.println("sunday");
	break;
}
default:
	System.out.println("none of the conditions satisfied");
}
		

	}
	
	}
}
