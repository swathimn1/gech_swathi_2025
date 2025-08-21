package anonymous_inner_class;

public class AnonymousRunnable {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Child thread");
				}

			}

		};
		Thread th = new Thread(runnable);
		th.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("this is Main thread");
		}

	}

}
