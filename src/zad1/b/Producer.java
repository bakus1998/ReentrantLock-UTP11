package zad1.b;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    BlockingQueue<Integer> bq;

    boolean status=true;

    public Producer(BlockingQueue bq){
        this.bq=bq;
    }
    @Override
    public void run() {
        while(status){
            try {
                Thread.sleep(1000*((int)(Math.random()*3)));
                int rand = (int)(Math.random()*20);
                bq.put(rand);
                System.out.println("Producer: " + rand);

                long timeMillis = System.currentTimeMillis();
                long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
                if((timeSeconds- Main.s)>=15){
                    System.exit(0);
                }
            }catch (Exception e){
                System.err.println("Error");
            }
        }
    }
}
