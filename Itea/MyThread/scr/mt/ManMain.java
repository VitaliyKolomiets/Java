package mt;

import java.util.concurrent.CyclicBarrier;

public class ManMain {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(5,new Bus());
		new Man("A",cb,12);
		new Man("B",cb,7);
		new Man("C",cb,20);
		new Man("D",cb,6);
		new Man("E",cb,25);

	}

}
