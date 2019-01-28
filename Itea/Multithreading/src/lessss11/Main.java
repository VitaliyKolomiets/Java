package lessss11;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        CountDownLatch cd1=new CountDownLatch(5);
        CountDownLatch cd2=new CountDownLatch(5);
        CountDownLatch cd3=new CountDownLatch(5);
        CountDownLatch cd4=new CountDownLatch(5);

        ExecutorService ex= Executors.newFixedThreadPool(2);//тільки 2 потока виконуються
        ex.execute(new DemoTread("a",cd1));
        ex.execute(new DemoTread("b",cd2));
        ex.execute(new DemoTread("c",cd3));
        ex.execute(new DemoTread("d",cd4));
        System.out.println("start");

        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ex.shutdown();
        System.out.println("end");
    }
}
