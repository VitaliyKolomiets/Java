package multi;

public class Thread1 extends Thread {
	Shared shared;

	Thread1(Shared shared) {
		this.shared = shared;
		start();
	}

	@Override
	public void run() {
		for (;;) {
			if (shared.check) {
				shared.x++;
				shared.check = false;
			}
		}

	}

}
