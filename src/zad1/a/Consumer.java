package zad1.a;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    static int counter =0;
    @Override
    public void run() {

        while(true){
            try{
                long timeMillis = System.currentTimeMillis();
                long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
                if((timeSeconds-Main.s)>=15){
                    System.exit(0);
                }
                Thread.sleep(1000*((int)(Math.random()*3)));
                if(Main.buffer.wholeEmptyBoolean==false) {
                    System.out.println(counter + " Wartosc z consumera: " + Main.buffer.get());
                    counter++;
                }else{
                    System.out.println("Oczekiwanie na wartość w bufforze!");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
