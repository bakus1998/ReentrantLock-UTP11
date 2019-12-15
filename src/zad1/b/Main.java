package zad1.b;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    static long s;

    public static void main(String[] args) {
        long timeMillis = System.currentTimeMillis();
        long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
        s=timeSeconds;


        BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();

        Producer p = new Producer(bq);
        Consumer c = new Consumer(bq);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();


    }
}
