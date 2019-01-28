package store;

public class Test {
	volatile static int x = 0;
	
	public static void main(String[] args) {
		new MyThreadWrite().start();
		new MyThreadRead().start();
		
	}
	
	static class MyThreadWrite extends Thread{
		@Override
		public void run() {
		for(;;) {
				System.out.println("increment x: " + (++x));
				
			}
		}
	}
	
	static class MyThreadRead extends Thread{
		@Override
		public void run() {
			
			int localVar = x;
			for(;;) {
				System.out.println(x);
				if(localVar != x) {
					System.out.println("new value is: " + x);
					localVar = x; 
				}
			}
		}
	}
	

}
