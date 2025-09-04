package thread_execution_methods;

class MyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread:" + i);
			Thread.yield();
		}

	}

}

public class YieldMethod {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread);
		t1.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread:" + i);
		}

	}

}
