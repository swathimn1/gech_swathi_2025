package multithreadding_in_java;

class MyThread1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread:" + (i + 1));
		}
	}

}

public class CreatingThreads2 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.start();// it will create a new thread and calls run()
//		t1.run();//it won't create a new thread,it's like a normal method call
		for (int i = 0; i <= 10; i++) {
			System.out.println("Main Thread:" + (i + 1));
		}

	}

}
