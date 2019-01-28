package mt;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import org.omg.Messaging.SyncScopeHelper;

public class LatcherMain {

	public static void main(String[] args) {
		CountDownLatch cd1 = new CountDownLatch(5);
		CyclicBarrier cb = new CyclicBarrier(3,()->System.out.println("Hello"));
		new Latcher(cd1);
		System.out.println("CountDown starts");
		try {
			cd1.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("END");

	}

}
