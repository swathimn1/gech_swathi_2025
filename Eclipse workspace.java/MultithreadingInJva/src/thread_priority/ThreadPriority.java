package thread_priority;

class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println("This is child thread");
		System.out.println("the name of the child thread is:" + Thread.currentThread().getName());
		System.out.println("the priority of the child thread is:" + Thread.currentThread().getPriority());

	}

}

public class ThreadPriority {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread);
//		t1.setPriority(17);//IllegalArgumentException
		t1.setPriority(9); // the range of thread has to be in the range of 1-10.
		
//		t1.setPriority(Thread.MIN_PRIORITY);//1
//		t1.setPriority(Thread.NORM_PRIORITY);//5
//		t1.setPriority(Thread.MAX_PRIORITY);//10
//		
//		try {
//			t1.join();//wait for one thread to complete it's execution
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		t1.start();
//		for (int i = 0; i < 10; i++) {
//			System.out.println("This is the main thread");
//
//		}

		System.out.println("the name of the main thread:" + Thread.currentThread().getName());
		System.out.println("the priority the main thread:" + Thread.currentThread().getPriority());

	}

}
