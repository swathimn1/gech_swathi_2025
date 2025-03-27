package com.CustomStudent;

public class Student {
	 String name;
     int roll_num;
     int age;

     public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll_num() {
		return roll_num;
	}
	public void setRoll_num(int roll_num) {
		this.roll_num = roll_num;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(String name, int roll_num, int age) {
		super();
		this.name = name;
		this.roll_num = roll_num;
		this.age = age;
	}
     @Override
 	public String toString() {
 		return "Student [name=" + name + ", roll_num=" + roll_num + ", age=" + age + "]";
 	}




	
	}
