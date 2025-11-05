package String1_in_java;

public class String1 {
//	static void concat(String s1) {
//		s1=s1+"forGeeks";
//	}
//	static void concat1(StringBuilder s2) {
//		s2.append("Builder");
//	}
//	static void concat2(StringBuffer s3) {
//		s3.append("Buffer");
//	}
	static void concat(String s1) {
		s1 = s1 + "forGeeks";
	}

	static void concat1(StringBuilder s2) {
		s2.append("Builder");
	}

	static void concat2(StringBuffer s3) {
		s3.append("buffer");
	}

	public static void main(String[] args) {
//     String s1="Geeks";
//     concat(s1);
//     System.out.println("String :"+s1);
//     StringBuilder s2=new StringBuilder("String");
//     concat1(s2);
//     System.out.println("String Builder:"+s2);
//     StringBuffer s3=new StringBuffer("String");
//     concat2(s3);
//     System.out.println("String buffer:"+s3);
		String s1 = "Geeks";
		concat(s1);
		System.out.println("String:" + s1);
		StringBuilder s2 = new StringBuilder("String");
		concat1(s2);
		System.out.println("StringBuilder:" + s2);
		StringBuffer s3 = new StringBuffer("string");
		concat2(s3);
		System.out.println("string buffer:" + s3);

	}

}
