package thread_execution_methods;

class MyThread2 implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started execution");
		for (int i = 0; i < 20; i++) {
			System.out.println("Child Thread:" + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " completed execution");
	}

}


public class JoinMethod {

	public static void main(String[] args) {
		MyThread2 myThread = new MyThread2();
		Thread thread = new Thread(myThread);
		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " started execution");
		for (int i = 0; i < 20; i++) {
			System.out.println("Main Thread:" + i);
		}
		System.out.println(Thread.currentThread().getName() + " completed execution");
	}

}
