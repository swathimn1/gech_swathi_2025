package collections_in_java;

public class WrapperClasses_in_java {

	public static void main(String[] args) {
		/*
		 * java is a pure oops or not
		 * ======================================
		 * no(primitive data types
			
		 * primitive data types:
		 * ==========================
		 * byte,short,int,long,float,double,char,boolean
		 * 
		 * string name=new string("swathi");
		 * 
		 * collection
		 * ================
		 * to store group of individual objects as a single entity
		 * ===
		 * string is an object
		 * 10,20,30,40----------------integer values
		 * 
		 * Wrapper Classes:
		 * =====================================
		 * byte → Byte
			short → Short
			int → Integer
			long → Long
			float → Float
			double → Double
			char → Character
			boolean->Boolean
			comparable 
			and comparator

		 * example: new Byte(20);
		 * 
		 * 
		 *1.auto-boxing-->form primitive to wrapper
		 * */
     
		byte b = 100;
		Byte B = Byte.valueOf(b);
		System.out.println("byte:" + b);
		System.out.println("Byte:" + B);
		System.out.println("byte type:" + B.getClass().getName());

		short c = 130;
		Short C = Short.valueOf(c);
		System.out.println("short:" + c);
		System.out.println("Short:" + C);
		System.out.println("short type:" + C.getClass().getName());

		int a = 120;
		Integer a1 = a;
		Integer A = Integer.valueOf(a);
		System.out.println("int:" + a);
		System.out.println("Int:" + A);
		System.out.println("integer type:" + A.getClass().getName());

		long l = 300;
		Long L = Long.valueOf(l);
		System.out.println("long:" + l);
		System.out.println("Long:" + L);
		System.out.println("long type:" + L.getClass().getName());

		float f = 130f;
		Float F = Float.valueOf(f);
		System.out.println("float:" + f);
		System.out.println("Float:" + F);
		System.out.println("float type:" + F.getClass().getName());

		double d = 120.00;
		Double D = Double.valueOf(d);
		System.out.println("double:" + d);
		System.out.println("Double:" + D);
		System.out.println("double type:" + D.getClass().getName());

		char ch = 'm';
		Character Ch1 = Character.valueOf(ch);
		System.out.println("character:" + ch);
		System.out.println("Character:" + Ch1);
		System.out.println("character type:" + Ch1.getClass().getName());

		boolean bool = false;
		Boolean bool1 = Boolean.valueOf(bool);
		System.out.println("boolean:" + bool);
		System.out.println("Boolean:" + bool1);
		System.out.println("boolean type:" + bool1.getClass().getName());

     /*unboxing-converting from wrapper class to primitive datatypes*/
		Short S = 100;
//     short d=D;
		short s = D.shortValue();
		System.out.println("Short:" + S);
		System.out.println("short:" + s);
		System.out.println("short type:" + S.getClass().getName());

		Integer g = 134;
		int g1 = g.intValue();
		System.out.println("int:" + g1);
		System.out.println("Int:" + g);
		System.out.println("int type:" + g.getClass().getName());

		Long l1 = 123L;
		long l2 = l1.longValue();
		System.out.println("long:" + l2);
		System.out.println("Long:" + l1);
		System.out.println("long type:" + l1.getClass().getName());

		Double d1 = 123.00;
		double d2 = d1.doubleValue();
		System.out.println("double:" + d2);
		System.out.println("Double:" + d1);
		System.out.println("double type:" + d1.getClass().getName());

		Float f1 = 145F;
		float f2 = f1.floatValue();
		System.out.println("float:" + f2);
		System.out.println("Float:" + f1);
		System.out.println("float type:" + f1.getClass().getName());

		Character c1 = 's';
		char c2 = c1.charValue();
		System.out.println("char:" + c2);
		System.out.println("Char:" + c1);
		System.out.println("char type:" + c1.getClass().getName());

		Boolean b1 = true;
		boolean b2 = b1.booleanValue();
		System.out.println("boolean:" + b2);
		System.out.println("Boolean:" + b1);
		System.out.println("boolean type:" + b1.getClass().getName());
     
     
     
	}

}
