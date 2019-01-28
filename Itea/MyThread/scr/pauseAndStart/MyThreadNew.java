package pauseAndStart;

public class MyThreadNew implements Runnable {
	boolean flag = true;
		MyThreadNew(){
			new Thread(this).start();
		}
		void pause() {
			flag = false;
		}
		synchronized void resume() {
			flag = true;
			notify();
		}
		@Override
		public void run() {
			for(int i = 0; i < Integer.MAX_VALUE;i++) {
				synchronized(this){
					while(!flag) {
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("I:"+i);
					}
				}
			}
		}
		

}
