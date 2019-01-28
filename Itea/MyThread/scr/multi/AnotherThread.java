package multi;

public class AnotherThread implements Runnable {
	
	AnotherThread(){
		new Thread(this).start();
	}

	@Override
	public void run() {
		System.out.println("Hi");
		
	}

}
