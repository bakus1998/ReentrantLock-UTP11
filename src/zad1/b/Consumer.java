package zad1.b;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    BlockingQueue<Integer> bq;

    public Consumer(BlockingQueue bq){
        this.bq=bq;
    }


    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(1000*((int)(Math.random()*3)));
                System.out.println("Consumer: " + bq.take());
            }catch (Exception e){
                System.err.println("Error");
            }
        }
    }
}
