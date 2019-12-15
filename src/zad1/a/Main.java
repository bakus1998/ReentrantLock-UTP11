package zad1.a;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static Buffer buffer;
    static ExecutorService exec;
    static long s;
    public static void main(String[] args) {
        long timeMillis = System.currentTimeMillis();
        long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
        s=timeSeconds;

        System.out.println("TEN CZS " + timeSeconds);


        buffer = new Buffer(10);
        exec = Executors.newFixedThreadPool(3);
        Runnable prod = new Producer();
        Runnable consumer = new Consumer();
        exec.execute(consumer);
        exec.execute(prod);

    }
}
