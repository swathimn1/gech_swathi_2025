package multithreadding_in_java;

class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread:" + (i + 1));
		}
	}

}

public class CreatingThread {

	public static void main(String[] args) {
		MyThread MyThread = new MyThread();
		MyThread.start();// one more thread will be created(child1).

		System.out.println("Main Thread");

		/*
		 * start() → starts the thread (calls run() internally).
		 * 
		 * run() → contains the code executed by the thread.
		 * 
		 * sleep(ms) → pauses the thread for given time.
		 * 
		 * join() → waits for a thread to finish.
		 * 
		 * setPriority() → sets thread priority (MIN_PRIORITY=1, NORM_PRIORITY=5,
		 * MAX_PRIORITY=10).
		 * 
		 * isAlive() → checks if thread is still running.
		 */

	}

}
