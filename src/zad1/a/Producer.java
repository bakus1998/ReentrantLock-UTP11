package zad1.a;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Producer implements Runnable {
    public static Lock lock;
    static int counter =0;

    public Producer(){
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        lock.lock();
        try {
            try {
                while(true)
                add();
            } finally {
                lock.unlock();
            }
        }catch (Exception e){
                System.err.println("Error");
        }

        System.out.println("END");

    }

    public void add(){
        try {
            while (!Main.buffer.checkStopStart()) {
                Thread.sleep(100*((int)(Math.random()*30)));
                int rand = (int) (Math.random() * 20);
                Main.buffer.put(rand);
            }
        }catch (Exception e){
            System.err.println("Error");
        };
    }
}
