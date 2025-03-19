

	
     /*
      * byte-nextByte();
      * short-nextShort();
      * int-nextInt();
      * boolean-nextBoolean();
      * float-nextfloat();
      * double-nextDouble();*/
     package introduction_to_java_first_program;

     import java.util.Scanner;

     public class UserInputValues {

         public static void main(String[] args) {
             // Create a Scanner object
             Scanner sc = new Scanner(System.in);

             // Read student's age
             int stdAge = 0;
             System.out.println("Enter the student age:");
             stdAge = sc.nextInt();  // Reads an integer
             sc.nextLine();  // Consumes the newline character left by nextInt()
             System.out.println("The age of the student: " + stdAge);

             // Read student's name
             String name = "swathi";  // Initializing with a default value
             System.out.println("Enter the student's name:");
             name = sc.nextLine();  // Reads the full name
             System.out.println("The name of the student: " + name);

             // Read gender as a character
             System.out.println("Enter your gender (M/F):");
             char gender = sc.nextLine().charAt(0);  // Reads first character of input
             System.out.println("Gender is: " + gender);

             // Closing the Scanner object
             sc.close();
         }
     }

