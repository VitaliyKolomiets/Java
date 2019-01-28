package store;

public class StoreMain {

	public static void main(String[] args) {
		Store store = new Store();
		new Producer(store);
		new Consumer(store);

	}

}
