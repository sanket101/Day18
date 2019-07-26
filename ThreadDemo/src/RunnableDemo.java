import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Abc implements Runnable{
	//Achieving synchronisation using synchronised word
//	synchronized public void run() {
//		for(int i=0;i<20;i++) {
//			System.out.println(Thread.currentThread().getName() + i);
//			try {
//				Thread.sleep(500);
//			}
//			catch(Exception e) {
//				System.out.println(e);
//			}
//		}
//	}
	
	//Achieving synchronizing using Lock and Unlock
	ReentrantLock rl = new ReentrantLock();
//	
//	public void run() {
//		
//		rl.lock();
//		
//		for(int i=0;i<20;i++) {
//			System.out.println(Thread.currentThread().getName() + i);
//			try {
//				Thread.sleep(500);
//			}
//			catch(Exception e) {
//				System.out.println(e);
//			}
//		}
//		rl.unlock();
//	}
	
	public void run() {
		
		try {
			if(rl.tryLock(15, TimeUnit.SECONDS)) {
				for(int i=1;i<=20;i++) {
					System.out.println(Thread.currentThread().getName() + ":" + i);
					Thread.sleep(500);
				}
				rl.unlock();
			}
			else {
				System.out.println(Thread.currentThread().getName() + "thread can't wait");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
}

public class RunnableDemo {
	
	public static void main(String[] args) {
		
		Abc a1 = new Abc();
		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a1);
		Thread t3 = new Thread(a1);
		
		t1.setName("a");
		t2.setName("b");
		t3.setName("c");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
