package lessss11;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DogMain {
    public static void main(String[] args) {
        ExecutorService ex= Executors.newFixedThreadPool(3);//тільки 3 потока виконуються
        Future<String> f1;//повертає string значення
        Future<String> f2;
        Future<String> f3;
        System.out.println("start");
        f1=ex.submit(new Dog("a",3));
        f2=ex.submit(new Dog("b",4));
        f3=ex.submit(new Dog("c",5));


        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ex.shutdown();
    }
}
