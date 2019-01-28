package myMulti;

import java.util.concurrent.TimeUnit;

public class Callme {

	Callme() {

	}
	 void getString(String msg) {
		System.out.print("[" + msg);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("]");
	
	}
}
