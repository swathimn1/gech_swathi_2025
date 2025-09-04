package com.interruption;

class MyThread2 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Thread running ..... iteration " + i);
		}
		try {

			Thread.sleep(1000);

		} catch (InterruptedException e) {
			System.out.println("Thread was interrupted! Cleaning up....");
		}
		System.out.println("Thread ends.");

	}

}

public class Interrupt1 {

	public static void main(String[] args) {

		MyThread2 t = new MyThread2();
		t.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main Thread interrupts child thread");
		t.interrupt();
	}

}
