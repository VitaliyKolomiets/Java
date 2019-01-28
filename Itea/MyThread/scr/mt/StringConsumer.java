package mt;

import java.util.concurrent.Exchanger;

public class StringConsumer implements Runnable {
Exchanger<String> ex;
String str = "";

public StringConsumer(Exchanger<String> ex) {
	this.ex = ex;
	new Thread(this).start();
}
@Override
public void run() {
	for(int i = 0; i < 5;i++) {
		
			try {
				str=ex.exchange("");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
}
