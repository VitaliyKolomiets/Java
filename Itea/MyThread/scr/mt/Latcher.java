package mt;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Latcher implements Runnable {
	CountDownLatch cd1;
	public Latcher(CountDownLatch cd1) {
		
		this.cd1 = cd1;
		new Thread(this).start();
	}
	@Override
	public void run() {
		for (int i = 0;i<5;i++) {
			System.out.println(i);
			cd1.countDown();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
