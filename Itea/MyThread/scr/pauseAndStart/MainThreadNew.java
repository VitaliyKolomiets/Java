package pauseAndStart;

public class MainThreadNew {
	
	public static void main(String[] args) {
		MyThreadNew mt = new MyThreadNew();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mt.pause();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mt.resume();
		
		
		
		
	}

}
