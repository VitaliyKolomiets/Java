package mt;

import java.util.concurrent.Semaphore;

public class SM {

	public static void main(String[] args) {
		Semaphore s = new Semaphore(2);
		new Worker(s,"A");
		new Worker(s,"B");

	}

}
