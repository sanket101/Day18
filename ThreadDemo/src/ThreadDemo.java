class A extends Thread{
	
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("i : " + i);
			try {
				Thread.sleep(3000);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}

class B extends Thread{
	
	public void run() {
		for(int j=0;j<20;j++) {
			System.out.println("j : " + j);
			try {
				Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}

class C extends Thread{
	
	public void run() {
		for(int k=0;k<20;k++) {
			System.out.println("k : " + k);
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}

public class ThreadDemo {
	
	public static void main(String[] args) throws Exception {
		
		A a1 = new A();
		B b1 = new B();
		C c1 = new C();
		
		a1.start();
		b1.start();
		c1.start();
		
		//Thread.sleep(10000);
		
		a1.setName("Raju");
		a1.setPriority(8);
		
		Thread m1 = Thread.currentThread();
		
		System.out.println(a1);
		System.out.println(b1);
		System.out.println(c1);
		System.out.println(m1);
		
		System.out.println("Main Exits!");
	}
}
