package mt;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Man implements Runnable {
	String name;
	CyclicBarrier cb;
	int sleepTime;

	public Man(String name, CyclicBarrier cb, int sleepTime) {
		
		this.name = name;
		this.cb = cb;
		this.sleepTime = sleepTime;
		
		new Thread(this).start();
	}

	@Override
	public void run() {
		
		System.out.println(name + " starting his way to bus");
		try {
			TimeUnit.SECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " reached bus station"); 
		try {
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
