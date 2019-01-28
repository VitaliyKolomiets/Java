package store;

public class Consumer implements Runnable{
	 Store store;
	 
	
	public Consumer(Store store) {
		this.store = store;
		new Thread(this).start();
	}
	@Override
	public void run() {
		
		for(int i = 1;i < 1000000;i++) {
			store.getSomething();
				
				
			}
		
	}

}
