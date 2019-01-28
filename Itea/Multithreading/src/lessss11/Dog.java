package lessss11;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Dog implements Callable<String> {

    String name;
    int sleep;

    public Dog(String name, int sleep) {

        this.name = name;
        this.sleep = sleep;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(sleep);
        return "hello from dog"+name;
    }
}
