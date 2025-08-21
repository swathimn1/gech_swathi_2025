package multithreadding_in_java;
class MyThread4 extends Thread{
	
}

public class CreatingThread4 {

	public static void main(String[] args) {
		MyThread4 t1=new MyThread4();
		t1.start();
		System.out.println("Main thread");

	}

}
