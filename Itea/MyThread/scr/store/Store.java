package store;

public class Store {
	volatile int product;
	volatile boolean flag = true;

	synchronized void putSomething(int n) {
		while (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		this.product = n;
		flag = false;
		System.out.println("PUT: " + n);
		notify();
	}

	public synchronized int getSomething() {
	    
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		int temp = product;
		
		product = 0;
		flag = true;
		System.out.println("GET: " + temp);
		notify();
		
		return temp;

	}

}
