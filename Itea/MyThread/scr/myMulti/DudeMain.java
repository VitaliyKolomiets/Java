package myMulti;

public class DudeMain {

	public static void main(String[] args) {
		Dude d1 = new Dude("A");
		Dude d2 = new Dude("B");
		Thread man1 = new Thread(d1);
		Thread man2 = new Thread(d2);
		man1.start();
		man2.start();
		while(man1.isAlive() && man2.isAlive()) {
			
		}
		if(man1.isAlive()) {
			System.out.println(d2.name + " WIN!");
		} else {
			System.out.println(d1.name + " WIN!");
		}
		
		
		
	}

}
