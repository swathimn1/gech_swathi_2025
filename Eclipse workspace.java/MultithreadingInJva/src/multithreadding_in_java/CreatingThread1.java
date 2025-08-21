package multithreadding_in_java;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("Child Thread:" + (i + 1));
		}

	}

}

public class CreatingThread1 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable());
		t1.start();
		for (int i = 1; i <= 10; i++) {
			System.out.println("Main Thread:" + (i + 1));
		}

	}

}
