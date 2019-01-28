package mt;

import java.util.concurrent.Exchanger;

public class MainEx {

	public static void main(String[] args) {
		Exchanger<String> ex = new Exchanger<>();
		new StringProducer(ex);
		new StringConsumer(ex);

	}

}
