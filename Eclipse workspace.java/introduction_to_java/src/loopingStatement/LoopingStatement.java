package loopingStatement;

public class LoopingStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    /*
     * for loop -for(ini;i<=5;inc/dec)
     * for(int i=0;i<=5;i++)
     * while loop 
     * ini
     * while(condition){
     *code
     *inc/dec;
     
     * }
     * do-while loop
     * ini
     * do{
     * syso
     * inc/dec
     * }while(condition)
     * 
     * for each loop 
     * ====
     * for(<datatype> variable_name:collection){
     * }
     * */
		
		//for loop
		int  num=5;
		for(int i=0;i<=5;i++) {
			System.out.println(num);
		}
		//while loop
		int num1=5;
		while(num1<=5) {
			System.out.println(num1);
			num1++;
		}
		  
		int num2=10;
		do {
			 System.out.println(num2);
			num2++;
		}while(num2<=10);
		
		
		int[]  arr= {1,2,3,4,5};
		for(int a:arr){
			System.out.println(a);
		}
		//
	}
	
	
	 
}
	


