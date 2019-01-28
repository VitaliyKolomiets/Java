package multi;

public class Thread2 extends Thread {
	
	Shared shared;
	Thread2(Shared shared){
		this.shared = shared;
		start();
	}
	
	@Override
	public void run() {
		for(;;) {
			if(shared.x%2==0) {
				System.out.println(shared.x);
			}
		}
	}


}
