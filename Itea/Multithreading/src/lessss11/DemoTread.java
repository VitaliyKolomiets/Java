package lessss11;

import java.util.concurrent.CountDownLatch;

public class DemoTread implements Runnable {

    String name;
    CountDownLatch cd;

    public  DemoTread(String name, CountDownLatch cd){
        this.name=name;
        this.cd=cd;
        //new Thread(this);
    }



    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            System.out.println(name+" : "+i);
            cd.countDown();
        }
    }
}
