package myMulti;

public class CallerMain {

	public static void main(String[] args) {
		Callme callme = new Callme();
		Caller cl1 = new Caller(callme,"first");
		Caller cl2 = new Caller(callme,"second");
		Caller cl3 = new Caller(callme,"third");
		
		

	}

}
