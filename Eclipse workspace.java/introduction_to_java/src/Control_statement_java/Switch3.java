package Control_statement_java;

public class Switch3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Object obj=23;
        switch(obj) {
        case String s->System.out.println("String type");
        case  Integer i->System.out.println("Integer type");
        default->System.out.println("Invalid type");
        }
	}

}
