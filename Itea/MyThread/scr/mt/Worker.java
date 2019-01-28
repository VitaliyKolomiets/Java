package mt;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {
	Semaphore s;
	String name;

	Worker(Semaphore s, String name) {
		this.s = s;
		this.name = name;
		new Thread(this).start();
	}

	@Override
	public void run() {
		System.out.println(name + " started");
		try {
			System.out.println(name + " waiting...");
			s.acquire();
			System.out.println(name + " got it!");
			for(int i = 0;i < 5;i++) {
				System.out.println(Shared.count++);
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " ended");
		s.release();
	}

}
