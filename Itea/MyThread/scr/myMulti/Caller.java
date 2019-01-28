package myMulti;

public class Caller implements Runnable {
	 Callme callme;
	 String msg;

	public Caller(Callme callme, String msg) {
		this.callme = callme;
		this.msg = msg;
		new Thread(this).start();
	}

	@Override
	public void run() {
		synchronized(callme) {
	callme.getString(msg);	
		}
	}

}
