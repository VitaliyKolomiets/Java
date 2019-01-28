package multi;

public class MainThread {

	public static void main(String[] args) {
		System.out.println("Start");
		new NewThread("Hellooo");
		new AnotherThread();
		System.out.println(Thread.activeCount());
		System.out.println("End");
//		
//		Shared shared = new Shared();
//		new Thread1(shared);
//		new Thread2(shared);
	}

}
