package operators_in_java;

public class Operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//          int a=10;
//          a++;//post increment
//          ++a;//pre increment
//          
          /*Arithmetic Operators : +,-,*,/,%
          Unary Operators :++,--
          Assignment Operator:=,+=,-=,*=,/=,%=
          Relational Operators:<,>,<=,>=,!=,==  -TRUE OR FALSE
          Logical Operators  &&,||,! - true or false
          Ternary Operator  :-?:
          Bitwise Operators:&,|,~
          Shift Operators:>>,<<
          instance of operator :instance of */
          
         // Arithmetic operators
          
          int a=10;
          int b=20;
          System.out.println("the sum is:"+(a+b));
          System.out.println("the substraction is:"+(a-b));
          System.out.println("the multiplication is:"+(a*b));
          System.out.println("the division is:"+(a/b));
          System.out.println("the modulus is:"+(a%b));
          
          //Unary operators
          int c =70;
          int d=80;
          System.out.println(c+d);
          System.out.println("the post increment is:"+(c++));
          System.out.println("the pre increment is:"+(++c));
          System.out.println("the post decrement is:"+(c--));
          System.out.println("the pre decrement is:"+(--c));
          
          //Assignment  operators
          int e=67;
         System.out.println(e+=3);
         System.out.println(e-=4);
         System.out.println(e*=5);
         System.out.println(e/=6);
         System.out.println(e%=7);
         
         
         int x = 25;
         int y = 40;

         // Relational operations
         System.out.println("x == y: " + (x == y));  // Checks if x is equal to y
         System.out.println("x != y: " + (x != y));  // Checks if x is not equal to y
         System.out.println("x > y: " + (x > y));    // Checks if x is greater than y
         System.out.println("x < y: " + (x < y));    // Checks if x is less than y
         System.out.println("x >= y: " + (x >= y));  // Checks if x is greater than or equal to y
         System.out.println("x <= y: " + (x <= y));
         
         boolean f = true;
         boolean g = false;
         
         System.out.println("Logical AND (f && g)): " + (f && g));  // false
         System.out.println("Logical OR (f || g): " + (f || g));   // true
         System.out.println("Logical NOT (!f): " + (!f));          // false

         // TERNARY OPERATOR
         int num1 = 10, num2 = 20;
         int min = (num1 < num2) ? num1 : num2;  // Ternary operation
         System.out.println("Smaller number using ternary operator: " + min);

         // BITWISE OPERATORS
         int m = 5;  // Binary: 0101
         int n = 3;  // Binary: 0011
         
         System.out.println("Bitwise AND (m & n): " + (m & n));  // 1 (0001)
         System.out.println("Bitwise OR (m | n): " + (m | n));   // 7 (0111)
         System.out.println("Bitwise XOR (m ^ n): " + (m ^ n));  // 6 (0110)
         System.out.println("Bitwise Complement (~m): " + (~m)); // -6 (inverts bits)

         // SHIFT OPERATORS
         int shiftValue = 8; // Binary: 1000

         System.out.println("Left Shift (shiftValue << 2): " + (shiftValue << 2));  // 32 (100000)
         System.out.println("Right Shift (shiftValue >> 2): " + (shiftValue >> 2)); // 2 (0010)
         System.out.println("Unsigned Right Shift (shiftValue >>> 2): " + (shiftValue >>> 2)); // 2
         
          
          
	}

}
