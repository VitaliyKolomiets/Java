package multi;

public class NewThread extends Thread{
	String text;
	NewThread(String text){
		this.text = text;
		this.start();
	}
	
	@Override
	public void run() {
		System.out.println(text);
	}

}
