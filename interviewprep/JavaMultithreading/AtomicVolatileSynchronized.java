package JavaMultithreading;


/**
 * Atomic classes are more fast than synchronized block
 */

import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter{
//    private int count;

    //*******
//    private AtomicInteger count = new AtomicInteger(0);
//    public void increment(){count.incrementAndGet();}
//    public int getCount(){return count.get();}
    //*******

    private  int  count;

//    public synchronized void increment(){count++;}
    /*
    we can use it like this as well, to make the particular line as synchronized
     */
    public /*synchronized*/ void increment(){
//        System.out.println("hello!, this is not synchronized");
//        synchronized (this){
            count++;
//        }
    }
    public int getCount() {return count;}

}
public class AtomicVolatileSynchronized {
    public static void main(String[] args) throws InterruptedException {
        SharedCounter sharedCounter = new SharedCounter();

        new Thread(() ->{
            System.out.println("Thread1 started");
            for(int i = 0;i<50000;i++){
                sharedCounter.increment();
            }
            System.out.println("Thread1 completed");

        }).start();


        new Thread(() ->{
            System.out.println("Thread2 started");
            for(int i = 0;i<50000;i++){
                sharedCounter.increment();
            }
            System.out.println("Thread2 completed");

        }).start();

        Thread.sleep(10);

        System.out.println("Final Count: "+sharedCounter.getCount());
    }
}
