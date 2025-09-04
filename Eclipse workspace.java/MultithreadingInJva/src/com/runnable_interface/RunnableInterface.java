package com.runnable_interface;

class ThreadClass implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread");
		}

	}

	public void start() {
		System.out.println("start");

	}

}

public class RunnableInterface {

	public static void main(String[] args) {
		ThreadClass t1 = new ThreadClass();
		Thread th = new Thread(t1);
		th.start();
		Thread th1 = new Thread(t1);
		th1.start();// here we don't call runnable object,so it called super.start(),it will return
					// empty output.
		t1.start();
		// it will call method normally ,like normal method call,if the normal start()
		// method present,otherwise ,it will show an error
		// it will execute first than the thread class.
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
		}

	}

}
