package synchronization_in_java;
class Display{
	public synchronized void wish(String name) {
		for(int i=0;i<10;i++) {
			System.out.println("Good Morning: ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
}
class MyThread extends Thread{
	Display d;
	String name;
	public MyThread(Display d, String name) {
		super();
		this.d = d;
		this.name = name;
	}
	public void run() {
		d.wish(name);
	}
	
}

public class Synchronization1 {

	public static void main(String[] args) {
      Display d=new Display();
      MyThread t1=new MyThread(d,"swathi");
      MyThread t2=new MyThread(d,"varshi");
      t1.start();
      t2.start();
      
	}

}
