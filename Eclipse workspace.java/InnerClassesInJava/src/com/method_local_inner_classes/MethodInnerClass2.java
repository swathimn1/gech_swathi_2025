package com.method_local_inner_classes;

public class MethodInnerClass2 {
	public int a=10;
	public static int b=30;
	//public static void m1() { 
	public void m1() {
		int z=20;
		final class Inner {// we can declare inner class as the final or the abstract not public,private or any
			int z1=22;
			public void m2() {
				System.out.println("This is method local inner class");
				System.out.println(a+" "+b+" "+z1+" "+z);
			}
		}
		Inner in = new Inner();
		in.m2();
	}

	public static void main(String[] args) {
		new MethodInnerClass2().m1();
	}

}
