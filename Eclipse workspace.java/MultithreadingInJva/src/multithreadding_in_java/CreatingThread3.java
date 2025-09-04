package multithreadding_in_java;

class MyThread5 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("this is a child thread");
		}

	}

	public void run(String s) {
		for (int i = 0; i < 10; i++) {
			System.out.println("this is a child thread");
		}

	}

	public void run(int k) {
		for (int i = 0; i < 10; i++) {
			System.out.println("this is a child thread");
		}

	}

	@Override
	public void start() {
		super.start();
		System.out.println("this is a start method");
	}
}

public class CreatingThread3 {

	public static void main(String[] args) {
		MyThread5 t1 = new MyThread5();
		t1.start();
//		t1.start();
		System.out.println("Main thread");
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
		}

	}

}
