package mt;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class StringProducer implements Runnable {
Exchanger<String> ex;
String str ="";
	public StringProducer(Exchanger<String> ex) {
	
	this.ex = ex;
	new Thread(this).start();
}

	@Override
	public void run() {
		for(int i = 0; i < 5;i++) {
			for(int j = 0; i < 5;j++) {
				int rnd=(int)(Math.random()*26+65);
				str += (char)rnd;
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("Transmit " + str);
				str = ex.exchange(str);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
