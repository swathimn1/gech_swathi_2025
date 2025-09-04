package com.runnable_interface;

class NameOfThread implements Runnable {

	@Override
	public void run() {
//		System.out.println(10 / 0);
		System.out.println("child thread:" + Thread.currentThread().getName());

	}

}

public class GettingName {

	public static void main(String[] args) {
		NameOfThread nameofThread = new NameOfThread();
		Thread th = new Thread(nameofThread);
		th.setName("Child Thread1");
		th.start();
		Thread th1 = new Thread(nameofThread);
		th1.setName("Child Thread2");
		th1.start();
		Thread th2 = new Thread(nameofThread);
		th2.setName("Child Thread3");
		th2.start();
		System.out.println("this main method run by:" + Thread.currentThread().getName());
		Thread.currentThread().setName("Hello main");
		System.out.println(10 / 0);
	}

}
