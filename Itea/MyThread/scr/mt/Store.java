package mt;

import java.util.concurrent.Semaphore;

public class Store {
	Semaphore s = new Semaphore(1);
	Semaphore s2 = new Semaphore(0);
	volatile int product;
	volatile boolean flag = true;

	 void putSomething(int n) {
		 try {
			s.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.product = n;
		s2.release();
		System.out.println("PUT: " + n);
	}

	public  int getSomething() {
		try {
			s2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int temp = product;
		product = 0;
		System.out.println("GET: " + temp);
		s.release();
		return temp;

	}

}
